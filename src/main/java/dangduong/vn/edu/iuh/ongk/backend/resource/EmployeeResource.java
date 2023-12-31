package dangduong.vn.edu.iuh.ongk.backend.resource;

import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import dangduong.vn.edu.iuh.ongk.backend.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResource {
    @Inject
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getOne(@PathParam("id") long id){
        Optional<Employee> op = employeeService.findById(id);
        if (op.isPresent()){
            return Response.ok(op.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertOne(Employee employee){
        boolean result = employeeService.create(employee);
        if (result){
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOne(Employee employee){
        boolean result = employeeService.update(employee);
        if (result){
            return Response.ok(employee).build();
        }
        return  Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") long id){
        boolean result = employeeService.delete(id);
        if (result){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
