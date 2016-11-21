/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.resources;

import java.io.File;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Admin
 */

@Path("/download")
public class DownloadResources {
    
    @GET
    @Produces("text/plain")  // lehet application/pdf ; image/png
    public Response getTxtFile(){
        File file = new File("c:\\teszt.txt");
        
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachement; filenaame=DisplayName-teszt.txt");
        return response.build();
        
    }
}
