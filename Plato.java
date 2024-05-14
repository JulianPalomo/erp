public class Plato {
    private static int contador = 0;  // Variable estática para mantener el próximo ID disponible
    private int id;
    private String nombre;
    private TipoDePlato tipoDePlato;
    private double precio;

    public Plato( String nombre, TipoDePlato tipoDePlato, double precio) {
        this.id =contador++;
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

}
