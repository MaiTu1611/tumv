package com.tumv.model;

import java.util.Date;

public class Reader {
    private String name;
    private String typeReader;
    private Date dateBorn;
    private String email;
    private String address;
    private Date dateCreate;
    private String _csrf;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the typeReader
     */
    public String getTypeReader() {
        return typeReader;
    }
    /**
     * @param typeReader the typeReader to set
     */
    public void setTypeReader(String typeReader) {
        this.typeReader = typeReader;
    }
    /**
     * @return the dateBorn
     */
    public Date getDateBorn() {
        return dateBorn;
    }
    /**
     * @param dateBorn the dateBorn to set
     */
    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the dateCreate
     */
    public Date getDateCreate() {
        return dateCreate;
    }
    /**
     * @param dateCreate the dateCreate to set
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the _csrf
     */
    public String get_csrf() {
        return _csrf;
    }
    /**
     * @param _csrf the _csrf to set
     */
    public void set_csrf(String _csrf) {
        this._csrf = _csrf;
    }


}
