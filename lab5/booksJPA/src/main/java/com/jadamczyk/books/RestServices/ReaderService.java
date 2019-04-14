package com.jadamczyk.books.RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/reader")
public class ReaderService {
    @GET
    public Response getReaders() {
       try {
           return Response.ok().build();
       } catch (Exception e) {
           return Response.serverError().build();
        }
    }

    @GET
    public Response getReader(@QueryParam("id") Integer id) {
        try {
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
