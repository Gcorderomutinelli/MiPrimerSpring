package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Usuario;
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


    @PostMapping("/editar")
    public String editarAlumno(@ModelAttribute Alumno datosParaActualizar){
        Alumno alumno = objAlumnoService.listarAlumnoId(datosParaActualizar.getId());
        alumno.setNombres(datosParaActualizar.getNombres());
        alumno.setApellido1(datosParaActualizar.getApellido1());
        alumno.setApellido2(datosParaActualizar.getApellido2());
        alumno.setCursoAsignado(datosParaActualizar.getCursoAsignado());
        objAlumnoService.actualizarAlumno(alumno);
        return "redirect:/Alumno";
        }

    @GetMapping("editar/{id}")
    public String editarAlumno(Model model,@PathVariable("id") int id) {
        Alumno alumno = objAlumnoService.listarAlumnoId(id);
        model.addAttribute("alumno", alumno);
        return "templateFormularioModificarAlumno";
        }

        @GetMapping
        public String listarAlumno (Model model){
            List<Alumno> listaAlumnos = objAlumnoService.listarAlumno();
            model.addAttribute("atributoListaAlumnos", listaAlumnos);
            return "templateListarAlumnos";
        }

        @PostMapping("/eliminar/{id}")
        public String eliminarAlumno ( @PathVariable int id){
            objAlumnoService.eliminarAlumno(id);
            return "redirect:/Alumno";
        }
    }
