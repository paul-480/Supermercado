import java.time.LocalDate;
import java.util.*;

public class Main {

    public static Scanner in = new Scanner(System.in);
    private static final Map<Producto,Integer> carrito = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Aplicacion carrito");
        int opcion;
        do {
            System.out.println("<=======_Menú Principal_=======>");
            System.out.println("1.Mostrar el carrito");
            System.out.println("2.Añadir Productos");
            System.out.println("3.Calcular calorias totales");
            System.out.println("4.Seleccionar un producto de la lista");
            System.out.println("5.Salir");
            System.out.print("Sue eleccion: ");
            opcion = in.nextInt();
            in.nextLine();
            switch (opcion){
                case 1 -> mostrarCarrito();
                case 2 -> addProducto();
                case 3-> calcularCalorias();
                case 4 -> elegirProducto();
                case 5-> System.out.println("Saliendo...");
            }
        }while(opcion!=5);
    }







    /*#####################################   Vinos   #######################################*/


    private static void addVino() {
        int opcion;
        do {
            System.out.println("<=======_Sección de vinos_=======> ");
            System.out.println("1. Añadir Vino Tinto Rioja(25% off)");
            System.out.println("2. Añadir Vino Blanco Albariño");
            System.out.println("3. Añadir Personalizado");
            System.out.println("4. Volver");

            opcion= in.nextInt();

            switch (opcion){
                case 1-> addRioja();
                case 2 -> addAlbarino();
                case 3 -> addOwnVino();
                case 4 -> System.out.println("Saliendo...");
                default -> System.err.println("Opcion no reconocida");

            }
        }while (opcion!=4);
    }

    private static void addOwnVino() {

            System.out.println("Añadiendo nuevo vino");

            System.out.print("Introduzca el precio: ");
            double precio = in.nextDouble();
            in.nextLine();

            System.out.print("Introduzca el nombre de la marca: ");
            String marca = in.nextLine();

            System.out.print("Introduzca la graduación alcohólica: ");
            int graduacion = in.nextInt();
            in.nextLine();

            System.out.print("Introduzca el tipo (BLANCOJOVEN, BLANCOCRIANZA, TINTOJOVEN, TINTOCRIANZA, TINTORESERVA, TINTOGRANRESERVA, DESCONOCIDO): ");
            String tipo = in.nextLine();

            System.out.print("Introduzca el descuento: ");
            double descuento = in.nextDouble();
            in.nextLine();

            System.out.print("Introduzca el volumen: ");
            double volumen = in.nextDouble();
            in.nextLine();

            System.out.print("Introduzca el tipo de envase: ");
            String envase = in.nextLine();

            int cantidad = getCantidad();


            LocalDate fechaAlmacenaje = LocalDate.now();

            Vino vinoPersonalizado = new Vino(precio, marca, graduacion, tipo, fechaAlmacenaje, descuento, volumen, envase);

            carrito.merge(vinoPersonalizado, cantidad, Integer::sum);

    }

    private static void addAlbarino() {
        Vino Rioja= new Vino(15, "Albariño",12,"Blancojoven",LocalDate.now(),0,1500,"Botella de cristal");
        int cantidad = getCantidad();
        carrito.merge(Rioja, cantidad, Integer::sum);
    }

    private static void addRioja() {
        Vino Rioja= new Vino(15, "Rioja",13,"Tintoreserva",LocalDate.now(),25,1500,"Botella de cristal");
        int cantidad = getCantidad();
        carrito.merge(Rioja, cantidad, Integer::sum);
    }

    /*#####################################   Cereales   #######################################*/

    private static void addCereal() {
        int opcion;
        do {
            System.out.println("<=======_Sección de cereales_=======> ");
            System.out.println("1.Añadir Kellogg's");
            System.out.println("2.Añadir Miel Pops");
            System.out.println("3.Añadir Personalizado");
            System.out.println("4.Volver");

            opcion= in.nextInt();

            switch (opcion){
                case 1-> addKellogs();
                case 2 -> addMPops();
                case 3 -> addOwnCereal();
                case 4 -> System.out.println("Saliendo...");
                default -> System.err.println("Opcion no reconocida");

            }
        }while (opcion!=4);
    }

    private static void addOwnCereal() {
        System.out.println("Añadiendo nuevo cereal");
        System.out.print("Introduzca el precio: ");
        double precio = in.nextDouble();
        in.nextLine();
        System.out.print("Introduzca el nombre de la marca: ");
        String marca = in.nextLine();
        System.out.print("Introduzca el tipo de cereal ESPELTA, MAIZ, TRIGO, OTROS: ");
        String Tipo = in.nextLine();
        in.nextLine();
        int cantidad = getCantidad();
        Cereales perso = new Cereales(precio, marca, Tipo);
        perso.setCaducidad(LocalDate.now());
        carrito.merge(perso,cantidad,Integer::sum);
    }

    private static void addMPops() {
        Cereales mPops = new Cereales(15.35,"Miel pops","TRIGO");
        mPops.setCaducidad(LocalDate.now());
        int cantidad = getCantidad();
        carrito.merge(mPops,cantidad,Integer::sum);
    }

    private static void addKellogs() {
        Cereales kelloggs = new Cereales(15.35,"Kellogg's","Maiz");
        kelloggs.setCaducidad(LocalDate.now());
        int cantidad = getCantidad();
        carrito.merge(kelloggs,cantidad,Integer::sum);
    }

    /*#####################################   Detergente   #######################################*/

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
                case 1-> addFairy();
                case 2 -> addVanish();
                case 3 -> addOwnDetergente();
                case 4 -> System.out.println("Saliendo...");
                default -> System.err.println("Opcion no reconocida");

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
        int cantidad = getCantidad();
        carrito.merge(new Detergente(precio,marca,volumen,envase,descuento),cantidad,Integer::sum);
    }



    private static void addVanish() {
        Detergente vanish = new Detergente(7.99,"Vanish", 2500, "Plastico", 0);
        int cantidad = getCantidad();
        carrito.merge(vanish,cantidad,Integer::sum);
    }

    private static void addFairy() {
        System.out.println("Ha seleccionado fairy");
        Detergente fairy = new Detergente(7.99,"Fairy", 2500, "Plastico", 25);
        int cantidad = getCantidad();
        carrito.merge(fairy,cantidad,Integer::sum);
    }
    /*#####################################   Carrito   #######################################*/

    private static int getCantidad() {
        System.out.print("Introduzca la cantidad: ");
        int cantidad = in.nextInt();
        in.nextLine();
        return cantidad;
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
        int opcion;

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
                case 1-> addDetergente();
                case 2-> addCereal();
                case 3 -> addVino();
                case 4 -> System.out.println("Saliendo...");
                default -> System.err.println("Opción incorrecta");
            }
        }while (opcion!= 4);

    }
    private static void elegirProducto() {
        System.out.println("<=========_ Menu carrito _========>");
        int id=0;
        TreeMap<Integer,Map.Entry<Producto,Integer>> listaOrdenada = new TreeMap<>();
        for (Map.Entry<Producto, Integer> productoCantidad : carrito.entrySet()) {
            listaOrdenada.put(id,productoCantidad);
            id++;
        }
        for (int i = 0; i < listaOrdenada.size(); i++) {
             System.out.println(i +"-" +listaOrdenada.get(i));

        }
        System.out.println("Selecciona un Producto");
        int selecccion = in.nextInt();
        if (selecccion<0 || selecccion > listaOrdenada.size()){
            System.err.println("Elemento no encontrado seleccionado el 0 por defecto");
            selecccion=0;
        }
        Producto producto = listaOrdenada.get(selecccion).getKey();
        menuModificar(producto);
    }

    private static void menuModificar(Producto producto) {
        System.out.println("<=======_Menú Añadir Producto_=======>");
        System.out.println("1.Modificar cantidad");
        System.out.println("2.Eliminar");
        System.out.println("3.Ver precio de la suma de este producto");
        System.out.println("4.Volver");
        System.out.print("Su elección: ");
        int opcion=in.nextInt();
        in.nextLine();
        switch (opcion){
            case 1 -> modificarCantidad(producto);
            case 2 -> carrito.remove(producto);
            case 3 -> precioProductoTotal(producto);
            case 4 -> System.out.println("Saliendo...");
            default -> System.err.println("Opción incorrecta");
        }
    }

    private static void precioProductoTotal(Producto producto) {
        double precioPorUnidad = producto.getPrecio();
        int cantidad = carrito.get(producto);
        double precioTotal= precioPorUnidad*cantidad;
        System.out.println(producto +"  total: " + precioTotal +"€");
    }

    private static void modificarCantidad(Producto producto) {
        int cantidad = getCantidad();
        carrito.replace(producto,cantidad);
    }
}