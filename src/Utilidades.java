public class Utilidades {
    public static double validarPositivo(double numero) {
        if (numero > 0) return numero;
        else throw new NegativoInvalidoExcemption("El numero no puede ser inferior a 0");
    }

    public static double calcularDescuento(double precio, double descuento) {

        if (descuento!=0){
        return precio - (precio / 100 * descuento);}
        else return precio;
    }
}
