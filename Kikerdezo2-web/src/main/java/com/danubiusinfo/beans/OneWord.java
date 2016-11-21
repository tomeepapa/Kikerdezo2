/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.danubiusinfo.ejb.CommonController;
import com.danubiusinfo.entity.Category;
import com.danubiusinfo.entity.Words;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Admin
 */

@ManagedBean(name = OneWord.BEAN_NAME)
@ViewScoped
public class OneWord implements Serializable{
    
public static final String BEAN_NAME = "oneword";    
    
    Words selectedWord;
    private int id;
    private String categ;
    private int categId;
    private String hMean1;
    private String hMean2;
    private String fMean;
    
    @EJB
    CommonController commonController;

    public OneWord() {
    }

    public Words getSelectedWord() {
        return selectedWord;
    }

    public void setSelectedWord(Words selectedWord) {
        this.selectedWord = selectedWord;
    }


    

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
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
    
    
    @PostConstruct
    public void init(){
        id = 1; 
        selectedWord = commonController.getOneWord(id);

    }
    

}
