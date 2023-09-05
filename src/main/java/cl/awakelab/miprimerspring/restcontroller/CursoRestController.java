package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Curso;

import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Curso")
public class CursoRestController {

    @Autowired
    ICursoService objCursoService;
    @PostMapping
    public Curso crearCurso (@RequestBody Curso curso){
        return objCursoService.crearCurso(curso);
    }

    @PutMapping
    public Curso actualizarCurso (@PathVariable int id, @RequestBody Curso curso){
        return objCursoService.actualizarCurso(id, curso);
    }

    @GetMapping
    public List<Curso> listarCurso(){
        return objCursoService.listarCurso();
    }
    @GetMapping("{id}")
    public Curso listarUsuarioId(@PathVariable int id){
        return objCursoService.listarCursoId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
    }

    @DeleteMapping
    public void eliminarCurso2(@RequestBody Curso curso){
        objCursoService.eliminarCurso2(curso);
    }


}
