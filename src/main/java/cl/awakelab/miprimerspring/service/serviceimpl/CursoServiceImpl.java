package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Curso crearCurso(Curso cursoCreado) {
        return objCursoRepo.save(cursoCreado); //Manera corta de Crear
    }

    @Override
    public Curso actualizarCurso(int id, Curso cursoActualizar) {
        Curso cursoEcontrado = objCursoRepo.findById(id).orElse(null);
        cursoEcontrado.setNombreCurso(cursoActualizar.getNombreCurso());
        cursoEcontrado.setListaAlumnos(cursoActualizar.getListaAlumnos());
        cursoEcontrado.setListaProfesores(cursoActualizar.getListaProfesores());
        return objCursoRepo.save(cursoEcontrado);
    }

    @Override
    public Curso actualizarCurso(Curso cursoActualizar) {
        Curso cursoEcontrado = objCursoRepo.findById(cursoActualizar.getId()).orElse(null);
        cursoEcontrado.setNombreCurso(cursoActualizar.getNombreCurso());
        cursoEcontrado.setListaAlumnos(cursoActualizar.getListaAlumnos());
        cursoEcontrado.setListaProfesores(cursoActualizar.getListaProfesores());
        return objCursoRepo.save(cursoEcontrado);
    }



    @Override
    public List<Curso> listarCurso() {
        List<Curso> listaCurso = new ArrayList<>();
        listaCurso = objCursoRepo.findAll();
        return listaCurso;

    }

    @Override
    public void eliminarCurso(int id) {
        objCursoRepo.deleteById(id);

    }

    @Override
    public void eliminarCurso2(Curso curso) {
        objCursoRepo.delete(curso);
    }

    @Override
    public Curso listarCursoId(int id) {

        return objCursoRepo.findById(id).orElse(null);

    }




}
