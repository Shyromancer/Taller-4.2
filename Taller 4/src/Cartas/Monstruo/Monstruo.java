package Cartas.Monstruo;

/**
 * La clase abstracta Monstruo representa a un monstruo en el juego.
 * Proporciona propiedades básicas como nombre, puntos de vida y género.
 * También incluye un método abstracto para mostrar información específica del monstruo.
 *
 * @author Matias Munioz y Andoni Madrid
 * @version 05/12/2023
 */
public abstract class Monstruo {
    protected int id;
    protected String nombre;
    protected int puntosDeVida;
    protected String genero;


    /**
     * Constructor de la clase Monstruo.
     *
     * @param id           El identificador único del monstruo.
     * @param nombre       El nombre del monstruo.
     * @param puntosDeVida Los puntos de vida del monstruo.
     * @param genero       El género del monstruo (Macho, Hembra, Desconocido, etc.).
     */
    public Monstruo(int id,String nombre, int puntosDeVida, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.genero = genero;
    }


    /**
     *
     * @param nombre       El nombre del monstruo.
     * @param puntosDeVida Los puntos de vida del monstruo.
     * @param genero       El género del monstruo (Macho, Hembra, Desconocido, etc.).
     */
    public Monstruo(String nombre, int puntosDeVida, String genero) {
    }

    /**
     * Constructor por defecto de la clase Monstruo.
     */
    public Monstruo() {

    }

    /**
     * Obtiene el nombre del monstruo.
     *
     * @return El nombre del monstruo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del monstruo.
     *
     * @param nombre El nuevo nombre del monstruo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los puntos de vida del monstruo.
     *
     * @return Los puntos de vida del monstruo.
     */
    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    /**
     * Establece los puntos de vida del monstruo.
     *
     * @param puntosDeVida Los nuevos puntos de vida del monstruo.
     */
    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    /**
     * Obtiene el género del monstruo.
     *
     * @return El género del monstruo.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del monstruo.
     *
     * @param genero El nuevo género del monstruo.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Método abstracto para mostrar información específica del monstruo.
     */
    public abstract void mostrarInformacion();

    /**
     * Obtiene el identificador único del monstruo.
     *
     * @return El identificador único del monstruo.
     */
    public boolean getId() {
        //la id de los mosntruos esta dada po el archivo txt
        return true;
    }

    public void setId(int id) {
    }
}





