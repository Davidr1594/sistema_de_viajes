
package com.farsiman.sistema_de_viajes.controller;

import com.farsiman.sistema_de_viajes.service.IUsuarioService;
import com.farsiman.sistema_de_viajes.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Component
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    public boolean validUsuario(String nombre, String contrasenia){
        List<Usuario> listUsuarios = usuarioService.getUsuarios();
        for(Usuario usr : listUsuarios){
            System.out.println(usr.getNombre());
        }
        
        for(Usuario usuario : listUsuarios){
            if (nombre.equals(usuario.getNombre())) {
                if (contrasenia.equals(usuario.getContrasenia())) {
                    return true;                    
                }
                
            }
            
        }
        
        return false;
    }
    
}
