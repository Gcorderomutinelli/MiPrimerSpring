package cl.awakelab.miprimerspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String nombreCurso;

    @JsonIgnore// Para evitar le recursion entre listas de diferentes clases
    @ManyToMany(mappedBy = "listaCursos")
    private List<Profesor> listaProfesores;

    @JsonIgnore
    @OneToMany(mappedBy = "cursoAsignado")
    private List<Alumno> listaAlumnos;


}
