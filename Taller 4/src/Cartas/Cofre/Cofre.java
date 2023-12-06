package Cartas.Cofre;
import Bases.JuegoImpl;
import Cartas.Monstruo.Monstruo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.List;


/**
 * La clase Cofre representa un cofre en el juego que contiene cartas de monstruos.
 * @author Matias Munioz y Andoni Madrid
 * @version 05/12/2023
 */
public class  Cofre extends JuegoImpl{
    private String id;
    private String tipo;
    private long tiempoApertura;
    private List<Monstruo> cartasObtenidas;


    /**
     * Constructor de la clase Cofre.
     * Inicializa las propiedades del cofre, incluido su tipo, tiempo de apertura e ID.
     * Además, genera las cartas correspondientes al tipo de cofre.
     *
     * @param idCofre          El ID único del cofre.
     * @param tipo             El tipo de cofre (Normal, Plata, Diamante, etc.).
     * @param tiempoApertura   El tiempo en milisegundos necesario para abrir el cofre.
     */
    public Cofre(int idCofre, String tipo, int tiempoApertura) {
        this.tipo = tipo;
        this.tiempoApertura = tiempoApertura;
        //crear metodo en clase cofre
        setId(generarId());
        //setear cartas y crear metodo para generar cartas
        this.cartasObtenidas = generarCartas(tipo);
    }



    /**
     * Obtiene el ID único del cofre.
     *
     * @return El ID del cofre.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID único del cofre.
     *
     * @param id El ID del cofre.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo de cofre.
     *
     * @return El tipo de cofre.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de cofre.
     *
     * @param tipo El tipo de cofre.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el tiempo de apertura del cofre en milisegundos.
     *
     * @return El tiempo de apertura del cofre.
     */
    public long getTiempoApertura() {
        return tiempoApertura;
    }

    /**
     * Establece el tiempo de apertura del cofre en milisegundos.
     *
     * @param tiempoApertura El tiempo de apertura del cofre.
     */
    public void setTiempoApertura(long tiempoApertura) {
        this.tiempoApertura = tiempoApertura;
    }

    /**
     * Obtiene la lista de cartas obtenidas al abrir el cofre.
     *
     * @return La lista de cartas obtenidas.
     */
    public List<Monstruo> getCartasObtenidas() {
        return cartasObtenidas;
    }

    /**
     * Establece la lista de cartas obtenidas al abrir el cofre.
     *
     * @param cartasObtenidas La lista de cartas obtenidas.
     */
    public void setCartasObtenidas(List<Monstruo> cartasObtenidas) {
        this.cartasObtenidas = cartasObtenidas;
    }


    private String generarId(){
        int longitudId = 5; // Puedes ajustar la longitud según tus necesidades
        String setDeCaracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder idGenerada = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < longitudId; i++) {
            int index = random.nextInt(setDeCaracteres.length());
            char caracterAleatorio = setDeCaracteres.charAt(index);
            idGenerada.append(caracterAleatorio);
        }

        return idGenerada.toString();
    }
    private List<Monstruo> generarCartas(String tipo){
        List<Monstruo> cartasGeneradas = new ArrayList<>();

        // Lógica de generación de cartas según el tipo del cofre
        switch (tipo) {
            case "Plata":
                cartasGeneradas.add(generarMonstruoConProbabilidad("Normal", 23));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Fuego", 18));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Agua", 18));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Electrico", 18));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Volador", 18));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Legendario", 5));
                break;
            case "Diamante":
                cartasGeneradas.add(generarMonstruoConProbabilidad("Normal", 12));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Agua", 19));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Fuego", 19));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Electrico", 19));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Volador", 19));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Legendario", 12));
                break;
            default:
                cartasGeneradas.add(generarMonstruoConProbabilidad("Normal", 39));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Agua", 15));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Fuego", 15));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Electrico", 15));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Volador", 15));
                cartasGeneradas.add(generarMonstruoConProbabilidad("Legendario", 1));
                break;
        }

        return cartasGeneradas;
    }
    private Monstruo generarMonstruoConProbabilidad(String tipo, int probabilidad) {
        Random random = new Random();
        int randomInt = random.nextInt(100) + 1; // Genera un número aleatorio entre 1 y 100

        if (randomInt <= probabilidad) {
            // Llamada al método de generación del tipo de monstruo
            return generarMonstruoSegunTipo(tipo);
        } else {
            // Lógica para el caso de no generar el monstruo según la probabilidad
            return null;
        }
    }

    private Monstruo generarMonstruoSegunTipo(String tipo) {
        //por desarrollar
        return null;
    }

    /**
     * Obtiene un Monstruo de la lista de cartas obtenidas por su ID.
     *
     * @param idMonstruo ID del Monstruo a obtener.
     * @return Monstruo correspondiente al ID o null si no se encuentra.
     */
    public Monstruo obtenerMonstruoPorId(String idMonstruo) {
        for (Monstruo monstruo : cartasObtenidas) {
            if (monstruo.getId()) {
                return monstruo;
            }
            continue;
        }
        return null;  // Monstruo no encontrado
    }


}


