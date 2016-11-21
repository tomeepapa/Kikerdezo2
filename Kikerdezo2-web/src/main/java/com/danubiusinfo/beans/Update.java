/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.beans;

import com.danubiusinfo.ejb.CommonController;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Admin
 */
@ManagedBean(name = Update.BEAN_NAME)
@ViewScoped
public class Update implements Serializable {

    public static final String BEAN_NAME = "update";

    private int id;
    private String categ;
    private int categId;
    private String hMean1;
    private String hMean2;
    private String fMean;

    @EJB
    CommonController commonController;

    public Update() {
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String deleteWord(int id) {

        boolean result = commonController.deleteWord(id);
        if (result == false) {
            return "Sikertelen törlés";
        }
        return "Sikeres törlés";
    }
    
    public String updateWord(int id, String hMean1, String hMean2, String fMean) {

        commonController.updateWord(id, hMean1, hMean2, fMean);

        return "Sikeres módosítás";
    }

}


