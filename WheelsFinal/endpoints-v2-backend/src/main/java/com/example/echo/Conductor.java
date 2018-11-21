package com.example.echo;

public class Conductor extends Usuario{
private String tipo ="conductor";
    
    
    
    public Conductor(String nombre, String correo, String password) {
        super(nombre, correo, password, "conductor");
    }

    public Usuario consultar(String correo) {
        /*for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getCorreo().equals(correo)){
                return usuarios.get(i);
            }
        }*/
        return null;
    }

    public void eliminar(String correo) {
        /*for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).equals(correo)){
               Usuario us = usuarios.get(i);
               usuarios.remove(us);
            }
        }*/
        
    }

}
