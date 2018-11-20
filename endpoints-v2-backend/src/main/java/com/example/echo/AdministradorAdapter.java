package com.example.echo;

public class AdministradorAdapter extends Usuario {
	private Administrador admin;
    private String tipo ="administrador";
    
    
    public AdministradorAdapter(String nombre, String correo, String password) {
        super(nombre, correo, password, "administrador");
    }    
    
    public Usuario consultar(String correo) {
        return null;
        //return this.admin.read(correo,usuarios);
    }

    
    public void eliminar(String correo) {
        System.out.println(correo + "adapter");
        //usuarios = this.admin.delete(correo, usuarios);
        //System.out.println(usuarios.size() + "usuarios.size");
    }

}
