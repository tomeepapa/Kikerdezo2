/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.ws;

import com.danubiusinfo.ejb.CommonController;
import com.danubiusinfo.entity.Words;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Admin
 */
@WebService
public class WordsService {

    @EJB
    CommonController commonController;

    @WebMethod(operationName = "getAllWordFromLang")
    public List<Words> getAllWordFromLang(int langId) {

        //  if (langId > 0) {
        List<Words> selectedLang = new ArrayList<>();
        selectedLang = commonController.getAllLang(langId);
        return selectedLang;
    }
    
    @WebMethod(operationName = "getOneWord")
    public Words getOneWord(@PathParam("id") int id) {  
        Words selectedCategWords = commonController.getOneWord(id);
        return selectedCategWords;
    }
    
    @WebMethod(operationName = "createWord")
    public Words addWord(Words json)  { 

        String hMean1 = json.gethMean1();
        String hMean2 = json.gethMean2();
        String fMean = json.getfMean();
        int categId = json.getCategId();
        int langId = json.getLangId();

        Words word = commonController.createWord(hMean1, hMean2, fMean, categId, langId);    
      
       return word;
    }
     @WebMethod(operationName = "deleteWord")
     public void deleteWord(@PathParam("id") int id) {
        commonController.deleteWord(id);
    }
     
    @WebMethod(operationName = "updateWord")
    public Words updateWord(@PathParam("id") int id, Words json) {

        json.setId(id);
        String hMean1 = json.gethMean1();
        String hMean2 = json.gethMean2();
        String fMean = json.getfMean();

        commonController.updateWord(id, hMean1, hMean2, fMean);

        return json;
    }

}
