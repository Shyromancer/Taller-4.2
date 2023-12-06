package Cartas.Monstruo;

/**
 * Clase que representa a un monstruo de tipo Fuego en el juego de cartas coleccionables.
 */
public class MonstruoFuego extends Monstruo {

    private int longitudLlamarada;

    /**
     * Constructor de la clase MonstruoFuego.
     *
     * @param nombre          El nombre del monstruo.
     * @param puntosDeVida    Los puntos de vida del monstruo.
     * @param genero          El género del monstruo (Macho, Hembra, Desconocido, etc.).
     * @param longitudLlamarada La longitud de la llamarada del monstruo de fuego.
     */
    public MonstruoFuego(String nombre, int puntosDeVida, String genero, int longitudLlamarada) {
        super(nombre, puntosDeVida, genero);
        this.longitudLlamarada = longitudLlamarada;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puntos de Vida: " + getPuntosDeVida());
        System.out.println("Género: " + getGenero());
        System.out.println("Longitud de la Llamarada: " + longitudLlamarada + " metros");
    }
}