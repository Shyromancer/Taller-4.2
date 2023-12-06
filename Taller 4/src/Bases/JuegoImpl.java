package Bases;

import Cartas.Cofre.Cofre;
import Cartas.Monstruo.*;

import java.io.*;
import java.util.*;

/**
 * Implementación de un juego de cartas coleccionables.
 * @author Matias Munioz y Andoni Madrid
 * @version 05/12/2023
 */
public class JuegoImpl {
    private final List<Monstruo> cartasDelJugador;
    private final List<Cofre> cofresDelJugador;
    private String nombreJugador;
    private int cofresAbiertos;
    private int CofresDisponibles;
    private Scanner scanner;

    /**
     * Constructor de la clase JuegoImpl.
     */
    public JuegoImpl() {
        this.cartasDelJugador = new ArrayList<>();
        this.cofresDelJugador = new ArrayList<>();
        this.nombreJugador = "";


    }


    /**
     * Carga los datos del juego desde archivos.
     */
    public void cargarDatos() {
        try {
            File archivoMonstruos = new File("monsters.txt");
            Scanner lector = new Scanner(archivoMonstruos);

            while (lector.hasNextLine()) {
                String[] datosMonstruo = lector.nextLine().split("/");

                String tipoMonstruo = datosMonstruo[2];
                Monstruo monstruo = null;

                switch (tipoMonstruo) {
                    case "Normal":
                        monstruo = new MonstruoNormal(datosMonstruo[1], Integer.parseInt(datosMonstruo[3]), datosMonstruo[4]);
                        break;
                    case "Agua":
                        monstruo = new MonstruoAgua(datosMonstruo[1], Integer.parseInt(datosMonstruo[3]), datosMonstruo[4], datosMonstruo[5]);
                        break;
                    case "Fuego":
                        monstruo = new MonstruoFuego(datosMonstruo[1], Integer.parseInt(datosMonstruo[3]), datosMonstruo[4], Integer.parseInt(datosMonstruo[5]));
                        break;
                    case "Eléctrico":
                        monstruo = new MonstruoElectrico(datosMonstruo[1], Integer.parseInt(datosMonstruo[3]), datosMonstruo[4], Integer.parseInt(datosMonstruo[5]), Boolean.parseBoolean(datosMonstruo[6]));
                        break;
                    case "Volador":
                        monstruo = new MonstruoVolador(datosMonstruo[1], Integer.parseInt(datosMonstruo[3]), datosMonstruo[4], datosMonstruo[5]);
                        break;
                    case "Legendario":
                        monstruo = new MonstruoLegendario(datosMonstruo[1], Integer.parseInt(datosMonstruo[3]), datosMonstruo[4], datosMonstruo[5]);
                        break;
                    default:
                        System.out.println("Tipo de monstruo no reconocido: " + tipoMonstruo);
                        break;
                }

                // Agregar el monstruo a la lista cartasDelJugador si no es null
                if (monstruo != null) {
                    cartasDelJugador.add(monstruo);
                }
            }
            lector.close();

            File archivoDatosJugador = new File("data_player.txt");
            lector = new Scanner(archivoDatosJugador);

            // Procesar los datos y actualizar nombreJugador, cofresAbiertos, cofresDisponibles, etc.
            if (lector.hasNextLine()) {
                String[] datosJugador = lector.nextLine().split("/");
                nombreJugador = datosJugador[0];

                String[] cartasObtenidas = datosJugador[1].split("/");
                for (String cartaId : cartasObtenidas) {
                    Monstruo carta = encontrarCartaPorId(cartaId); // Método para obtener carta por ID
                    if (carta != null) {
                        cartasDelJugador.add(carta);
                    }
                }

                cofresAbiertos = Integer.parseInt(datosJugador[2]);
                int cofresDisponibles = Integer.parseInt(datosJugador[3]);

                // Leer datos de los cofres y actualizar la lista cofresDelJugador
                while (lector.hasNextLine()) {
                    String[] datosCofre = lector.nextLine().split("/");
                    int idCofre = Integer.parseInt(datosCofre[0]);
                    String tipoCofre = datosCofre[1];
                    int tiempoApertura = Integer.parseInt(datosCofre[2]);

                    // Crear instancias de Cofre según los datos leídos
                    Cofre nuevoCofre = new Cofre(idCofre, tipoCofre, tiempoApertura);

                    // Agregar el nuevoCofre a la lista cofresDelJugador
                    cofresDelJugador.add(nuevoCofre);
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar los archivos: " + e.getMessage());
        }
    }

    private Monstruo encontrarCartaPorId(String cartaId) {
        //incompleta
        return null;
    }

    /**
     * Muestra el menú principal del juego.
     */
    public void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("---- Menú Principal ----");
            System.out.println("1. Ver mis cartas");
            System.out.println("2. Todas las cartas");
            System.out.println("3. Cofres");
            System.out.println("4. Salir");

            System.out.print("Ingrese su opción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();


            switch (opcion) {
                case 1 -> mostrarCartasDelJugador();
                case 2 -> mostrarTodasLasCartas();
                case 3 -> gestionarCofres();
                case 4 -> salir = true;
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        guardarDatos(); // Guardar datos antes de salir del juego
    }

    /**
     * Guarda los datos del juego en un archivo.
     */
    public void guardarDatos() {
        // Guardar los datos actualizados en el archivo data_player.txt, por ejemplo

        String nombreArchivo = "data_player.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Guardar los datos de los jugadores y sus cartas obtenidas
            writer.write(nombreJugador + " / ");

            // Guardar las cartas obtenidas separadas por comas
            for (Monstruo carta : cartasDelJugador) {
                writer.write(carta.getId() + ",");
            }
            String cantidadCofresAbiertos = null;
            String cantidadCofresDisponibles = null;
            writer.write(" / " + cantidadCofresAbiertos + " / " + cantidadCofresDisponibles);

            // Si hay más información como datos de cofres, puedes agregarla aquí
            // Ejemplo: guardar los datos de los cofres del jugador

            for (Cofre cofre : cofresDelJugador) {
                writer.write("\n" + cofre.getId() + " ; " + cofre.getTipo() + " ; " + cofre.getTiempoApertura());
            }

            System.out.println("Datos guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }


    public void gestionarCofres() {
        boolean salir = false;

        while (!salir) {
            System.out.println("---- Gestión de Cofres ----");
            System.out.println("1. Ver cofres disponibles");
            System.out.println("2. Abrir cofre");
            System.out.println("3. Obtener nuevo cofre");
            System.out.println("4. Volver al menú principal");

            System.out.print("Ingrese su opción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> mostrarCofresDelJugador();
                case 2 -> abrirCofre();
                case 3 -> obtenerNuevoCofre();
                case 4 -> salir = true;
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void obtenerNuevoCofre() {
        if (cofresDelJugador.size() >= 4) {
            System.out.println("Ya tienes el máximo de cofres. Debes abrir uno antes de obtener uno nuevo.");
            return;
        }

        // Lógica para generar un nuevo cofre aleatorio y agregarlo a la lista cofresDelJugador
        // Ejemplo: crear un nuevo objeto de tipo Cofre y agregarlo a la lista
        Cofre nuevoCofre = generarCofreAleatorio(); // Método para generar cofres aleatorios
        cofresDelJugador.add(nuevoCofre);


        Cofre cofre = generarCofreAleatorio();
        System.out.println("¡Has obtenido un nuevo cofre de tipo:" + cofre.getTipo());
    }

    private Cofre generarCofreAleatorio() {
        Random random = new Random();
        int tipoDeCofre = random.nextInt(100) + 1; // Genera un número aleatorio entre 1 y 100

        if (tipoDeCofre <= 39) { // Probabilidad de obtener un cofre normal: 39%
            return generarCofreNormal();
        } else if (tipoDeCofre <= 54) { // Probabilidad de obtener un cofre de plata: 15% (39% + 15%)
            return generarCofrePlata();
        } else if (tipoDeCofre <= 55) { // Probabilidad de obtener un cofre de diamante: 1% (39% + 15% + 1%)
            return generarCofreDiamante();
        } else {
            // En caso de que no se cumpla ninguna de las probabilidades, se puede retornar un cofre normal por defecto
            return generarCofreNormal();
        }
    }

    private Cofre generarCofreNormal() {
        // Supongamos que un cofre normal tiene un tipo 'Normal', tiempo de apertura de 5 minutos (300,000 milisegundos)
        String tipo = "Normal";
        int tiempoApertura = 300000; // 5 minutos en milisegundos 300000

        // Suponiendo que la clase Cofre tiene un constructor que recibe el tipo y tiempo de apertura como parámetros
        int idCofre = 0;
        return new Cofre(idCofre, tipo, tiempoApertura);
    }


    private Cofre generarCofrePlata() {
        // Supongamos que un cofre de plata tiene un tipo 'Plata', tiempo de apertura de 15 minutos (900,000 milisegundos)
        String tipo = "Plata";
        int tiempoApertura = 900000; // 15 minutos en milisegundos

        //poner estadisticas


        // Suponiendo que la clase Cofre tiene un constructor que recibe el tipo y tiempo de apertura como parámetros
        int idCofre = 0;
        return new Cofre(idCofre, tipo, tiempoApertura);
    }


    private Cofre generarCofreDiamante() {
        // Supongamos que un cofre de diamante tiene un tipo 'Diamante', tiempo de apertura de 30 minutos (1,800,000 milisegundos)
        String tipo = "Diamante";
        int tiempoApertura = 1800000; // 30 minutos en milisegundos

        // Suponiendo que la clase Cofre tiene un constructor que recibe el tipo y tiempo de apertura como parámetros
        int idCofre = 0;
        return new Cofre(idCofre, tipo, tiempoApertura);
    }


    private void mostrarCofresDelJugador() {
        if (cofresDelJugador.isEmpty()) {
            System.out.println("No tienes cofres disponibles.");
            return;
        }

        System.out.println("---- Cofres del Jugador ----");
        for (Cofre cofre : cofresDelJugador) {
            System.out.println("ID: " + cofre.getId() + "  Tipo: " + cofre.getTipo() + "  Tiempo de apertura: " + cofre.getTiempoApertura());
        }
    }


    public void mostrarTodasLasCartas() {
        System.out.println("---- Todas las Cartas ----");
        for (Monstruo carta : cartasDelJugador) {
            carta.mostrarInformacion();
        }
    }


    public void mostrarCartasDelJugador() {
        final int CARTAS_POR_PAGINA = 4;
        int totalCartas = cartasDelJugador.size();
        int paginas = (int) Math.ceil((double) totalCartas / CARTAS_POR_PAGINA);

        int paginaActual = 1;
        int inicio, fin;
        boolean salir = false;

        while (!salir) {
            inicio = (paginaActual - 1) * CARTAS_POR_PAGINA;
            fin = Math.min(inicio + CARTAS_POR_PAGINA, totalCartas);

            System.out.println("---- Cartas del Jugador (Página " + paginaActual + " de " + paginas + ") ----");
            for (int i = inicio; i < fin; i++) {
                cartasDelJugador.get(i).mostrarInformacion();
            }

            System.out.println("----");
            System.out.println("Página " + paginaActual + " de " + paginas);
            System.out.println("1. Siguiente página");
            System.out.println("2. Página anterior");
            System.out.println("3. Volver al menú principal");

            System.out.print("Ingrese su opción: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();


            switch (opcion) {
                case 1 -> {
                    if (paginaActual < paginas) {
                        paginaActual++;
                    } else {
                        System.out.println("Ya estás en la última página.");
                    }
                }
                case 2 -> {
                    if (paginaActual > 1) {
                        paginaActual--;
                    } else {
                        System.out.println("Ya estás en la primera página.");
                    }
                }
                case 3 -> salir = true;
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }


    public void abrirCofre() {
        if (cofresDelJugador.isEmpty()) {
            System.out.println("No tienes cofres para abrir.");
            return;
        }

        mostrarCofresDelJugador(); // Mostrar los cofres disponibles

        System.out.print("Ingrese el ID del cofre que desea abrir: ");
        Scanner scanner = new Scanner(System.in);
        int idCofreSeleccionado = scanner.nextInt();

        boolean cofreEncontrado = false;
        for (Cofre cofre : cofresDelJugador) {
            if (Objects.equals(cofre.getId(), String.valueOf(idCofreSeleccionado))) {
                cofreEncontrado = true;
                if (cofre.getTiempoApertura() > 0) {
                    System.out.println("El cofre aún no está desbloqueado. Tiempo restante: " + cofre.getTiempoApertura() + " segundos.");
                    return;
                }

                // Obtener cartas del cofre
                List<Monstruo> cartasObtenidas = obtenerCartasDelCofre(cofre);
                System.out.println("¡Has abierto el cofre y has obtenido las siguientes cartas!");

                // Mostrar las cartas obtenidas
                for (Monstruo carta : cartasObtenidas) {
                    carta.mostrarInformacion();
                }

                // Agregar las cartas obtenidas a la lista de cartas del jugador
                cartasDelJugador.addAll(cartasObtenidas);

                // Eliminar el cofre abierto de la lista de cofres del jugador
                cofresDelJugador.remove(cofre);

                break;
            }
        }

        if (!cofreEncontrado) {
            System.out.println("No se encontró un cofre con el ID proporcionado.");
        }
    }


    private List<Monstruo> obtenerCartasDelCofre(Cofre cofre) {
        List<Monstruo> cartasObtenidas = new ArrayList<>();

        // Obtener las cartas del cofre según su tipo
        List<String[]> datosCartas = cofre.obtenerDatosCartas(); // Método hipotético para obtener datos de las cartas del cofre

        for (String[] datosMonstruo : datosCartas) {
            String tipoMonstruo = datosMonstruo[2]; // Suponiendo que el tipo de monstruo está en el índice 2 del array de datos

            // Generar el monstruo según su tipo
            Monstruo nuevaCarta = generarMonstruoSegunTipo(tipoMonstruo, datosMonstruo);

            if (nuevaCarta != null) {
                cartasObtenidas.add(nuevaCarta);
            }
        }

        return cartasObtenidas;
    }

    protected List<String[]> obtenerDatosCartas() {
        //hacer
        return null;
    }


    private MonstruoNormal generarMonstruoNormal(String[] datosMonstruo) {
        String nombre = datosMonstruo[1];
        int puntosDeVida = Integer.parseInt(datosMonstruo[4]);
        String genero = datosMonstruo[5];
        int id = Integer.parseInt(datosMonstruo[0]);

        MonstruoNormal monstruoNormal = new MonstruoNormal(nombre, puntosDeVida, genero);
        monstruoNormal.setId(id);

        return monstruoNormal;
    }

    protected Monstruo generarMonstruoSegunTipo(String tipoMonstruo, String[] datosMonstruo) {
        // Lógica para generar el monstruo según el tipo
        switch (tipoMonstruo) {
            case "Normal":
                return generarMonstruoNormal(datosMonstruo);
            case "Agua":
                return generarMonstruoAgua(datosMonstruo);
            case "Fuego":
                return generarMonstruoFuego(datosMonstruo);
            case "Electrico":
                return generarMonstruoElectrico(datosMonstruo);
            case "Volador":
                return generarMonstruoVolador(datosMonstruo);
            case "Legendario":
                return generarMonstruoLegendario(datosMonstruo);
            default:
                return null;
        }
    }

    private Monstruo generarMonstruoAgua(String[] datosMonstruo) {
        datosMonstruo = new String[0];
        String tipoChorro = datosMonstruo[2];
        String nombre = datosMonstruo[1];
        int puntosDeVida = Integer.parseInt(datosMonstruo[3]);
        String genero = datosMonstruo[4];
        int parametroExtra = Integer.parseInt(datosMonstruo[5]);
        int id = Integer.parseInt(datosMonstruo[0]);

        MonstruoAgua monstruoAgua = new MonstruoAgua(tipoChorro, nombre, puntosDeVida, genero, parametroExtra);
        monstruoAgua.setId(id);

        return monstruoAgua;
    }


    private MonstruoFuego generarMonstruoFuego(String[] datosMonstruo) {
        String nombre = datosMonstruo[1];
        int puntosDeVida = Integer.parseInt(datosMonstruo[4]);
        String genero = datosMonstruo[5];
        int parametroExtra = Integer.parseInt(datosMonstruo[3]);
        int id = Integer.parseInt(datosMonstruo[0]);

        MonstruoFuego monstruoFuego = new MonstruoFuego(nombre, puntosDeVida, genero, parametroExtra);
        monstruoFuego.setId(id);

        return monstruoFuego;
    }

    private MonstruoElectrico generarMonstruoElectrico(String[] datosMonstruo) {
        String nombre = datosMonstruo[1];
        int puntosDeVida = Integer.parseInt(datosMonstruo[4]);
        String genero = datosMonstruo[5];
        int parametroExtra = Integer.parseInt(datosMonstruo[3]);
        int id = Integer.parseInt(datosMonstruo[0]);

        MonstruoElectrico monstruoElectrico = new MonstruoElectrico(nombre, puntosDeVida, genero, parametroExtra);
        monstruoElectrico.setId(id);

        return monstruoElectrico;
    }

    private MonstruoVolador generarMonstruoVolador(String[] datosMonstruo) {
        String nombre = datosMonstruo[1];
        int puntosDeVida = Integer.parseInt(datosMonstruo[4]);
        String genero = datosMonstruo[5];
        String tipoAlas = datosMonstruo[3];
        int id = Integer.parseInt(datosMonstruo[0]);

        MonstruoVolador monstruoVolador = new MonstruoVolador(nombre, puntosDeVida, genero, tipoAlas);
        monstruoVolador.setId(id);

        return monstruoVolador;
    }

    private MonstruoLegendario generarMonstruoLegendario(String[] datosMonstruo) {
        String nombre = datosMonstruo[1];
        int puntosDeVida = Integer.parseInt(datosMonstruo[4]);
        String genero = datosMonstruo[5];
        int habilidadEspecial = Integer.parseInt(datosMonstruo[3]);
        int id = Integer.parseInt(datosMonstruo[0]);

        MonstruoLegendario monstruoLegendario;
        monstruoLegendario = new MonstruoLegendario(nombre, puntosDeVida, genero, habilidadEspecial);
        monstruoLegendario.setId(id);

        return monstruoLegendario;
    }



}
