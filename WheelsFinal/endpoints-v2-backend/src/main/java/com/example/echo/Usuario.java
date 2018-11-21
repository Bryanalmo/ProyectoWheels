package com.example.echo;

public abstract class Usuario implements IUsuario {

	private String nombre;
    private String correo;
    private String password;
    String tipoUsuario;

    @Override
    public void setNombre(String nombre){
        
    }
    
    @Override
    public void setCorreo(String correo){
        
    }
    
    @Override
    public void setPassword(String password){
        
    }
    
    @Override
    public String nombre(){
        return nombre;
    }
    
    @Override
    public String correo(){
        return correo;
    }
    
    @Override
    public String password(){
        return password;
    }
    
    public void setTipoUsuario(){
    
    }
    
    public String TipoUsuario(){
        return tipoUsuario;
    }
    
    
    public Usuario(String nombre, String correo, String password, String tipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }
    
    public void adicionar(Usuario user){
        //usuarios.add(user);
    };
    
    public void modificar(Usuario user, String nombreNuevo, String correoNuevo, String passwordNuevo){
        System.out.println("modificar");
        user.setCorreo(correoNuevo);
        user.setNombre(nombreNuevo);
        user.setPassword(passwordNuevo);
    };
    
    public abstract Usuario consultar(String correo);
    public abstract void eliminar(String correo);

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", Correo=" + correo + ", Password=" + password;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }   

    public String getTipoUsuario() {
        return tipoUsuario;
    }


}
