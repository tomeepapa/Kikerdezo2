/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "errormessage")
@XmlRootElement
public class ErrorMessage {
    
    @Id  
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "errorCode")
    @XmlElement
    private int errorCode;
    @XmlElement
    @Column(name = "errorMessage")
    private String errorMessage; 
    @XmlElement
    @Column(name = "documentation")
    private String documentation; 

    public ErrorMessage() {
    }

    public ErrorMessage(int errorCode, String errorMessage, String documentation) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.documentation = documentation;
    }
    
    

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
    
    
    
}
