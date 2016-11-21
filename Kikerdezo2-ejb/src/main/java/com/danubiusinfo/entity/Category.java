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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kovacs_tamas
 */

@Entity
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Category.AllCateg", query = "SELECT b FROM Category b"),
})
 @SqlResultSetMapping(name = "allCateg",
                entities = {
                   // @EntityResult(entityClass = Words.class),
                    @EntityResult(entityClass = Category.class),
                    //@EntityResult(entityClass = Language.class),
                    }
        )   

@ManagedBean(name = "tblCategory")
public class Category implements Serializable{
    
    @Id  
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "CategId")
    private int id;
    @Column(name = "CategoryName")
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
            
}
