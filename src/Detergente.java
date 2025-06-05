

public class Detergente extends Producto implements ILiquido, IDescuento {
    double volumen;
    String tipoEnvase;
    double descuento;

    public Detergente(String marca, double precio) {
        super(precio, marca, "Detergente");
    }

    public Detergente(double precio, String marca, double volumen, String tipoEnvase, double descuento) {
        super(precio, marca, "Detergente");
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Detergente{" +
                "marca='" + marca + '\'' +
                ", precio=" + precio +'}';

    /*
                               ####################
    ############################>Getters y Seters<###############################
                              #####################
    */


    }

    //######################  Iliquido  ########################################

    @Override
    public double getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String envase) {
        this.tipoEnvase = envase;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    //########################################################################

    //################### IDescuento ########################################

    @Override
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double getPrecioDesscuento() {
        return Utilidades.calcularDescuento(precio, descuento);
    }

    @Override
    public double getPrecio() {
        return getPrecioDesscuento();
    }
}
