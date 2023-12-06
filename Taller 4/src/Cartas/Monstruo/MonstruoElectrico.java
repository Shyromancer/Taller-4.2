package Cartas.Monstruo;

/**
 * Clase que representa a un monstruo de tipo Eléctrico en el juego de cartas coleccionables.
 */
public class MonstruoElectrico extends Monstruo {

    private int carga;
    private boolean completamenteCargado;

    /**
     * Constructor de la clase MonstruoElectrico.
     *
     * @param nombre       El nombre del monstruo.
     * @param puntosDeVida Los puntos de vida del monstruo.
     * @param genero       El género del monstruo (Macho, Hembra, Desconocido, etc.).
     */
    public MonstruoElectrico(String nombre, int puntosDeVida, String genero) {
        super(nombre, puntosDeVida, genero);
    }

    /**
     * Constructor de la clase MonstruoElectrico con parámetros adicionales.
     *
     * @param nombre              El nombre del monstruo.
     * @param puntosDeVida        Los puntos de vida del monstruo.
     * @param genero              El género del monstruo (Macho, Hembra, Desconocido, etc.).
     * @param carga               La carga asociada al monstruo eléctrico.
     * @param completamenteCargado Indica si el monstruo eléctrico está completamente cargado.
     */
    public MonstruoElectrico(String nombre, int puntosDeVida, String genero, int carga, boolean completamenteCargado) {
        super();
        this.carga = carga;
        this.completamenteCargado = completamenteCargado;
    }

    public MonstruoElectrico(String nombre, int puntosDeVida, String genero, int parametroExtra) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puntos de Vida: " + getPuntosDeVida());
        System.out.println("Género: " + getGenero());
        System.out.println("Carga: " + carga);
        System.out.println("Completamente Cargado: " + completamenteCargado);
    }
}