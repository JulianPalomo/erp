package org.example.controllers;


import org.example.model.EstadoMesa;
import org.example.model.Mesa;

import java.util.ArrayList;
import java.util.Scanner;

public class MesaController {
    private ArrayList<Mesa> mesas;
    private PlatoController platoController;
    private Scanner scanner;

    public MesaController() {
        mesas = new ArrayList<>();
        scanner = new Scanner(System.in);
        platoController = new PlatoController(); // Instancia del controlador de platos
        inicializarMesas();
    }

    private void inicializarMesas() {
        mesas.add(new Mesa("1", 4, EstadoMesa.DISPONIBLE));
        mesas.add(new Mesa("2", 2, EstadoMesa.DISPONIBLE));
        mesas.add(new Mesa("3", 6, EstadoMesa.DISPONIBLE));
    }

    public void iniciar() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Listar mesas");
            System.out.println("2. Seleccionar mesa");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarMesas();
                    break;
                case 2:
                    seleccionarMesa();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private void listarMesas() {
        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }
    }

    private void seleccionarMesa() {
        System.out.println("Ingrese el número de la mesa:");
        String numeroMesa = scanner.nextLine();
        Mesa mesaSeleccionada = null;
        for (Mesa mesa : mesas) {
            if (mesa.getNumero().equals(numeroMesa)) {
                mesaSeleccionada = mesa;
                break;
            }
        }

        if (mesaSeleccionada == null) {
            System.out.println("Mesa no encontrada.");
            return;
        }

        System.out.println("Mesa seleccionada: " + mesaSeleccionada);
        mesaSeleccionada.setEstado(EstadoMesa.OCUPADA));
        platoController.gestionarPedido(mesaSeleccionada); // Llamada al controlador de platos
    }
}
