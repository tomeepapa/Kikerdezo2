/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kovacs_tamas
 */

@Entity
@Table(name = "Words")
@XmlRootElement(name="Words")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
@NamedQuery(name = "Words.findByCategId", query = "SELECT b FROM Words b WHERE b.categId = :categId"),
@NamedQuery(name = "Words.findById", query = "SELECT b FROM Words b WHERE b.id = :id"),
@NamedQuery(name = "Words.delete", query = "DELETE FROM Words b WHERE b.id = :id"),
@NamedQuery(name = "Words.findAllFromLang", query = "SELECT b FROM Words b WHERE b.langId = :langId"),
})
 @SqlResultSetMapping(name = "wordsWeNeed",
                entities = {
                    @EntityResult(entityClass = Words.class),
                    @EntityResult(entityClass = Category.class),
                    @EntityResult(entityClass = Language.class),
                    }
        )   

@ManagedBean(name = "tblWords")
public class Words implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id  
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    @XmlElement
    private int id;
    @XmlElement
    @Column(name = "CategId")
    private int categId;
    @XmlElement
    @Column(name = "LangId")
    private int langId;
    @XmlElement
    @Column(name = "Hmean1") 
    private String hMean1;
    @XmlElement
    @Column(name = "Hmean2") 
    private String hMean2;
    @XmlElement
    @Column(name = "Fmean")
    private String fMean;

    public Words() {
    }

    public Words(int categId, int langId, String hMean1, String hMean2, String fMean) {
        this.categId = categId;
        this.langId = langId;
        this.hMean1 = hMean1;
        this.hMean2 = hMean2;
        this.fMean = fMean;
    }
            
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategId() {
        return categId;
    }

    public void setCategId(int categId) {
        this.categId = categId;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String gethMean1() {
        return hMean1;
    }

    public void sethMean1(String hMean1) {
        this.hMean1 = hMean1;
    }

    public String gethMean2() {
        return hMean2;
    }

    public void sethMean2(String hMean2) {
        this.hMean2 = hMean2;
    }

    public String getfMean() {
        return fMean;
    }

    public void setfMean(String fMean) {
        this.fMean = fMean;
    }
    
    
    
    
}
