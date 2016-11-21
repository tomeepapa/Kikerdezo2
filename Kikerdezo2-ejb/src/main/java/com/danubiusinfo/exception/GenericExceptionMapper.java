/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.exception;

import com.danubiusinfo.entity.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Admin
 */
   
//@Provider   //JAX-RS-nek kell
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {  //generikus throwable, minden error jöhet

    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage = new ErrorMessage(500,exception.getMessage(), "http://danubiusinfo.hu");
        return  Response.status(Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }

        
    
}
