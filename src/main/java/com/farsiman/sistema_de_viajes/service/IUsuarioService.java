package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Usuario;
import java.util.List;

/**
 *
 * @author david
 */
public interface IUsuarioService {

    public List<Usuario> getUsuario();

    public void saveUsuario(Usuario usuario);

    public void deleteUsuario(Long id);

    public Usuario findUsuario(Long id);

    public void editColaborador(Usuario usuario);

}
