package Cartas.Monstruo;

/**
 * Clase que representa a un monstruo volador en el juego de cartas coleccionables.
 */
public class MonstruoVolador extends Monstruo {


    // atributo específico para monstruo volador.
      private final String durezaAlas;
    /**
     * Constructor de la clase MonstruoVolador.
     *
     * @param nombre       El nombre del monstruo volador.
     * @param puntosDeVida Los puntos de vida del monstruo volador.
     * @param genero       El género del monstruo volador (Macho, Hembra, Desconocido, etc.).
     * @param durezaAlas   La dureza de las alas del monstruo volador.
     */
    public MonstruoVolador(String nombre, int puntosDeVida, String genero, String durezaAlas) {
        super(nombre, puntosDeVida, genero);
        // Inicializar el atributo específico para el monstruo volador, por ejemplo:
        this.durezaAlas = durezaAlas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puntos de Vida: " + getPuntosDeVida());
        System.out.println("Género: " + getGenero());
        System.out.println("Dureza de alas: " + durezaAlas);
    }
}