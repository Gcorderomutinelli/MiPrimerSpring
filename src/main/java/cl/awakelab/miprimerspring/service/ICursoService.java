package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Usuario;

import java.util.List;

public interface ICursoService {

    public Curso crearCurso(Curso cursoCreado);

    public Curso actualizarCurso(int id, Curso cursoActualizar);

    public List<Curso> listarCurso();

    public void eliminarCurso(int id);

    public void eliminarCurso2(Curso curso);

    public Curso listarCursoId(int idCurso);



}
