/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.resources;

import com.danubiusinfo.ejb.CommonController;
import com.danubiusinfo.entity.Words;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("/allwords")
@Consumes(MediaType.APPLICATION_JSON)   // nem kell minden függvénynél megadni ebben az esetben ha itt deklaráljuk
@Produces(MediaType.APPLICATION_JSON)
public class WordsResources {

    @EJB
    CommonController commonController;

    @GET
    // @Produces(MediaType.APPLICATION_JSON)    // xml kimenet alap, JSON-hoz jAR kell: jersey media moxy
    public List<Words> getAllWord(@QueryParam("langId") int langId, // csak a paraméterben megadott adatokat listzza ki
            @QueryParam("start") int start,
            @QueryParam("size") int size) {

        if (langId > 0) {
            List<Words> selectedLang = new ArrayList<>();
            selectedLang = commonController.getAllLang(langId);
            return selectedLang;
        }
        if (start >= 0 && size >= 0) {
            List<Words> selectedLangpginted = new ArrayList<>();
            selectedLangpginted = commonController.getAllPaginated(1, start, size);
            return selectedLangpginted;
        }
        List<Words> selectedCategWords = new ArrayList<>();
        selectedCategWords = commonController.getAllFromCateg(1);

        return selectedCategWords;
    }

    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public Response addWord(Words json, @Context UriInfo uriInfo) throws URISyntaxException {  // a visszatérő érték egy response a headerben, amit mi adhatunk meg

        String hMean1 = json.gethMean1();
        String hMean2 = json.gethMean2();
        String fMean = json.getfMean();
        int categId = json.getCategId();
        int langId = json.getLangId();

        Words word = commonController.createWord(hMean1, hMean2, fMean, categId, langId);
        //   return Response.status(Status.CREATED)  // a létrehozott objekomot visszaadjuk a státuszba
        String newId = String.valueOf(word.getId()); // a létrehozott id-t stringbe teszem

        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build(); // az url infót és a létrehozott új id stringet összerakom a builderrel
        return Response.created(uri)//a url-t is visszaadjuk best practice
                .entity(word)
                //       .cookie(cookies) cookie-t is be lehet állítani
                .build();
    }

    @GET
    @Path("/{id}")                      //  -----------------> Al oldal. webcim/allwords/oneword , {}-ben megadva viszont paraméter
    //@Produces(MediaType.APPLICATION_JSON)
    public Words getOneWord(@PathParam("id") int id) {   // paraméter kiszedése
        // több paraméter is jöhet pl. : /something/{id1}/name/{id2}   @PathParam("id1") int id,@PathParam("id2") int id
        //   List<Words> selectedCategWords = new ArrayList<>();       // regex is használható paramban
        Words selectedCategWords = commonController.getOneWord(id);

        return selectedCategWords;
    }

    @PUT
    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String updateWord(@PathParam("id") int id, Words json) {

        json.setId(id);
        String hMean1 = json.gethMean1();
        String hMean2 = json.gethMean2();
        String fMean = json.getfMean();

        commonController.updateWord(id, hMean1, hMean2, fMean);

        return "Sikeres módosítás!";
    }

    @DELETE
    @Path("/{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    public void deleteWord(@PathParam("id") int id) {

        commonController.deleteWord(id);
    }

    @GET
    @Path("context")
    public String getParamUsingContext(@Context HttpHeaders header) { //pl. cookie kiszedéshez, UriInfo osztály pedig az UL-el kapcsolatos infókat tartalmazza

        String cookies = header.getCookies().toString();
        return "Süti: " + cookies;
    }

    // ha lenne egy másik resource ami logikailag ez alá jönne akkor lehetne subResouce-ként kezelni.
    // Megvalósítása külön resource osztályban vannak a metódusok. Ha azt kapja, hogy id/subresource akkor tudja hogy nem itt hanem a subresource osztályban kell keresnie a megfelelő metódust.
    @Path("/{id}/subresource")
    public SubResource getSubresource() {

        return new SubResource();
    }

}
