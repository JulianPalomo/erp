package GestorFactura;

import Enums.metodoDePago;

import java.util.Objects;

public class Factura {

    private static int contador = 0;  // Variable estática para mantener el próximo ID disponible
    private final int id;
    private double total;
    private Enums.metodoDePago metodoDePago;

    public Factura(double total, metodoDePago metodoDePago) {
        synchronized (Factura.class) {
            this.id = contador++;  // Incrementa y asigna el ID
        }
        this.total = total;
        this.metodoDePago = metodoDePago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public metodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(metodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return id == factura.id && Double.compare(total, factura.total) == 0 && metodoDePago == factura.metodoDePago;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, metodoDePago);
    }

    @Override
    public String toString() {
        return "*************************************************" +
                "GestorFactura.Factura " +
                "N°==>" + id +
                "\n Total=" + total +
                "\n Metodo de Pago=" + metodoDePago +
                "\n*************************************************";
    }
}
