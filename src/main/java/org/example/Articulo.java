package org.example;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Articulo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "precio")
    private int precio;

    @OneToMany(mappedBy = "articulo")
    private List<DetalleFactura> detallefactura = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ArticuloCategoria", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<org.example.Categoria> categoria = new ArrayList<org.example.Categoria>();


    public Articulo(int cantidad, String denominacion, int precio){
        this.cantidad=cantidad;
        this.denominacion=denominacion;
        this.precio=precio;
    }

}