package Cartas.Monstruo;

/**
 * Clase que representa a un monstruo de tipo Agua en el juego de cartas coleccionables.
 */
public class MonstruoAgua extends Monstruo {

    private String tipoChorro;

    /**
     * Constructor de la clase MonstruoAgua.
     *
     * @param tipoChorro   El tipo de chorro del monstruo de agua.
     * @param nombre       El nombre del monstruo.
     * @param puntosDeVida Los puntos de vida del monstruo.
     * @param genero       El género del monstruo (Macho, Hembra, Desconocido, etc.).
     */
    public MonstruoAgua(String tipoChorro, String nombre, int puntosDeVida, String genero) {
        super(nombre, puntosDeVida, genero);
        this.tipoChorro = tipoChorro;
    }

    /**
     * Constructor por defecto de la clase MonstruoAgua.
     *
     * @param tipoChorro El tipo de chorro del monstruo de agua.
     * @param puntosDeVida     Parámetro no utilizado en este constructor.
     * @param nombre     Parámetro no utilizado en este constructor.
     * @param genero     El género del monstruo (Macho, Hembra, Desconocido, etc.).
     */

    public MonstruoAgua(String tipoChorro, String nombre, int puntosDeVida, String genero, int parametroExtra) {
    }

    public MonstruoAgua(String tipoChorro, int i, String s, String genero) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puntos de Vida: " + getPuntosDeVida());
        System.out.println("Género: " + getGenero());
        System.out.println("Tipo de Chorro: " + tipoChorro);
    }
}
