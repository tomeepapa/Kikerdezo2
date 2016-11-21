/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.danubiusinfo.ejb.CommonController;
import com.danubiusinfo.entity.Words;

/**
 *
 * @author kovacs_tamas
 */
@ManagedBean(name = InsertBean.BEAN_NAME)
@RequestScoped
public class InsertBean implements Serializable {

    public static final String BEAN_NAME = "insertBean";
    private String hMean1, hMean2, fMean;
    private int categId, langId;
    @EJB
    CommonController commonController;

    public InsertBean() {
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

    public void runInsert() {

        insertWord(hMean1, hMean2, fMean, categId, langId);
    }

    public void insertWord(String hMean1, String hMean2, String fMean, int categId, int langId) {
       
        commonController.createWord(hMean1,hMean2,fMean,categId,langId);
    }

    public CommonController getCommonController() {
        return commonController;
    }

    public void setCommonController(CommonController commonController) {
        this.commonController = commonController;
    }

}
