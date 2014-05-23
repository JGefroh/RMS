package com.jgefroh.rms.client.util.ruleengine;

import java.util.HashMap;
import java.util.Map;

import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.ContextID;


public class AccountRuleEngine extends AbstractBusinessRuleEngine<AccountDTO> {
    
    private Map<ContextID, Object> context;
    
    public AccountRuleEngine() {
        context = new HashMap<ContextID, Object>();
        add(new AccountHasFullnameRule());
        add(new AccountHasNicknameRule());
        add(new AccountHasEmailRule());
        add(new AccountEmailValidRule());
    }
    
    @Override
    public Map<ContextID, Object> getContext() {
        return this.context;
    }
}
