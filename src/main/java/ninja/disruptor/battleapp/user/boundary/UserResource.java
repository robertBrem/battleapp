package ninja.disruptor.battleapp.user.boundary;

import com.airhacks.porcupine.execution.boundary.Dedicated;
import ninja.disruptor.battleapp.user.control.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Dedicated
    @Inject
    ExecutorService usersPool;

    @Inject
    UserService userService;

    @GET
    public void getUsers(@Suspended AsyncResponse response) {
        CompletableFuture
                .supplyAsync(userService::getUsersAsGenericEntity, usersPool)
                .thenAccept(response::resume);
    }

}
