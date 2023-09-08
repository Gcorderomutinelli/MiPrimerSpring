package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Alumno")
public class AlumnoController {

    @Autowired
    IAlumnoService objAlumnoService;

    @GetMapping("/crearAlumno")
    public String mostrarFormularioCrearAlumno(){
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
