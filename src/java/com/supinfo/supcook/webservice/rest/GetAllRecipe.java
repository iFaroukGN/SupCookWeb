/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.webservice.rest;

import com.supinfo.supcook.ejb.session.RecipeDAOBeanLocal;
import com.supinfo.supcook.entities.Recipe;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author farouk
 */

@Path("/getRecipeService")
public class GetAllRecipe {

    private RecipeDAOBeanLocal recipeBeanLocal;
    
    public GetAllRecipe() {
        
    }
    
    
    @GET
    @Path("allRecipe")
    public Response getAllRecipe() {

            List<Recipe> output = recipeBeanLocal.listAll();

            return Response.status(200).entity(output).build();

    }
    
    
    @GET
    @Path("/recipeByName{param}")
    public Response getRecipeByName(@PathParam("param") String recipeName) {

            List<Recipe> output = recipeBeanLocal.getRecipeByName(recipeName);

            return Response.status(200).entity(output).build();

    }
}
