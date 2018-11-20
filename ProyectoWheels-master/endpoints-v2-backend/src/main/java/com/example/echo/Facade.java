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

//Master -Ana v2
// INTENTO COMENTARIO DOS

/**
 * The Echo API which Endpoints will be exposing.
 */
// [START echo_api_annotation]
@Api(
    name = "facade",
    version = "v2",
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
// [END echo2_api_annotation]

public class Facade {
	
	@ApiParam
	private ArrayList<Ruta> rutas = new ArrayList<>();
  
  // [START echo_method]
  @ApiMethod(name = "echo2")
  public Message echo2(Message message, @Named("n") @Nullable Integer n) {
	  
    return doEcho(message, n);
  }
  // [END echo_method]
 
  // [START crearRuta]
  @ApiMethod(name = "crear_ruta")
  public void crearRuta(@Named("idConductor") String idConductor, @Named("numeroPuestos") int numeroPuestos,
		  				   @Named("placa") String placa, @Named("ptoSalida") String ptoSalida,
		  				   @Named("ptoDestino") String ptoDestino, @Named("hora") String hora) {
	  Ruta ruta = new Ruta(idConductor, numeroPuestos, placa, ptoSalida, ptoDestino, hora,
			  new ArrayList<>()); 
      rutas.add(ruta);
  }
  // [END crearRuta]
  
//[START buscarRuta]
 @ApiMethod(name = "buscar_ruta")
 public Ruta buscarRuta(@Named("idConductor") String idConductor) {
	 for (int i = 0; i < rutas.size(); i++) {
         if (rutas.get(i).getIdConductor().equals(idConductor)) {
             Ruta ruta = rutas.get(i);
             return ruta;
         }
     }
	 return null;
 }
 // [END buscarRuta]
 
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
