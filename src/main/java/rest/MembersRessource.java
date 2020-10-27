/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FM;
import dtos.RE;
import entities.FME;
import entities.REE;
import facades.FMF;
import facades.REF;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author matti
 */
@Path("members")
public class MembersRessource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final FMF FACADE = FMF.getGMPFacade(EMF);
    private static final REF RFACADE = REF.getGMPFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MembersRessource
     */
    public MembersRessource() {
    }

   
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllJSON() {
        //TODO return proper representation object
        List<FM> list = FACADE.getAll();
        return GSON.toJson(list);
    }
    
    @Path("/allRes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllRes() {
        //TODO return proper representation object
        List<RE> list = RFACADE.getAll();
        return GSON.toJson(list);
    }
    
    @Path("/exist/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String exist(@PathParam("name")String name) {
        //TODO return proper representation object
        FM f = FACADE.findIfExist(name);
        return GSON.toJson(f);
    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addPerson(String fme) {
        FME login = GSON.fromJson(fme, FME.class);  
        
        FACADE.add(login.getName(),login.getPw());        
        return Response.ok(login).build();
        
    }
    @Path("/addRes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addRes(String fme) {
        REE res = GSON.fromJson(fme, REE.class);  
        
        RFACADE.add(res.getBMI(),res.getName(),res.getPw());        
        return Response.ok(res).build();
        
    }

}
