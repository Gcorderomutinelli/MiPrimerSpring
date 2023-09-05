package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {
    @Autowired
    IProfesorRepository objProfesorRepo;
    @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
       Profesor nuevoProfesor = new Profesor();
       nuevoProfesor = objProfesorRepo.save(profesorCreado);
        return nuevoProfesor; //Manera Larga de Crear
    }

    @Override
    public Profesor actualizarProfesor(int id, Profesor profesorActualizar) {
        Profesor profesorEncontrado = objProfesorRepo.findById(id).orElse(null);
        profesorEncontrado.setNombres(profesorActualizar.getNombres());
        profesorEncontrado.setApellido1(profesorActualizar.getApellido1());
        profesorEncontrado.setApellido2(profesorActualizar.getApellido2());
        profesorEncontrado.setListaCursos(profesorActualizar.getListaCursos());
        return objProfesorRepo.save(profesorEncontrado);
    }

    @Override
    public List<Profesor> listarProfesor() {
        List<Profesor> listaAMostrar = new ArrayList<>();
        listaAMostrar = objProfesorRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public void eliminarProfesor(int id) {
        objProfesorRepo.deleteById(id);

    }

    @Override
    public void eliminarProfesor2(Profesor profesor) {
        objProfesorRepo.delete(profesor);
    }

    @Override
    public Profesor listarProfesorId(int id) {

        return objProfesorRepo.findById(id).orElse(null);
    }
}
