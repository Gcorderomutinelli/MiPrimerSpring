package cl.awakelab.miprimerspring.restcontroller;



import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService; //Inyeccion de dependencia Usuario Service, llama a la Interfaz

    @PostMapping //Para indicar el metodo que ocuparemos para crear el usuario en este caso Post
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.crearUsuario(usuario); //retorna el obj usuario service, ocupamos el metodo crearUsuario hecho en la interfaz y luego le pasamos el objeto usuario creado
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        return objUsuarioService.actualizarUsuario(usuario);
    }
    @GetMapping
    public List<Usuario> listarUsuario(){
        return objUsuarioService.listarUsuario();
    }

    @GetMapping("/{id}")//(/{}) Indica que estamos recibiendo por url la id eso significan los parentensis
    public Usuario listarUsuarioId(@PathVariable int id) {

        return objUsuarioService.listarUsuarioId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
    }

    @DeleteMapping
    public void eliminarAlumno2(@RequestBody Usuario usuario){
        objUsuarioService.eliminaruUsuario2(usuario);
    }


}
