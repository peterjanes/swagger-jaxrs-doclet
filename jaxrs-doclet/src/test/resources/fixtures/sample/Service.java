package fixtures.sample;

import javax.ws.rs.*;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/foo")
public class Service {
    /**
     * @errorResponse 404 not found
     * @errorResponse ABC invalid code won't be parsed
     */
    @GET
    public String sayHello(@QueryParam("name") @DefaultValue("World") String name) {
        return "Hello, " + name + "!";
    }

    @POST
    public int createSpeech(String speech) {
        return speech.hashCode();
    }

    @ApiOperation(value = "hidden", hidden = true)
    @POST
    @Consumes("text/plain")
    public String duplicatedPathAndMethod(String input) {
        return input;
    }

    @Path("/annotated")
    @POST
    public int createSpeechWithAnnotatedPayload(@Deprecated String speech) {
        return speech.hashCode();
    }
}
