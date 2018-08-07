package pers.xiaoming.springboot.jersey_jetty.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.xiaoming.springboot.jersey_jetty.service.IStudentService;
import pers.xiaoming.springboot.jersey_jetty.entity.Student;
import pers.xiaoming.springboot.jersey_jetty.exception.BadRequestException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/student")
public class StudentResource {

    private IStudentService service;

    @Autowired
    public StudentResource(IStudentService service) {
        this.service = service;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(Student student) {
        service.createStudent(student);

        return Response.status(Response.Status.CREATED).entity(student).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(Student student) {
        service.updateStudent(student);

        return Response.status(Response.Status.ACCEPTED).entity(student).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@QueryParam("id") int id) {
        Student student = service.getStudent(id);

        if (student == null) {
            throw new BadRequestException("Student Not Found!");
        }

        return Response.ok(student).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@QueryParam("id") int id) {
        service.deleteStudent(id);

        return Response.status(Response.Status.ACCEPTED).build();
    }
}
