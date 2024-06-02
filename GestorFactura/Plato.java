package GestorFactura;

import Enums.TipoDePlato;

import java.util.Objects;

public class Plato {
    private static int contador = 0;  // Variable estática para mantener el próximo ID disponible
    private int id;
    private String nombre;
    private TipoDePlato tipoDePlato;
    private double precio;

    public Plato( String nombre, TipoDePlato tipoDePlato, double precio) {
         synchronized (Plato.class) {
             this.id =contador++;
         }
        this.nombre = nombre;
        this.tipoDePlato = tipoDePlato;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDePlato getTipoDePlato() {
        return tipoDePlato;
    }

    public void setTipoDePlato(TipoDePlato tipoDePlato) {
        this.tipoDePlato = tipoDePlato;
    }

    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plato plato = (Plato) o;
        return id == plato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "******************************************" +
                "Plato:" +
                "\nNumero de Plato=" + id +
                "\nNombre==> " + nombre +
                "\n Tipo de Plato=" + tipoDePlato +
                "\n Precio=" + precio +
                "\n******************************************";
    }
}
