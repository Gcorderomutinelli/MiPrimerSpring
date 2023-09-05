package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario crearUsuario(Usuario usuarioCreado);

    public Usuario actualizarUsuario(int id, Usuario usuarioActualizar);

    public List<Usuario> listarUsuario();

    public void eliminarUsuario(int id);

    public void eliminaruUsuario2(Usuario usuario);

    public Usuario listarUsuarioId(int id);



}
