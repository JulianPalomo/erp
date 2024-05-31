package org.example.model;

public class Mesa {

    private String numero;
    private int capacidad;
    private EstadoMesa estado;

    private Pedido pedido;

    //private Mecero mecero asignado;


    public Mesa(String numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = EstadoMesa.DISPONIBLE;
        this.pedido = null;
    }

    public Mesa(String numero, int capacidad, EstadoMesa estado)
    {
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = estado;
        this.pedido = null;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Mesa [numero=" + numero + ", capacidad" + capacidad + ", estado=" + estado + "]";
    }


}
