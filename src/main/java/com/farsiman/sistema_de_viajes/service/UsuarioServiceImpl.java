package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Usuario;
import com.farsiman.sistema_de_viajes.repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void editColaborador(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

}
