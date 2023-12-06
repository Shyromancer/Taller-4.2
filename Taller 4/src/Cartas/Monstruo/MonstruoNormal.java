package Cartas.Monstruo;

/**
 * Clase que representa a un monstruo normal en el juego de cartas coleccionables.
 */
public class MonstruoNormal extends Monstruo {

    /**
     * Constructor de la clase MonstruoNormal.
     *
     * @param nombre       El nombre del monstruo normal.
     * @param puntosDeVida Los puntos de vida del monstruo normal.
     * @param genero       El género del monstruo normal (Macho, Hembra, Desconocido, etc.).
     */
    public MonstruoNormal(String nombre, int puntosDeVida, String genero) {
        super(nombre, puntosDeVida, genero);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puntos de Vida: " + getPuntosDeVida());
        System.out.println("Género: " + getGenero());

    }
}