package cl.awakelab.miprimerspring.service;



import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.entity.Usuario;

import java.util.List;

public interface IProfesorService {

    public Profesor crearProfesor(Profesor profesorCreado);

    public Profesor actualizarProfesor(int id, Profesor profesorActualizar);

    public List<Profesor> listarProfesor();

    public void eliminarProfesor(int id);

    public void eliminarProfesor2(Profesor profesor);

    public Profesor listarProfesorId(int id);


}
