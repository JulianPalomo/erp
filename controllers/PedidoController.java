package org.example.controllers;

import org.example.model.EstadoMesa;
import org.example.model.Mesa;
import org.example.model.Pedido;

import java.util.Scanner;

public class PedidoController {
    private static Scanner scanner;
    private static PlatoController platoController;

    public PedidoController() {
        scanner = new Scanner(System.in);
        platoController = new PlatoController(); // Instancia del controlador de platos
    }

    public static void gestionarPedido(Mesa mesa) {
        Pedido pedido = mesa.getPedido();
        if (pedido == null) {
            System.out.println("No hay pedido en esta mesa.");
            return;
        }

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar plato al pedido");
            System.out.println("2. Mostrar total del pedido");
            System.out.println("3. Cobrar mesa");
            System.out.println("4. Volver");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    platoController.agregarPlatoAPedido(pedido); // Llamar al controlador de platos para agregar un plato al pedido
                    break;
                case 2:
                    mostrarTotalPedido(pedido);
                    break;
                case 3:
                    cobrarMesa(mesa); // Cobrar la mesa
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    public static void mostrarTotalPedido(Pedido pedido) {
        System.out.println("Total del pedido: $" + pedido.getTotal());
    }

    public static void cobrarMesa(Mesa mesa) {
        // Lógica para cobrar la mesa
    }
}
    //crear pedido, guardar los pedidos cuando se cierren, imprimir comanda.

