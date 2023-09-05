package cl.awakelab.miprimerspring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column( unique = true, nullable = false, length = 50)
    private String nombreUsuario;

    @Column(length = 30)
    private String contrasena;

    @Column(length = 35)
    private String rol;





}
