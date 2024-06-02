package org.example.controllers;

import org.example.model.Pedido;
import org.example.model.Plato;
import org.example.model.TipoDePlato;

import java.util.ArrayList;
import java.util.Scanner;

public class PlatoController {

    private ArrayList<Plato> platos;
    private Scanner scanner;

    public PlatoController() {
        platos = new ArrayList<>();
        scanner = new Scanner(System.in);
        inicializarPlatos();
    }

    public void inicializarPlatos() {
        platos.add(new Plato("Spaghetti", TipoDePlato.PASTA, 3700));
        platos.add(new Plato("Ensalada", TipoDePlato.ENTRADA, 2800));
        platos.add(new Plato("Pizza", TipoDePlato.PRINCIPAL, 11000));
    }

    public void listarPlatos() {
        for (Plato plato : platos) {
            System.out.println(plato);
        }
    }
    public void agregarPlatoAPedido(Pedido pedido) {
        System.out.println("Ingrese el nombre del plato a agregar:");
        String nombrePlato = scanner.nextLine();
        Plato platoSeleccionado = null;
        for (Plato plato : platos) {
            if (plato.getNombre().equalsIgnoreCase(nombrePlato)) {
                platoSeleccionado = plato;
                break;
            }
        }

        if (platoSeleccionado == null) {
            System.out.println("Plato no encontrado.");
            return;
        }

        pedido.agregarPlato(platoSeleccionado);
        System.out.println("Plato agregado al pedido.");
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }
}
