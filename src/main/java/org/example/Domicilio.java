package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Domicilio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombreCalle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

    public Domicilio(String nombreCalle, int numero){
        this.nombreCalle=nombreCalle;
        this.numero=numero;
    }

}