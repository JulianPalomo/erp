package org.example.model;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private ArrayList<Plato> listaPlatos;
    private double total;

    private Date fecha;

    //private EstadoPedido estadoPedido;

    private Factura factura;

    public Pedido() {
        this.listaPlatos = new ArrayList<Plato>();
        this.total = 0;
        this.fecha = new Date();

    }

    public ArrayList<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(ArrayList<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }
    public void agregarPlato(Plato plato) {
        listaPlatos.add(plato);
        total += plato.getPrecio();
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Date getFecha() {
        return fecha;
    }
    @Override
    public String toString() {
        return "Pedido [listaPlatos=" + listaPlatos + ", total=" + total + ", fecha=" + fecha + "]";
    }
}