/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.beans;

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

/**
 *
 * @author kovacs_tamas
 */
@ManagedBean(name = SelectedByCateg.BEAN_NAME)
@RequestScoped
public class SelectedByCateg implements Serializable {

    public static final String BEAN_NAME = "selectedByCateg";
    List<Words> selectedCategWords = new ArrayList<>();
    List<Category>allCateg = new ArrayList<>();
    private String categ;
    private int categId;
    private String hMean1;
    private String hMean2;
    private String fMean;
    private int goodAnws;
    private int wrongAnsw;
    private String answer;
    private Words actualQuestion;
    private int actQestCounter = 0;
    private boolean hasNextQ = true;

    @EJB
    CommonController commonController;

    public SelectedByCateg() {
    }

    public String gethMean1() {
        return hMean1;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }
    
    
    public List<Category> getAllCateg() {
        return allCateg;
    }

    public void setAllCateg(List<Category> allCateg) {
        this.allCateg = allCateg;
    }

    
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Words getActualQuestion() {
        return actualQuestion;
    }

    public void setActualQuestion(Words actualQuestion) {
        this.actualQuestion = actualQuestion;
    }

    public int getGoodAnws() {
        return goodAnws;
    }

    public void setGoodAnws(int goodAnws) {
        this.goodAnws = goodAnws;
    }

    public int getWrongAnsw() {
        return wrongAnsw;
    }

    public void setWrongAnsw(int wrongAnsw) {
        this.wrongAnsw = wrongAnsw;
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

    public List<Words> getSelectedCategWords() {
        return selectedCategWords;
    }

    public void setSelectedCategWords(List<Words> selectedCategWords) {
        this.selectedCategWords = selectedCategWords;
    }

    public CommonController getCommonController() {
        return commonController;
    }

    public void setCommonController(CommonController commonController) {
        this.commonController = commonController;
    }

    /**
     * *************************************************************************
     */
    //                          Methods
    /**
     * *************************************************************************
     */
    
    //@PostConstruct
    public String init(){
        this.actQestCounter = 0;
        
        createCategList();
        //this.actualQuestion = selectedCategWords.get(actQestCounter);
        return "SzoLista";
    }
    
    public void createQueryByCateg(int categId) {

        if (selectedCategWords != null) {
            clearSession();
        }
        selectedCategWords = commonController.getAllFromCateg(categId);
        actualQuestion = selectedCategWords.get(0); 
       // return "SzoLista";
    }

    
    public void createCategList(){
        
        allCateg = commonController.getAllCateg();
            
    }
    
    public void nextQuestion() {

        if (hasNextQ) {
            
            actQestCounter++;
            actualQuestion = selectedCategWords.get(actQestCounter);      
          //  answerCounter(); valami gaLiba
                        
            if (actQestCounter > selectedCategWords.size()) {
                hasNextQ = false; // no more question
            }
        }        
        setAnswer(null); // beviteli mező nullázása
    } 

    public void answerCounter() {

        if (actualQuestion.gethMean1().equals(answer) || actualQuestion.gethMean2().equals(answer)) {

            goodAnws++;
        }
    }

    
    public void clearSession() {
        selectedCategWords.clear();
    }

}
