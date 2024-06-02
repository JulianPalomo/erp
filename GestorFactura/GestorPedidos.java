package GestorFactura;

import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {
    private List<Plato> pedidos;

    public GestorPedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Plato plato){
        pedidos.add(plato);
    }
    public void eliminarPLato(Plato plato) {
        pedidos.remove(plato);
    }
    public List<Plato> getPedidos(){
        return new ArrayList<>(pedidos);
    }

    public double calcularTotal() {
        return pedidos.stream()
                .mapToDouble(Plato::getPrecio)
                .sum();
    }
}
