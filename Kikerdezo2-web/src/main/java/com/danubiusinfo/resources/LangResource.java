/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.resources;

import com.danubiusinfo.ejb.CommonController;
import com.danubiusinfo.entity.Language;
import com.danubiusinfo.resourcesBeans.LanguageFilterBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Admin
 */

@Path("/lang")
@Consumes(MediaType.APPLICATION_JSON)   // nem kell minden függvénynél megadni ebben az esetben ha itt deklaráljuk
@Produces(MediaType.APPLICATION_JSON)
public class LangResource {  // bean prammal megoldva
    
    @EJB
    CommonController commonController;    
    
     @GET
    // @Produces(MediaType.APPLICATION_JSON)    // xml kimenet alap, JSON-hoz jAR kell: jersey media moxy
    public List<Language> getAllLangName(){
        
          List<Language> selectedLangp = new ArrayList<>();
          selectedLangp = commonController.getAllLanguageName();
          return selectedLangp;
    
    }
    
}
