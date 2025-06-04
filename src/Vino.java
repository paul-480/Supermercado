import java.time.LocalDate;

public class Vino extends Producto implements IDescuento, ILiquido, IAlimento {
    private int graduacionAlcolica;

    private enum tipos {BLANCOJOVEN, BLANCOCRIANZA, TINTOJOVEN,
        TINTOCRIANZA, TINTORESERVA, TINTOGRANRESERVA, DESCONOCIDO}

    private tipos tipo;
    private LocalDate fechaAlmacenaje;
    private double descuento;
    private double volumen;
    private String envase;

    public Vino(double precio, String marca) {
        super(precio, marca, "Vino");
    }

    public Vino(double precio, String marca, int graduacionAlcolica, String tipo, LocalDate fechaAlmacenaje, double descuento, double volumen, String envase) {
        super(precio, marca, "Vino");
        this.graduacionAlcolica = graduacionAlcolica;
        this.tipo = tipos.valueOf(tipo);
        this.fechaAlmacenaje = fechaAlmacenaje;
        this.descuento = descuento;
        this.volumen = volumen;
        this.envase = envase;
    }

    public int getGraduacionAlcolica() {
        return graduacionAlcolica;
    }

    public void setGraduacionAlcolica(int graduacionAlcolica) {
        this.graduacionAlcolica = graduacionAlcolica;
    }

    public String getTipo() {
        return String.valueOf(tipo);
    }

    public void setTipo(String tipo) {
        try {
            this.tipo = tipos.valueOf(tipo);
        } catch (IllegalArgumentException e) {
            this.tipo = tipos.DESCONOCIDO;
        }

    }

    @Override
    public String toString() {
        return "Vino{" +
                "precio=" + precio +
                ", marca='" + marca + '\'' +
                '}';
    }

    /*
                               ####################
    ############################>Getters y Seters<###############################
                              #####################
    */
    //######################  IAlimento  ########################################

    @Override
    public void SetCaducidad(LocalDate fechaAlmacenaje) {
        this.fechaAlmacenaje = fechaAlmacenaje;
    }

    @Override
    public boolean isCaducado() {
        return getCaducidad().isBefore(LocalDate.now());
    }

    @Override
    public LocalDate getCaducidad() {
        return fechaAlmacenaje;
    }

    @Override
    public int getCalorias() {
        return graduacionAlcolica * 10;
    }

    /*#############################################################################

    ########################   IDescuento   #######################################
    */
    @Override
    public void setDescuento ( double descuento){
        this.descuento = descuento;
    }

    @Override
    public double getDescuento () {
        return descuento;
    }

    @Override
    public double getPrecioDesscuento () {
        return Utilidades.calcularDescuento(precio, descuento);
    }

    /*#############################################################################

    ########################   ILiquido   #######################################
    */


    @Override
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public double getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String envase) {
        this.envase = envase;
    }

    @Override
    public String getTipoEnvase() {
        return envase;
    }
    //###########################################################################


    @Override
    public double getPrecio() {
        return getPrecioDesscuento();
    }
}
