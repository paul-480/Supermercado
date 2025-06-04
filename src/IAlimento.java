import java.time.LocalDate;

public interface IAlimento  {
    void SetCaducidad(LocalDate caducidad);

    LocalDate getCaducidad();

    int getCalorias();

    boolean isCaducado();

}
