
import Bases.JuegoImpl;




public class Main {
    public static void main(String[] args) {
        // Inicializar el juego
        Object Monstruo;
        boolean cartasDelJugador;
        JuegoImpl juegoImpl = new JuegoImpl();



        // Cargar datos desde archivos al iniciar el juego
        juegoImpl.cargarDatos();

        // Mostrar el menú principal y gestionar las opciones del jugador
        juegoImpl.mostrarMenuPrincipal();

        // Al salir del juego o finalizar la ejecución, guardar datos actualizados en archivos
        juegoImpl.guardarDatos();
    }
}

