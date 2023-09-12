package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.service.ICursoService;
import cl.awakelab.miprimerspring.service.IProfesorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Profesor")
public class ProfesorController {

    @Autowired
    IProfesorService objProfesorService;
    @Autowired
    ICursoService objCursoService;
    @GetMapping("/crearProfesor")
    public String mostrarFormularioCrearProfesor(Model model){
        List<Curso> listaCurso = objCursoService.listarCurso();
        model.addAttribute("atributoListarCurso", listaCurso);
        return "templateFormularioCrearProfesor";
    }

    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor, @RequestParam("cursoId") int cursoId) { // se le entrega el valor de curso como entero despues de la solicitud a cursoId
        Curso cursoAsignado = objCursoService.listarCursoId(cursoId); //se busca un curso por id
        profesor.getListaCursos().add(cursoAsignado); // se le asigna el curso al profe mediante el curso asignado de arriba
        objProfesorService.crearProfesor(profesor);
        return "redirect:/Profesor";
    }




    @GetMapping
    public String listarProfesor(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesor";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/Profesor";
    }


}
