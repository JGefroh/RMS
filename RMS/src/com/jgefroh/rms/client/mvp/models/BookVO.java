package com.jgefroh.rms.client.mvp.models;



public class BookVO extends RecordVO {
    public enum Type implements RecordType {
        BOOK
    }
    
    public enum BookField implements RecordVO.Field {
        TITLE,
        AUTHOR,
        EDITION,
        PUBLISHER,
        LOCATION,
        YEAR,
        FORMAT,
        QUALITY;
    }
    
    public BookVO() {
        super.put(CommonField.TYPE, Type.BOOK.name());
        super.put(CommonField.ID, super.getNewID() + "");
    }
}
