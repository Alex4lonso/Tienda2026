/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.educastur.jek86100.tienda2026;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 1dawd04
 */
//<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
public class Tienda2026 implements Serializable {

    /* =====================================================
     *                    ATRIBUTOS
     * ===================================================== */
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap<String, Articulo> articulos;
    private HashMap<String, Cliente> clientes;

    public Tienda2026() {
        pedidos = new ArrayList();
        articulos = new HashMap();
        clientes = new HashMap();
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="MAIN">

    public static void main(String[] args) {
        Tienda2026 t2026 = new Tienda2026();
        t2026.cargaDatos();
        //t2026.menu();
        t2026.listadoStreams();
    

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="MENU PRINCIPAL">
    public void menu() {
        int Opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU PRINCIPAL\n");
            System.out.println("\t\t\t\t1 -ARTICULOS");
            System.out.println("\t\t\t\t2 -CLIENTES");
            System.out.println("\t\t\t\t3 -PEDIDOS");
            System.out.println("\t\t\t\t9 -CERRAR EL PROGRAMA");

            Opcion = sc.nextInt();

            switch (Opcion) {
                case 1:
                    menuArticulos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    ;
                    menuPedidos();
                    break;

            }
        } while (Opcion != 9);
        System.out.println("Saliendo del programa...");
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="MENU ARTICULOS">
    public void menuArticulos() {
        int Opcion = 0;
        do {
            System.out.println("\n\n\n\t\t\t\tMENU ARTICULOS\n");
            System.out.println("\t\t\t\t1 -ALTA ARTICULOS");
            System.out.println("\t\t\t\t2 -BAJA ARTICULOS");
            System.out.println("\t\t\t\t3 -REPOSICION ARTICULOS");
            System.out.println("\t\t\t\t4 -LISTAR ARTICULOS");
            System.out.println("\t\t\t\t9 -MENU PRINCIPAL");

            Opcion = sc.nextInt();

            switch (Opcion) {
                case 1:
                    altaArticulos();
                    break;
                case 2:
                    bajaArticulos();
                    break;
                case 3:
                    ;
                    reposicionArticulos();
                    break;
                case 4:
                    listarArticulos();

            }
        } while (Opcion != 9);
        System.out.println("Saliendo al menu principal...");
    }

    private void altaArticulos() {
        String idArticulo, descripcion, existencias, pvp;
        sc.nextLine();
        System.out.println("Alta de un nuevo articulo.");
        do {
            System.out.println("\nIdArticulo (IDENTIFICADOR)");
            idArticulo = sc.nextLine();
        } while (!idArticulo.matches("[1-6][-][0-0][0-9]") || articulos.containsKey(idArticulo));
        System.out.println("DESCRIPCION:");
        descripcion = sc.nextLine();

        do {
            System.out.println("EXISTENCIAS");
            existencias = sc.nextLine();
        } while (!MetodosAux.esInt(existencias));
        do {
            System.out.println("PVP:");
            pvp = sc.nextLine();
        } while (!MetodosAux.esDouble(pvp));
        Articulo a = new Articulo(idArticulo, descripcion, Integer.parseInt(existencias), Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
        System.out.println("Articulo añadido!");
    }

    private void bajaArticulos() {
    }

    private void reposicionArticulos() {
    }

    private void listarArticulos() {
        System.out.println("");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
        }
        articulos.values().stream().forEach(a -> System.out.println(a));

        ArrayList<Articulo> articulosAux = new ArrayList(articulos.values());
        System.out.println("");
        System.out.println("Articulos por mas de 50$:");
        articulosAux.stream().filter(a -> a.getPvp() > 50)
                .sorted(Comparator.comparing(Articulo::getPvp))
                .forEach(a -> System.out.println(a));

        System.out.println("");
        System.out.println("Articulos por menos de 50$");
        articulosAux.stream()
                .filter(a -> a.getPvp() < 50)
                .sorted(Comparator.comparing(Articulo::getPvp))
                .forEach(a -> System.out.println(a));

        System.out.println("");
        System.out.println("Articulos por mayor cantidad:");
        articulosAux.stream()
                .sorted(Comparator.comparing(Articulo::getExistencias))
                .forEach(a -> System.out.println(a));

        System.out.println("");
        System.out.println("Articulos por menor cantidad");
        articulosAux.stream()
                .sorted(Comparator.comparing(Articulo::getExistencias).reversed())
                .forEach(a -> System.out.println(a));

        System.out.println("");
        String idArticulo;
        System.out.println("Articulos por ID");
        System.out.print("\nTecle el primer digito del ID del artículo:");
        idArticulo = sc.next();
        articulosAux.stream()
                .filter(a -> String.valueOf(a.getIdArticulo()).startsWith(idArticulo))
                .sorted(Comparator.comparing(Articulo::getIdArticulo))
                .forEach(System.out::println);

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="MENU CLIENTES">
    public void menuClientes() {
        int Opcion = 0;
        do {
            System.out.println("\n\n\n\t\t\t\tMENU CLIENTES\n");
            System.out.println("\t\t\t\t1 -ALTA CLIENTES");
            System.out.println("\t\t\t\t2 -BAJA CLIENTES");
            System.out.println("\t\t\t\t3 -MODIFICACION CLIENTES");
            System.out.println("\t\t\t\t4 -LISTAR CLIENTES");
            System.out.println("\t\t\t\t9 -CERRAR EL PROGRAMA");

            Opcion = sc.nextInt();

            switch (Opcion) {
                case 1:
                    altaClientes();
                    break;
                case 2:
                    bajaClientes();
                    break;
                case 3:
                    ;
                    modificarClientes();
                    break;
                case 4:
                    ;
                    listarClientes();
                    break;

            }
        } while (Opcion != 9);
        System.out.println("Saliendo al menu principal...");
    }

    private void altaClientes() {
    }

    private void bajaClientes() {
    }

    private void modificarClientes() {
    }

    private void listarClientes() {
        System.out.println("");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="MENU PEDIDOS">
    public void menuPedidos() {
        int Opcion = 0;
        do {
            System.out.println("\n\n\n\t\t\t\tMENU PEDIDOS\n");
            System.out.println("\t\t\t\t1 -NUEVO PEDIDO");
            System.out.println("\t\t\t\t2 -LISTADO PEDIDOS");
            System.out.println("\t\t\t\t3 -BUSCAR PEDIDO");
            System.out.println("\t\t\t\t9 -MENU PRINCIPAL");

            Opcion = sc.nextInt();

            switch (Opcion) {
                case 1:
                    nuevoPedido();
                    break;
                case 2:
                    //listadoPedidos();
                    break;
                case 3:
                    break;
            }
        } while (Opcion != 9);
        System.out.println("Saliendo al menu principal...");
    }

    public String generaIdPedido(String idCliente) {
        String nuevoId;
        int contador = 0;
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        contador++;
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }

    private void stock(String idArticulo, int unidades) throws StockCero, StockInsuficiente {
        if (articulos.get(idArticulo).getExistencias() == 0) {
            throw new StockCero("0 unidades de: " + articulos.get(idArticulo).getDescripcion());
        }
        if (articulos.get(idArticulo).getExistencias() < unidades) {
            throw new StockInsuficiente("Solo hay " + articulos.get(idArticulo).getExistencias()
                    + " unidades disponibles de: " + articulos.get(idArticulo).getDescripcion());
        }
    }

    private double totalPedido(Pedido p) {
        double totalP = 0;
        for (LineaPedido lp : p.getCestacompra()) {
            totalP += lp.getUnidades() * lp.getIdArticulo().getPvp();
        }
        return totalP;
    }

    private void nuevoPedido() {
        sc.nextLine();
        String idCliente;
        do {
            System.out.println("DNI (id) CLIENTE:");
            idCliente = sc.nextLine().toUpperCase();
            if (!clientes.containsKey(idCliente)) {
                System.out.println("No es cliente de la tienda."
                        + " Desea darse de alta o compra como invitado");
            }
        } while (!MetodosAux.validarDNI(idCliente));

        ArrayList<LineaPedido> cestaCompra = new ArrayList();
        String idArticulo;
        int unidades = 0;
        System.out.print("\nTecle el ID del artículo deseado (FIN para terminar la compra)");
        idArticulo = sc.next();
        while (!idArticulo.equalsIgnoreCase("FIN")) {
            System.out.print("\nTeclea las unidades deseadas: ");
            unidades = sc.nextInt();

            try {
                stock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(articulos.get(idArticulo), unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.println("Las quieres (SI/NO)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI")) {
                    cestaCompra.add(new LineaPedido(articulos.get(idArticulo), articulos.get(idArticulo).getExistencias()));
                }
            }
            System.out.print("\nTecle el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo = sc.next();
        }

        if (!cestaCompra.isEmpty()) {
            double totalPedido = 0;
            double totalLinea = 0;
            System.out.println("Este es tu pedido");
            for (LineaPedido l : cestaCompra) {

                double precioLinea = l.getIdArticulo().getPvp();
                totalPedido += precioLinea;
                System.out.println(l.getIdArticulo() + " | "
                        + l.getIdArticulo().getDescripcion() + " | " + l.getUnidades()
                        + " unidades (" + l.getIdArticulo().getPvp() + "$) = " + precioLinea + "$");

            }
            System.out.println("\t\t\tTOTAL DEL PEDIDO: " + totalPedido + "$");
            System.out.println("Procedemos con la compra (SI/NO) ");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("SI")) {
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                        LocalDate.now(), cestaCompra));
                for (LineaPedido l : cestaCompra) {
                    l.getIdArticulo().setExistencias(l.getIdArticulo().getExistencias() - l.getUnidades());
                }
            }
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="CARGADATOS">
    public void cargaDatos() {
        clientes.put("80580845T", new Cliente("80580845T", "ANA ", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 0, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 5, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 15, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-11", new Articulo("3-11", "HP LASERJET HP800 ", 2, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<LineaPedido>(List.of(new LineaPedido(articulos.get("1-11"), 3), new LineaPedido(articulos.get("4-22"), 3)))));
        pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<LineaPedido>(List.of(new LineaPedido(articulos.get("4-11"), 3), new LineaPedido(articulos.get("4-22"), 2), new LineaPedido(articulos.get("4-33"), 4)))));
        pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<LineaPedido>(List.of(new LineaPedido(articulos.get("4-22"), 1), new LineaPedido(articulos.get("2-22"), 3)))));
        pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<LineaPedido>(List.of(new LineaPedido(articulos.get("4-33"), 3), new LineaPedido(articulos.get("2-11"), 3)))));
        pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<LineaPedido>(List.of(new LineaPedido(articulos.get("2-11"), 5), new LineaPedido(articulos.get("2-33"), 3), new LineaPedido(articulos.get("4-33"), 2)))));
    }
//</editor-fold>

    private void listadoStreams() {
        //GRUESO
        //CONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE
        long numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIdCliente().equalsIgnoreCase("80580845T"))
                .count();
        System.out.println("\n" + numPedidos + "\n");

        //CONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - PARA LAS AGRUPACIONES SON IDEALOS LOS MAP
        Map<Cliente, Long> numPedidosPorCliente
                = pedidos.stream().collect(Collectors.groupingBy(Pedido::getClientePedido, Collectors.counting()));
        System.out.println("\n" + numPedidosPorCliente + "\n");
        //ESTO ES PARA MOSTRAR EL RESULTADO
        for (Cliente c : numPedidosPorCliente.keySet()) {
            System.out.println(c + " - " + numPedidosPorCliente.get(c));
        }
        //LAS FUNCIONES TIPO count() counting()

        //PROBAMOS CON EL ARTICULO ARTICULOS.GET("4-22") - HACERLO DESPUES PARA TODOS
        System.err.println("\n");
        for (Cliente c : clientes.values()) {
            int unidades = pedidos.stream().filter(p -> p.getClientePedido().equals(c))
                    .flatMap(p -> p.getCestacompra().stream()).filter(l -> l.getIdArticulo().equals(articulos.get("4-22")))
                    .mapToInt(LineaPedido::getUnidades).sum();

            System.out.println(c.getNombre() + " - " + unidades + " de " + articulos.get("4-22").getDescripcion());

        }

    }

    //TOTAL DE UNIDADES VENDIDAS DE UN ARTICULO EN TODOS LOS PEDIDOS
    //ESTAS TRES COSAS SON LAS MISMAS COSAS, SOLO QUE HAY ALGUNAS MEJOR RESUMIDAS Y MEJORES POR ESTAR EN 1 LINEA
    private int uniVendArticulo2(Articulo a) {
        int total = 0;
        for (Pedido p : pedidos) {
            for (LineaPedido lp : p.getCestacompra()) {
                if (lp.getIdArticulo().getIdArticulo().equals(a.getIdArticulo())) {
                    total += lp.getUnidades();
                }
            }
        }
        return total;
    }

    /*Unidades vendidas1 es programacion tradicional,
    con bucles for anidados, y es mas dificil de leer, ademas de ser mas propensa a errores,
    ya que tenemos que estar pendientes de los indices de los bucles,
    y de las condiciones de los bucles, etc.*/
    private int unidadesVendidas1(Articulo a) {
        int c = 0;
        for (Pedido p : pedidos) {
            for (LineaPedido l : p.getCestacompra()) {
                if (l.getIdArticulo().equals(a)) {
                    c += l.getUnidades();
                }
            }
        }
        return c;
    }

    //ESTO ES LO MISMO PERO CON STREAMS, EN UNA SOLA LINEA, Y MUCHO MAS LEGIBLE
    /*Version programacion funcional con flatmap, filter para aplanar los streams y mapToInt, es mucho mas legible,
    y ademas es mas facil de escribir, ya que no tenemos que preocuparnos por los indices de los bucles,
    ni por las condiciones de los bucles, etc.*/

/*Flatmap te permite dar el salto cuando una coleccion tiene dentro otra coleccion, 
    como es el caso de los pedidos que tienen dentro una lista de LineaPedido. 
    Con el flatmap lo que hacemos es coger cada pedido y convertirlo en un stream de LineaPedido, 
    con lo cual al final tenemos un stream de LineaPedido y ya podemos hacer las operaciones que queramos sobre ese stream.
    Son basicamente como hacer bucles anidados de toda la vida.*/
    private int unidadesVendidas2(Articulo a) {
        int total = 0;
        for (Pedido p : pedidos) {
            total += p.getCestacompra().stream().filter(l -> l.getIdArticulo().equals(a)).mapToInt(LineaPedido::getUnidades).sum();
        }
        return total;
    }

    private int unidadesVendidas3(Articulo a) {
        return pedidos.stream().flatMap(p -> p.getCestacompra().stream()).filter(l -> l.getIdArticulo().equals(a)).mapToInt(LineaPedido::getUnidades).sum();
    }

    private int unidadesVendidas4(Articulo a) {
        return pedidos.stream().flatMap(p -> p.getCestacompra().stream()).filter(l -> l.getIdArticulo().equals(a)).collect(Collectors.summingInt(LineaPedido::getUnidades));
    }

}
