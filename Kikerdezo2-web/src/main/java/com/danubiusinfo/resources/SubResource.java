/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Admin
 */
@Path("/")  // ez opcionális mivel subResource 
public class SubResource {
    
    @GET
    public String teszt(){
    return "Ez egy subresoucre get válasz";
    }
    
    @GET
    @Path("/{subId}")
    public String teszt2(@PathParam("subId") int subId, @PathParam("id") int id){     // a szülő osztály Paramját, jelen esetben id is megkaphatjuk 
    return "Ez egy subresoucre Id-re adott get válasz a kapott id: "+subId+"a szölő osztály kapott ID-je :"+id;
    }
    
}
