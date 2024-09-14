package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categoria")
    private List<Articulo> articulo = new ArrayList<Articulo>();

    public Categoria(String denominacion){
        this.denominacion=denominacion;
    }
}