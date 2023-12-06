package Cartas.Monstruo;

/**
 * Clase que representa a un monstruo legendario en el juego de cartas coleccionables.
 */
public class MonstruoLegendario extends Monstruo {

    private static MonstruoLegendario instanciaUnica = null;

    /**
     * Constructor de la clase MonstruoLegendario.
     *
     * @param nombre          El nombre del monstruo legendario.
     * @param puntosDeVida    Los puntos de vida del monstruo legendario.
     * @param genero          El género del monstruo legendario (Macho, Hembra, Desconocido, etc.).
     * @param habilidadEspecial      El superpoder asociado al monstruo legendario.
     */
    public MonstruoLegendario(String nombre, int puntosDeVida, String genero, int habilidadEspecial) {
    }

    // Agregar cualquier otro atributo necesario

    /**
     * Método para obtener la instancia única del monstruo legendario (implementación de Singleton).
     *
     * @return La instancia única del monstruo legendario.
     */
    public static MonstruoLegendario obtenerInstanciaUnica() {
        if (instanciaUnica == null) {
            instanciaUnica = new MonstruoLegendario("NombreLegendario", 2000, "GeneroLegendario", "SuperpoderLegendario");
            // Configurar otros atributos según tus necesidades
        }
        return instanciaUnica;
    }

    /**
     * Constructor de la clase MonstruoLegendario.
     *
     * @param nombre          El nombre del monstruo legendario.
     * @param puntosDeVida    Los puntos de vida del monstruo legendario.
     * @param genero          El género del monstruo legendario (Macho, Hembra, Desconocido, etc.).
     * @param habilidadEspecial      El superpoder asociado al monstruo legendario.
     */
    public MonstruoLegendario(String nombre, int puntosDeVida, String genero, String habilidadEspecial) {
        super(nombre, puntosDeVida, genero);
        // Inicializar otros atributos según tus necesidades
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Puntos de Vida: " + getPuntosDeVida());
        System.out.println("Género: " + getGenero());
        System.out.println("Habilidad Especial: " + "SuperpoderLegendario");
    }
}