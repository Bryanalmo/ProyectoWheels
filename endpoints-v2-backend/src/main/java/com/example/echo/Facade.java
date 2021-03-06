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
import java.util.Arrays;

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
import com.google.appengine.repackaged.com.google.gson.JsonArray;
import com.google.appengine.repackaged.com.google.gson.JsonObject;

import endpoints.repackaged.com.google.gson.Gson;
import endpoints.repackaged.google.type.LatLng;
import endpoints.repackaged.org.jose4j.json.internal.json_simple.JSONArray;
import endpoints.repackaged.org.jose4j.json.internal.json_simple.JSONObject;
import io.swagger.annotations.ApiParam;

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
	//BRYAN A
	@ApiParam
	private ArrayList<Ruta> rutas = new ArrayList<>();
	
  // [START crearRuta]
  @ApiMethod(name = "crearRuta")
  public void crearRuta(@Named("identificador") String identificador,@Named("idConductor") String idConductor,
		  				@Named("numeroPuestos") int numeroPuestos, @Named("placa") String placa,
		  				@Named("xInicio") double xInicio, @Named("yInicio") double yInicio,
		  				@Named("xFin") double xFin,@Named("yFin") double yFin,@Named("hora") String hora) {
	  Ruta ruta = new Ruta(identificador,idConductor, numeroPuestos, placa, xInicio, yInicio, xFin, yFin, hora); 
      rutas.add(ruta);
  }
  // [END crearRuta]
  
//[START agregarPolilinea]
 @ApiMethod(name = "agregarPolilineas")
 public void agregarPolilinea(@Named("identificador") String identificador,@Named("polilineaCod") String polilineaCod) {
	 for (int i = 0; i < rutas.size(); i++) {
         if (rutas.get(i).getIdentificador().equals(identificador)) {
             Ruta ruta = rutas.get(i);
             Polilineas polilineas = ruta.getPolilineas();
             polilineas.addPoliline(polilineaCod);
         }
     }
     
 }
 // [END agregarPolilinea]

  
//[START buscarRuta]
 @ApiMethod(name = "buscarRuta")
 public Ruta buscarRutas(@Named("identificador") String identificador) {
	 for (int j = 0; j < rutas.size(); j++) {
         if (rutas.get(j).getIdentificador().equals(identificador)) {
             Ruta ruta = rutas.get(j);
             return ruta;
         }
     }
	 return null;
 }
 // [END buscarRuta]
 
//[START buscarRuta]
@ApiMethod(name = "listar_rutas")
public ArrayList<Ruta> listarRutas() {
	 return rutas;
}
// [END buscarRuta]
  
 
 
  

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
