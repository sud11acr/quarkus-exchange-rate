package pe.com.demoquarkus.exception;

import pe.com.demoquarkus.dto.ErrorResponse;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class HandlerException implements ExceptionMapper<Throwable> {

 private static final Logger LOG = Logger.getLogger(HandlerException.class);

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable ex) {
        int status;
        String error;
        String message;

        if (ex instanceof TooManyRequestsException) {
            status = 429;
            error = "Too Many Requests";
            message = ex.getMessage();
            LOG.infof("Rate limit: %s", ex.getMessage());
        } else {
            status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
            error = "Internal Server Error";
            message = "internal server error";
            LOG.error("Unhandled exception", ex);
        }

        ErrorResponse body = new ErrorResponse(status, error, message, uriInfo != null ? uriInfo.getPath() : null);
        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(body).build();
    }

}
