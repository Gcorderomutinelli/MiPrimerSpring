package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping("/crearUsuario") // Va  a buscar al formulario Html
    public String mostrarFormularioCrearUsuario(){
        return "templateFormularioCrearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/Usuario";

    }

    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute Usuario datosParaActualizar){
        Usuario usuario = objUsuarioService.listarUsuarioId(datosParaActualizar.getId());
        usuario.setNombreUsuario(datosParaActualizar.getNombreUsuario());
        usuario.setRol(datosParaActualizar.getRol());
        usuario.setContrasena(datosParaActualizar.getContrasena());
        objUsuarioService.actualizarUsuario(usuario);
        return "redirect:/Usuario";
    }

    @GetMapping("editar/{id}")
    public String editarUsuario(Model model,@PathVariable("id") int id){
        Usuario usuario = objUsuarioService.listarUsuarioId(id);
        model.addAttribute("usuario", usuario);
        return "templateFormularioModificarUsuario";
    }

    @GetMapping
    public String listarUsuario(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuarios", listaUsuarios);// Le pasamos la lista de usuarios al objeto atributoListaUsuarios
        return "templateListarUsuarios";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/Usuario";
    }
}
