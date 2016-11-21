/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.resources;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;




/**
 *
 * @author Admin
 */

@Path("/upload")
public class UploadResources {
   // public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException{
   @POST
   @Consumes(MediaType.MULTIPART_FORM_DATA)
   @Produces("text/xml") 
    public String uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException{   
    saveToDisk(uploadedInputStream,fileDetail);   
    String reply = "Fájl feltöltve" + fileDetail.getFileName();
    return reply;
    //return Response.status(Status.OK).entity(reply).build();
   }
   
   private void saveToDisk(InputStream uploadedInputStream, FormDataContentDisposition fileDetail) throws IOException{   // standard java file upload process
   
       String uploadedFileLocation = "c://upload/"+fileDetail.getFileName();  
       try {
           OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
           int read = 0;
           byte[] bytes = new byte[1024];
           
           out = new FileOutputStream(new File(uploadedFileLocation));
           while ((read = uploadedInputStream.read(bytes)) != -1){
               out.write(bytes, 0, read);
           }
           out.flush();
           out.close();
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       }
   
   }
    
}
