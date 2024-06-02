package GestorFactura;
import Enums.metodoDePago;

import java.util.ArrayList;
import java.util.List;


public class GestorFactura {
    private List<Factura> facturas;

    public GestorFactura() {
        this.facturas= new ArrayList<>();
    }

    public Factura generarFactura(GestorPedidos gestorPedidos, Enums.metodoDePago metodoDePago) {
        double total=gestorPedidos.calcularTotal();
        Factura factura=new Factura(total,metodoDePago);
        facturas.add(factura);
        return factura;
    }
}
