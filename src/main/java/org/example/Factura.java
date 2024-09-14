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
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Factura implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "numero")
    private int numero;

    @Column(name = "total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalleFactura = new ArrayList<DetalleFactura>();

    public Factura(String fecha, int numero, int total){
        this.fecha=fecha;
        this.numero=numero;
        this.total=total;
    }

}
