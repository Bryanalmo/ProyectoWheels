package com.example.echo;

public interface IUsuario {
	public void setNombre(String nombre);
    public void setCorreo(String correo);
    public void setPassword(String password);
    public void setTipoUsuario();
    public String nombre();
    public String correo();
    public String password();
    public String TipoUsuario();
}
