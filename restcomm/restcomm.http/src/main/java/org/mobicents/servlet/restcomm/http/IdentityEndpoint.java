package org.mobicents.servlet.restcomm.http;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.keycloak.representations.AccessTokenResponse;
import org.mobicents.servlet.restcomm.identity.KeycloakClient;
import org.mobicents.servlet.restcomm.identity.KeycloakClient.KeycloakClientException;

@Path("/instance")
public class IdentityEndpoint extends AbstractEndpoint {

    public IdentityEndpoint() {
        // TODO Auto-generated constructor stub
    }

    @POST
    @Path("/register")
    public Response registerInstance(@FormParam("restcommBaseUrl") String baseUrl, @FormParam("authUrl") String authUrl, @FormParam("username") String username, @FormParam("password") String password) throws KeycloakClientException {
        /*IdentityModeEntity modeEntity = new IdentityModeEntity();
        modeEntity.setMode(keycloakConfigurator.getMode());
        Gson gson = new Gson();
        return Response.ok(gson.toJson(modeEntity),MediaType.APPLICATION_JSON).build();
        */

        KeycloakClient keycloakClient = new KeycloakClient(username, password, "restcomm-identity-rest", "restcomm", authUrl);
        AccessTokenResponse token = keycloakClient.getToken();
        logger.info("token: " +  token.getToken() );

        return Response.ok().build();
    }

}
