/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.echo;

import java.util.ArrayList;
import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;
import io.swagger.annotations.ApiParam;

/**
 * The Echo API which Endpoints will be exposing.
 */

// [START echo_api_annotation]
@Api(
    name = "proxy",
    version = "v3",
    namespace =
    @ApiNamespace(
        ownerDomain = "echo.example.com",
        ownerName = "echo.example.com",
        packagePath = ""
    ),
    // [START_EXCLUDE]
    issuers = {
        @ApiIssuer(
            name = "firebase",
            issuer = "https://securetoken.google.com/YOUR-PROJECT-ID",
            jwksUri =
                "https://www.googleapis.com/service_accounts/v1/metadata/x509/securetoken@system"
                    + ".gserviceaccount.com"
        )
    }
// [END_EXCLUDE]
)
// [END echo3_api_annotation]

public class Proxy implements IProxy {

	@ApiParam
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	@ApiParam
    private static Proxy proxy = null;
	@ApiParam
    private Facade facade = new Facade();

 // [START echo_method]
    @ApiMethod(name = "echo3")
    public Message echo3(Message message, @Named("n") @Nullable Integer n) {
  	  
      return doEcho(message, n);
    }
// [END echo_method]
    
    public Proxy() {
    }
   
    public static Proxy reemplazarConstructora(){
        if (proxy == null )proxy = new Proxy();
        return proxy;
    }
    
 // [START iniciarSesion]
    @ApiMethod(name = "iniciar_sesion")
    public Usuario confirmarPermisosUsuario(@Named("correo") String correo, @Named("password") String password) {
    	Usuario user = null;
    	user.setNombre("Juan");
    	user.setCorreo("123");
    	user.setPassword("123");
        if(user.getCorreo().equals(correo) && user.getPassword().equals(password) ){
           return user;
        }
        return null;
    }
  // [END iniciarSesion]
    
    private Message doEcho(Message message, Integer n) {
        if (n != null && n >= 0) {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < n; i++) {
            if (i > 0) {
              sb.append(" ");
            }
            sb.append(message.getMessage());
          }
          message.setMessage(sb.toString());
        }
        return message;
      }

    /**
     * Gets the authenticated user's email. If the user is not authenticated, this will return an HTTP
     * 401.
     *
     * <p>Note that name is not specified. This will default to "{class name}.{method name}". For
     * example, the default is "echo.getUserEmail".
     *
     * <p>Note that httpMethod is not required here. Without httpMethod, this will default to GET due
     * to the API method name. httpMethod is added here for example purposes.
     */
    // [START google_id_token_auth]
    @ApiMethod(
        httpMethod = ApiMethod.HttpMethod.GET,
        authenticators = {EspAuthenticator.class},
        audiences = {"YOUR_OAUTH_CLIENT_ID"},
        clientIds = {"YOUR_OAUTH_CLIENT_ID"}
    )
    public Email getUserEmail(User user) throws UnauthorizedException {
      if (user == null) {
        throw new UnauthorizedException("Invalid credentials");
      }

      Email response = new Email();
      response.setEmail(user.getEmail());
      return response;
    }
    // [END google_id_token_auth]

    /**
     * Gets the authenticated user's email. If the user is not authenticated, this will return an HTTP
     * 401.
     *
     * <p>Note that name is not specified. This will default to "{class name}.{method name}". For
     * example, the default is "echo.getUserEmail".
     *
     * <p>Note that httpMethod is not required here. Without httpMethod, this will default to GET due
     * to the API method name. httpMethod is added here for example purposes.
     */
    // [START firebase_auth]
    @ApiMethod(
        path = "firebase_user",
        httpMethod = ApiMethod.HttpMethod.GET,
        authenticators = {EspAuthenticator.class},
        issuerAudiences = {
            @ApiIssuerAudience(
                name = "firebase",
                audiences = {"YOUR-PROJECT-ID"}
            )
        }
    )
    public Email getUserEmailFirebase(User user) throws UnauthorizedException {
      if (user == null) {
        throw new UnauthorizedException("Invalid credentials");
      }

      Email response = new Email();
      response.setEmail(user.getEmail()+"123");
      return response;
    }
    // [END firebase_auth]
  }