package cl.awakelab.miprimerspring.service.serviceimpl;



import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {


    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario usuarioCreado) {
        return objUsuarioRepo.save(usuarioCreado); //Forma Corta de Crear
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuarioActualizar) {
        Usuario usuarioEncontrado = objUsuarioRepo.findById(id).orElse(null);
        usuarioEncontrado.setNombreUsuario(usuarioActualizar.getNombreUsuario());
        usuarioEncontrado.setContrasena(usuarioActualizar.getContrasena());
        usuarioEncontrado.setRol(usuarioActualizar.getRol());
        return objUsuarioRepo.save(usuarioEncontrado);
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listaUsuario = new ArrayList<>();
        listaUsuario = objUsuarioRepo.findAll();
        return listaUsuario;

    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);

    }

    @Override
    public void eliminaruUsuario2(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }

    @Override
    public Usuario listarUsuarioId(int id) {

        return objUsuarioRepo.findById(id).orElse(null);
    }
}
