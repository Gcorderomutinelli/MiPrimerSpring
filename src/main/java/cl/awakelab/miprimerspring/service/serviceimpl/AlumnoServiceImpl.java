package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
   @Autowired
    IAlumnoRepository objAlumnoRepo; //Inyectamos la dependencia de Alumno
   @Autowired
    ICursoRepository objCursoRepo; //Inyectamos la dependencia de Curso
    @Override
    public Alumno crearAlumno(Alumno alumnoCreado) { //Metodo para crear un Alumno que se llamara alumnoCreado
        Alumno nuevoAlumno = new Alumno(); //Se crea la instancia de Alumno como nuevoAlumno
        Curso cursoAsignado = new Curso(); //Se crea la instancia de Curso como cursoAsignado
        cursoAsignado = objCursoRepo.findById(alumnoCreado.getCursoAsignado().getId()).orElse(null); //Aqui se busca un curso ya creado en la Base de datos por el id del Curso y se le asigna al Alumno creado
        alumnoCreado.setCursoAsignado(cursoAsignado); //Aqui se realiza la relacion entre el Alumno y el Curso
        nuevoAlumno = objAlumnoRepo.save(alumnoCreado);
        return nuevoAlumno; //Manera larga de crear
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumnoActualizar) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(id).orElse(null);
        alumnoEncontrado.setNombres(alumnoActualizar.getNombres());
        alumnoEncontrado.setApellido1(alumnoActualizar.getApellido1());
        alumnoEncontrado.setApellido2(alumnoActualizar.getApellido2());
        alumnoEncontrado.setCursoAsignado(alumnoActualizar.getCursoAsignado());
        return objAlumnoRepo.save(alumnoEncontrado);

    }

    @Override
    public List<Alumno> listarAlumno() {
        List<Alumno>  listaAlumno = new ArrayList<>();
        listaAlumno = objAlumnoRepo.findAll();
        return listaAlumno;
    }

    @Override
    public void eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id); //Eliminar por ID

    }

    @Override
    public void eliminarAlumno2(Alumno alumno) {
        objAlumnoRepo.delete(alumno); //Eliminar por objeto completo

    }

    @Override
    public Alumno listarAlumnoId(int id) {

        return objAlumnoRepo.findById(id).orElse(null);
    }
}
