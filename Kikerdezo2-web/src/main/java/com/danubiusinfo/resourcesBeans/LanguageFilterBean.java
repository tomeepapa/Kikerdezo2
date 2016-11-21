/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.resourcesBeans;

import com.danubiusinfo.ejb.CommonController;
import javax.ejb.EJB;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Admin
 */
public class LanguageFilterBean {  // Lang rest bean megoldssal
    
    private @QueryParam("start") int start; 
    private @QueryParam("start") int size;


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
