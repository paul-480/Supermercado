import java.util.*;

public class Main {

    public static Scanner in = new Scanner(System.in);
    private static  Map<Producto,Integer> carrito = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Aplicacion carrito");
        int opcion;
        do {
            System.out.println("<=======_Menú Principal_=======>");
            System.out.println("1.Mostrar el carrito");
            System.out.println("2.Añadir Productos");
            System.out.println("3.Calcular calorias totales");
            System.out.println("4.Seleccionar un producto de la lista");
            opcion = in.nextInt();
            in.nextLine();
            System.out.print("Sue eleccion: ");
            switch (opcion){
                case 1 -> {
                    mostrarCarrito();
                }
                case 2 ->{
                    addProducto();
                }
                case 3->{
                    calcularCalorias();
                }
            }
        }while(opcion!=7);
    }

    private static void calcularCalorias() {
        int totalCalorias=0;

        for (Map.Entry<Producto, Integer> linea : carrito.entrySet()) {
            Producto producto = linea.getKey();

            int cantidad = linea.getValue();
            if (producto instanceof IAlimento alimento) {
                System.out.println("Producto: "+ producto.producto);
                int caloriasUnidad = alimento.getCalorias();
                System.out.println("Calorias: "+ caloriasUnidad);
                int caloriasPorAlimento = caloriasUnidad * cantidad;
                System.out.println("Calorias por alimento: "+caloriasPorAlimento);
                totalCalorias+= caloriasPorAlimento;
            }
        }
        System.out.println("######################### total calorias: "+totalCalorias);
    }

    private static void mostrarCarrito() {
        double precioTotal = 0;

        for (Map.Entry<Producto, Integer> producto : carrito.entrySet()) {

            int cantidad = producto.getValue();
            double precioUnidad = producto.getKey().getPrecio();

            double precioTotalProducto= cantidad * precioUnidad;
            precioTotal+=precioTotalProducto;
            System.out.println(producto.getKey()+ "Cantidad: " + producto.getValue()+
                    " Precio por total: "+ precioTotalProducto );
        }
        System.out.println("###########################################\n");
        System.out.println("Total carrito: "+precioTotal);
    }

    private static void addProducto() {
        int opcion=0;

        do {
            System.out.println("<=======_Menú Añadir Producto_=======>");
            System.out.println("1.Añadir detergente");
            System.out.println("2.Añadir cereal");
            System.out.println("3.Añadir vino");
            System.out.println("4.Volver");
            System.out.print("Su elección: ");
            opcion=in.nextInt();
            in.nextLine();
            switch (opcion){
                case 1->{addDetergente();}
                case 2->{addCereal();}
                case 3 ->{addVino();}
                case 4 -> {
                    System.out.println("Saliendo...");
                }
                default -> {System.err.println("Opción incorrecta");}
            }
        }while (opcion!= 4);

    }


    //todo advino
    private static void addVino() {
    }

    private static void addCereal() {
        int opcion;
        do {
            System.out.println("<=======_Sección de detergentes_=======> ");
            System.out.println("1.Añadir Kellogg's (Descuento 25%)");
            System.out.println("2.Añadir Miel Pops");
            System.out.println("3.Añadir Personalizada");
            System.out.println("4.Volver");

            opcion= in.nextInt();

            switch (opcion){
                case 1->{
                    addKellogs();
                }
                case 2 ->{
                    addMPops();
                }
                case 3 ->{
                    addOwnDetergente();
                }
                case 4 -> {System.out.println("Saliendo...");}
                default -> {System.err.println("Opcion no reconocida");}

            }
        }while (opcion!=4);
    }


    //todo admpops y addkellogs
    private static void addMPops() {
    }

    private static void addKellogs() {
    }

    private static void addDetergente() {
        int opcion;
        do {
            System.out.println("<=======_Sección de detergentes_=======> ");
            System.out.println("1.Añadir Fairy (Descuento 25%)");
            System.out.println("2.Añadir Vanish");
            System.out.println("3.Añadir Personalizada");
            System.out.println("4.Volver");

            opcion= in.nextInt();

            switch (opcion){
                case 1->{
                    addFairy();
                }
                case 2 ->{
                    addVanish();
                }
                case 3 ->{
                    addOwnDetergente();
                }
                case 4 -> {System.out.println("Saliendo...");}
                default -> {System.err.println("Opcion no reconocida");}

            }
        }while (opcion!=4);
    }

    private static void addOwnDetergente() {
        System.out.println("Añadiendo nuevo detergente");
        System.out.print("Introduzca el precio: ");
        double precio = in.nextDouble();
        in.nextLine();
        System.out.print("Introduzca el nombre de la marca: ");
        String marca = in.nextLine();
        System.out.print("Introduzca el volumen: ");
        double volumen = in.nextDouble();
        in.nextLine();
        System.out.print("Introduzca el tipo de envase: ");
        String envase= in.nextLine();
        System.out.print("Introduzca el descuento: ");
        int descuento = in.nextInt();
        in.nextLine();
        System.out.print("Introduzca la cantidad: ");
        int cantidad = in.nextInt();
        in.nextLine();
        carrito.merge(new Detergente(precio,marca,volumen,envase,descuento),cantidad,Integer::sum);
    }

    private static void addVanish() {
        Detergente vanish = new Detergente(7.99,"Vanish", 2500, "Plastico", 0);
        System.out.print("Introduzca la cantidad: ");
        int cantidad = in.nextInt();
        in.nextLine();
        carrito.merge(vanish,cantidad,Integer::sum);
    }

    private static void addFairy() {
        Detergente fairy = new Detergente(7.99,"Fairy", 2500, "Plastico", 25);
        System.out.print("Introduzca la cantidad: ");
        int cantidad = in.nextInt();
        in.nextLine();
        carrito.merge(fairy,cantidad,Integer::sum);
    }
}