package com.jgefroh.rms.client.mvp.presenters;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.mvp.models.UserVO;
import com.jgefroh.rms.client.mvp.views.composites.AlertPanel.AlertType;
import com.jgefroh.rms.client.mvp.views.interfaces.AccountView;
import com.jgefroh.rms.client.mvp.views.interfaces.AccountView.Presenter;
import com.jgefroh.rms.client.services.UserService;
import com.jgefroh.rms.client.services.UserServiceAsync;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;
import com.jgefroh.rms.client.util.PasswordStrengthCalculator;
import com.jgefroh.rms.client.util.PasswordStrengthCalculator.PasswordStrength;
import com.jgefroh.rms.client.util.models.EmailAddress;
import com.jgefroh.rms.client.util.ruleengine.AccountRuleEngine;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.RuleID;
import com.jgefroh.rms.client.util.ruleengine.BusinessRuleResult;
import com.jgefroh.rms.client.util.validation.interfaces.ValidationResult;
import com.jgefroh.rms.shared.RMSException;

/**
 * The presenter for the Account view.
 * @author Joseph Gefroh
 */
public class AccountPresenter implements Presenter {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private AccountView view;
    private ClientFactory clientFactory;
    private PasswordStrengthCalculator passwordStrengthCalc;

    private UserServiceAsync userService = GWT.create(UserService.class);
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public AccountPresenter(final ClientFactory clientFactory) {
         this.clientFactory = clientFactory;
         passwordStrengthCalc = new PasswordStrengthCalculator();
    }
    
    
    //////////////////////////////////////////////////
    // Methods - MVP
    //////////////////////////////////////////////////
    
    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    @Override
    public void bind(AccountView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void resetView() {
        view.reset();
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Mapping
    //////////////////////////////////////////////////
    
    @Override
    public void mapModelToView(final UserVO user) {
        view.setFullname(user.getFullname());
        view.setEmail(user.getEmail());
        view.setNickname(user.getNickname());
    }

    private AccountDTO mapViewToModel() {
        AccountDTO account = new AccountDTO();
        account.setUserID(AppCache.getCurrentUser().getUserID());
        account.setEmail(view.getEmail());
        account.setFullname(view.getFullname());
        account.setNickname(view.getNickname());
        return account;
    }

    
    //////////////////////////////////////////////////
    // Methods - Save
    //////////////////////////////////////////////////
    
    @Override
    public void requestSave() {
        AccountDTO dto = mapViewToModel();
        AccountRuleEngine accountRules = new AccountRuleEngine();
        Map<RuleID, BusinessRuleResult> rules = accountRules.evaluate(dto);
        boolean hasBrokenRules = accountRules.hasBrokenRules(rules);
        if (!hasBrokenRules) {
            save(dto);
        }
        else {
            view.showAlert(AlertType.DANGER, "Oops.", "There's some problems with the form. Please fix them and try again.");
        }
    }
    
    private void save(final AccountDTO account) {
        userService.update(account, new AsyncCallback<Boolean>() {
            @Override
            public void onSuccess(final Boolean result) {
                if (result) {
                    AppCache.getCurrentUser().setFullname(account.getFullname());
                    AppCache.getCurrentUser().setNickname(account.getNickname());
                    AppCache.getCurrentUser().setEmail(account.getEmail());
                    view.showAlert(AlertType.SUCCESS, "Success!", "Your changes were saved.", 2000);
                }
                else {
                    onFailure(new RMSException());
                }
            }
            
            @Override
            public void onFailure(final Throwable caught) {
                view.showAlert(AlertType.DANGER, "Error", "Your changes weren't able to be saved.");
            }
        });
    }
    

    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////

    @Override
    public void validateEmail(final String email) {
        EmailAddress emailAddress = new EmailAddress(email);
        ValidationResult validationResult = emailAddress.validate();
        interpretEmailValidationResult(validationResult);
    }
    
    private void interpretEmailValidationResult(final ValidationResult result) {
        String errorMessage = null;
        if (!result.isPresent()) {
            errorMessage = "Email cannot be empty.";
        }
        else if (result.isInvalid()) {
            errorMessage = EmailAddress.getErrorMessage(result);
        }
        view.setEmailMessage(errorMessage);
    }
    
    @Override
    public void validateFullname(final String fullname) {
        view.setFullnameMessage(fullname == null ? "Full name cannot be empty." : null);
    }
    
    @Override
    public void validateNickname(final String nickname) {
        view.setNicknameMessage(nickname == null ? "Nickname cannot be empty." : null);
    }

    @Override
    public void updateStrengthMeter(final String password) {
        int strength = passwordStrengthCalc.calculateStrength(password);
        PasswordStrength strengthCategory = passwordStrengthCalc.convertStrengthToCategory(strength);
        view.setPasswordStrength(strengthCategory);
    }
}
