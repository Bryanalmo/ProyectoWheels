package com.example.echo;

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
// [END echo2_api_annotation]

public class Proxy implements IProxy {

	@ApiParam
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	@ApiParam
    private static AccesoProxy proxy = null;
	@ApiParam
    private Facade facade = new Facade();

 // [START echo_method]
    @ApiMethod(name = "echo2")
    public Message echo2(Message message, @Named("n") @Nullable Integer n) {
  	  
      return doEcho(message, n);
    }
// [END echo_method]
    
    public AccesoProxy() {
    }
    

    public static AccesoProxy reemplazarConstructora(){
        if (proxy == null )proxy = new AccesoProxy();
        return proxy;
    }
    
 // [START iniciarSesion]
    @ApiMethod(name = "iniciar_sesion")
    public Usuario confirmarPermisosUsuario(@Named("correo") String correo, @Named("password") String password) {
    	Usuario user = new Usuario;
    	user.setNombre(Juan);
    	user.setCorreo(123);
    	user.setPassword(123);
        if(user.getCorreo().equals(correo) && user.getPassword().equals(password) ){
           return user;
        }
        return null;
    }
  // [END iniciarSesion]

}
