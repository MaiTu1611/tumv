package com.tumv.model;

import java.util.Date;

public class Reader {
    private int idReader;
    private String nameReader;
    private String typeReader;
    private Date dateBornReader;
    public int getIdReader() {
        return idReader;
    }
    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }
    public String getNameReader() {
        return nameReader;
    }
    public void setNameReader(String nameReader) {
        this.nameReader = nameReader;
    }
    public String getTypeReader() {
        return typeReader;
    }
    public void setTypeReader(String typeReader) {
        this.typeReader = typeReader;
    }
    public Date getDateBornReader() {
        return dateBornReader;
    }
    public void setDateBornReader(Date dateBornReader) {
        this.dateBornReader = dateBornReader;
    }
    public String getEmailReader() {
        return emailReader;
    }
    public void setEmailReader(String emailReader) {
        this.emailReader = emailReader;
    }
    public Date getDateCreateTag() {
        return dateCreateTag;
    }
    public void setDateCreateTag(Date dateCreateTag) {
        this.dateCreateTag = dateCreateTag;
    }
    private String emailReader;
    private Date dateCreateTag;
}
