package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
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
