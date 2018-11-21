package com.example.echo;

public class Proxy implements IProxy {

	private ArrayList<Usuario> usuarios = new ArrayList<>();
    private static AccesoProxy proxy = null;
    private Facade facade = new Facade();

    public AccesoProxy() {
    }

    public static AccesoProxy reemplazarConstructora(){
        if (proxy == null )proxy = new AccesoProxy();
        return proxy;
    }
    
    @Override
    public Usuario confirmarPermisosUsuario(String correo, String password) {
        Usuario user = null;
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getCorreo().equals(correo) && usuarios.get(i).getPassword().equals(password) ){
                user = usuarios.get(i);
            }
        }
        return user;
    }

}
