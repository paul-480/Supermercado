public abstract class Producto {
    protected String producto;
    protected double precio;
    protected String marca;

    protected Producto(double precio, String marca, String producto) {
        this.precio = Utilidades.validarPositivo(precio);
        this.marca = marca;
        this.producto= producto;
    }

    public Producto() {
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public abstract String toString();
}
