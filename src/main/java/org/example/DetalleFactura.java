package org.example;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "detalle_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class DetalleFactura implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_factura")
    private Factura factura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;

    public DetalleFactura(int cantidad, int subtotal){
        this.cantidad=cantidad;
        this.subtotal=subtotal;
    }


}