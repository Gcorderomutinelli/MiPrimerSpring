package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Usuario;

import java.util.List;

public interface IAlumnoService {

    public Alumno crearAlumno(Alumno alumnoCreado);

    public Alumno actualizarAlumno(Alumno alumno);

    public Alumno actualizarAlumno(int id, Alumno alumnoActualizar);

    public List<Alumno> listarAlumno();

    public void eliminarAlumno(int id);

    public void eliminarAlumno2(Alumno alumno);
    public Alumno listarAlumnoId(int id);

}
