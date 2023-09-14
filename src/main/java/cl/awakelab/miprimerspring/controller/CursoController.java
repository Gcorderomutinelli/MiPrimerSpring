package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Curso")
public class CursoController {

    @Autowired
    ICursoService objCursoService;

    @GetMapping("/crearCurso")
    public String mostrarFormularioCrearCurso(){
        return "templateFormularioCrearCurso";
    }

    @PostMapping("/crearCurso")
    public String crearCurso(@ModelAttribute Curso curso){
        objCursoService.crearCurso(curso);
        return "redirect:/Curso";
    }

    @PostMapping("/editar")
    public String editarCurso(@ModelAttribute Curso datosParaActualizar){
        Curso curso = objCursoService.listarCursoId(datosParaActualizar.getId());
        curso.setNombreCurso(datosParaActualizar.getNombreCurso());
        curso.setListaProfesores(datosParaActualizar.getListaProfesores());
        curso.setListaAlumnos(datosParaActualizar.getListaAlumnos());
        objCursoService.actualizarCurso(curso);
        return "redirect:/Curso";
    }

    @GetMapping("editar/{id}")
    public String editarCurso(Model model,@PathVariable("id") int id) {
        Curso curso = objCursoService.listarCursoId(id);
        model.addAttribute("curso", curso);
        return "templateFormularioModificarCurso";

    }



    @GetMapping
    public String listarCurso(Model model){
        List<Curso> listaCurso= objCursoService.listarCurso();
        model.addAttribute("atributoListaCurso", listaCurso);
        return "templateListarCurso";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return "redirect:/Curso";
    }




}
