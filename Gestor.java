import java.util.ArrayList;
import java.util.Scanner;
    public class Gestor {
        private ArrayList<Mesa> mesas;
        private ArrayList<Plato> platos;
        private Scanner scanner;

        public Gestor() {
            mesas = new ArrayList<>();
            platos = new ArrayList<>();
            scanner = new Scanner(System.in);
            inicializarMesas();
            inicializarPlatos();
        }

        private void inicializarMesas() {
            mesas.add(new Mesa("1", 4, EstadoMesa.DISPONIBLE));
            mesas.add(new Mesa("2", 2,EstadoMesa.DISPONIBLE));
            mesas.add(new Mesa("3", 6,EstadoMesa.DISPONIBLE));
        }

        private void inicializarPlatos() {
            platos.add(new Plato("Spaghetti",TipoDePlato.PASTA, 3700));
            platos.add(new Plato("Ensalada", TipoDePlato.ENTRADA,2800));
            platos.add(new Plato("Pizza", TipoDePlato.PRINCIPAL,11000));

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
            mesaSeleccionada.setEstado(EstadoMesa.OCUPADA);
            gestionarPedido(mesaSeleccionada);
        }

        private void gestionarPedido(Mesa mesa) {
            if (mesa.getPedido() == null) {
                mesa.setPedido(new Pedido());
            }
            Pedido pedido = mesa.getPedido();

            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Listar platos");
                System.out.println("2. Agregar plato al pedido");
                System.out.println("3. Mostrar total del pedido");
                System.out.println("4. Cobrar mesa");
                System.out.println("5. Volver");

                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        listarPlatos();
                        break;
                    case 2:
                        agregarPlatoAPedido(pedido);
                        break;
                    case 3:
                        System.out.println("Total del pedido: $" + pedido.getTotal());
                        break;
                    case 4:
                        cobrarMesa(mesa);
                        return;
                    case 5:
                        return;
                    default:
                        System.out.println("Opción no válida, intente de nuevo.");
                }
            }
        }

        private void listarPlatos() {
            for (Plato plato : platos) {
                System.out.println(plato);
            }
        }

        private void agregarPlatoAPedido(Pedido pedido) {
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

        private void cobrarMesa(Mesa mesa) {
            Pedido pedido = mesa.getPedido();
            if (pedido == null || pedido.getTotal() == 0) {
                System.out.println("No hay pedido para cobrar en esta mesa.");
                return;
            }

            System.out.println("Cobrar mesa " + mesa.getNumero() + " con total de $" + pedido.getTotal());
            // generar factura y registrar el pago
            mesa.setPedido(null); // Limpiar el pedido de la mesa después de cobrar y guardar en algun lado
            mesa.setEstado(EstadoMesa.DISPONIBLE); // Cambiar el estado de la mesa a DISPONIBLE
        }


    }

