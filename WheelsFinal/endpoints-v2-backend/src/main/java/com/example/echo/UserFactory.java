package com.example.echo;

import java.util.HashMap;

public class UserFactory {
private HashMap list = new HashMap();
    
    public void setUsuario (String index, IUsuario usuario){
        list.put(index, usuario);
    }
    
    public IUsuario getUsuario(String index){
        return (IUsuario)list.get(index);
    }
}
