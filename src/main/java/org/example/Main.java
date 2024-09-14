package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            /*
            Factura factura1 = new Factura();

            factura1.setNumero(12);
            factura1.setFecha("10/08/2020");

            Domicilio dom = new Domicilio("San Martin", 1222);
            Cliente cliente1 = new Cliente("Pablo", "Muñoz", 15245883);
            cliente1.setDomicilio(dom);
            dom.setCliente(cliente1);

            factura1.setCliente(cliente1);

            Categoria perecederos = new Categoria("Perecederos");
            Categoria lacteos = new Categoria("Lacteos");
            Categoria limpieza = new Categoria("Limpieza");

            Articulo art1 = new Articulo(200, "Yogurt", 20);
            Articulo art2 = new Articulo(300, "Magistral", 80);

            art1.getCategoria().add(perecederos);
            art1.getCategoria().add(lacteos);
            lacteos.getArticulo().add(art1);
            perecederos.getArticulo().add(art1);

            art2.getCategoria().add(limpieza);
            limpieza.getArticulo().add(art2);

            DetalleFactura det1 = new DetalleFactura();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            art1.getDetallefactura().add(det1);
            factura1.getDetalleFactura().add(det1);
            det1.setFactura(factura1);

            DetalleFactura det2 = new DetalleFactura();
            det2.setArticulo(art2);
            det2.setCantidad(2);
            det2.setSubtotal(80);

            art2.getDetallefactura().add(det2);
            factura1.getDetalleFactura().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);


             */



            Factura factura1 = entityManager.find(Factura.class, 1L);
            //factura1.setNumero(85);

            entityManager.remove(factura1);

            System.out.println("si?");
            entityManager.flush();
            entityManager.getTransaction().commit();
            System.out.println("Si");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
