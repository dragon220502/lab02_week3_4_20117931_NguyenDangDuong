package dangduong.vn.edu.iuh.ongk.backend.resource;

import dangduong.vn.edu.iuh.ongk.backend.models.Customer;
import dangduong.vn.edu.iuh.ongk.backend.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/customer")
public class CustomerResource {
    @Inject
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAll(){
        return  customerService.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getOne(@PathParam("id") long id){
        Optional<Customer> op = customerService.findOne(id);
        if (op.isPresent()){
            Customer customer = op.get();
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertOne(Customer customer){
        boolean result = customerService.create(customer);
        if (result){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOne(Customer customer){
        boolean result = customerService.update(customer);
        if (result){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") long id){
        boolean result = customerService.delete(id);

        if (result){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
