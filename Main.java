import Enums.TipoDePlato;
import Enums.metodoDePago;
import GestorFactura.Factura;
import GestorFactura.GestorFactura;
import GestorFactura.GestorPedidos;
import GestorFactura.Plato;

public class Main {
    public static void main(String[] args) {

        // Crear algunos platos
        Plato plato1 = new Plato("Pizza", TipoDePlato.PRINCIPAL, 10.0);
        Plato plato2 = new Plato("Ensalada", TipoDePlato.ENTRADA, 5.0);
        Plato plato3 = new Plato("Helado", TipoDePlato.POSTRE, 3.0);

        // Crear gestor de pedidos y agregar platos
        GestorPedidos gestorPedidos = new GestorPedidos();
        gestorPedidos.agregarPedido(plato1);
        gestorPedidos.agregarPedido(plato2);
        gestorPedidos.agregarPedido(plato3);

        // Calcular total de los pedidos
        double totalPedido = gestorPedidos.calcularTotal();
        System.out.println("Total del pedido: $" + totalPedido);

        // Generar factura y mostrar método de pago
        GestorFactura gestorFacturas = new GestorFactura();
        Factura factura = gestorFacturas.generarFactura(gestorPedidos, metodoDePago.EFECTIVO);
        System.out.println("Factura generada con método de pago: " + factura.getMetodoDePago());
    }
    }
