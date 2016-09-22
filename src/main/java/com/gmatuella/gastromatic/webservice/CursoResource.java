package com.gmatuella.gastromatic.webservice;

import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.service.CursoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@Path("/curso")
public class CursoResource {

    @EJB
    private CursoService cursoService;

    public CursoResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertCurso(Curso curso) {
        cursoService.save(curso);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> getCursos() {
        return cursoService.listAll();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void editCurso(Curso curso) {
        cursoService.edit(curso);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCurso(Curso curso) {
        cursoService.delete(cursoService.find(curso));
    }

}
