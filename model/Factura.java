package org.example.model;

public class Factura {

        private static int contador = 0;  // Variable estática para mantener el próximo ID disponible
        private final int id;
        private double total;
        private MetodoDePago metodoDePago;

        public Factura(double total, MetodoDePago metodoDePago) {
            this.id = contador++;  // Incrementa y asigna el ID
            this.total = total;
            this.metodoDePago = metodoDePago;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public MetodoDePago getMetodoDePago() {
            return metodoDePago;
        }

        public void setMetodoDePago(MetodoDePago metodoDePago) {
            this.metodoDePago = metodoDePago;
        }

        public int getId() {
            return id;
        }

}
