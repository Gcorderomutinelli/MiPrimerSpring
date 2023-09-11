package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    IAlumnoService objAlumnoService;
    @Autowired
    ICursoService objCursoService;

    @GetMapping("/crearAlumno")
    public String mostrarFormularioCrearAlumno(Model model){
        List<Curso> listaCurso = objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCurso);
        return "templateFormularioCrearAlumno";
    }


    @PostMapping("crearAlumno")
    public String crearAlmuno(@ModelAttribute Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/Alumno";
    }

    @GetMapping
    public String listarAlumno(Model model){
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumno();
        model.addAttribute("atributoListaAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/Alumno";
    }
}
