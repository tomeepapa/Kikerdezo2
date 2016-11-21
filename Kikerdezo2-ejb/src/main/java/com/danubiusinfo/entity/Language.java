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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kovacs_tamas
 */

@Entity
@Table(name = "Language")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Language.findAllFromLang", query = "SELECT b FROM Language b")
})
 @SqlResultSetMapping(name = "langWeNeed",
                entities = {
                    @EntityResult(entityClass = Words.class),
                    @EntityResult(entityClass = Category.class),
                    @EntityResult(entityClass = Language.class),
                    }
        )   

@ManagedBean(name = "tbllanguage")  
public class Language implements Serializable{
    
private static final long serialVersionUID = 1L;
    
    @Id  
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "LangId")
    @XmlElement
    private int langId;
    @XmlElement
    @Column(name = "Language")
    private String lang;

    public Language() {
    }

    public Language(String lang) {
        this.lang = lang;
    }

    public int getId() {
        return langId;
    }

    public void setId(int langId) {
        this.langId = langId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    
    
    
}
