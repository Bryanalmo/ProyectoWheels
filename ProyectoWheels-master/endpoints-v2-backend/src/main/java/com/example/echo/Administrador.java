package com.example.echo;

import java.util.ArrayList;

public class Administrador {

	private String nombre;
    private String correo;
    private String password;
    private String tipo;

    public Administrador(String nombre, String correo, String password, String admin) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipo = admin;
    }
    
    public void create(){ 
    }
    
    public void update(){
    }
    
    public Usuario read(String correo, ArrayList<Usuario> usuarios){
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getCorreo().equals(correo)){
                return usuarios.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Usuario> delete(String correo, ArrayList<Usuario> usuarios){
        System.out.println("Entre al admin");
        System.out.println(usuarios.size() + "usuarios.size en admin");
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getCorreo().equals(correo)){
               Usuario us = usuarios.get(i);
               System.out.println(us.getCorreo() + "correo al admin");
               usuarios.remove(us);
            System.out.println(usuarios);
            }
        }
        return usuarios;
    }
}
