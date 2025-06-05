import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class Cereales extends Producto implements IAlimento {

    private enum tiposCereal {ESPELTA, MAIZ, TRIGO, OTROS}

    private tiposCereal tipoCereal;
    private LocalDate fechaAlmacenamiento;

    public Cereales(double precio, String marca, String tipoCereal) {
        super(precio, marca, "Cereal");
        try {
            this.tipoCereal = tiposCereal.valueOf(tipoCereal.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            this.tipoCereal = tiposCereal.OTROS;
        }

    }

    /*
                               ####################
    ############################>Getters y Seters<###############################
                              #####################
    */
    //######################  IAlimento  ########################################

    @Override
    public void SetCaducidad(LocalDate fechaAlmacenamiento) {
        this.fechaAlmacenamiento = fechaAlmacenamiento;
    }

    @Override
    public LocalDate getCaducidad() {
        switch (tipoCereal){
            case TRIGO -> {return fechaAlmacenamiento.plusMonths(12);}
            case MAIZ -> {return fechaAlmacenamiento.plusMonths(24);}
            case ESPELTA -> {return fechaAlmacenamiento.plusMonths(6);}
            case null, default -> {return fechaAlmacenamiento.plusMonths(5);}
        }
    }

    @Override
    public int getCalorias() {
        switch (tipoCereal) {
            case MAIZ -> {
                return 8;
            }
            case ESPELTA -> {
                return 5;
            }
            case TRIGO -> {
                return 12;
            }
            default -> {
                return 15;
            }
        }
    }

    @Override
    public boolean isCaducado() {
        return getCaducidad().isBefore(LocalDate.now());
    }

    public void setCaducidad(LocalDate caducidad) {
        this.fechaAlmacenamiento = caducidad;
    }

    @Override
    public String toString() {
        return "Cereal{" +
                "tipoCereal=" + tipoCereal +
                ", caducidad=" + fechaAlmacenamiento +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                '}';
    }
}
