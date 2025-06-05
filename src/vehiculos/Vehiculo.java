package vehiculos;

/**
 * Interfaz general para todos los vehículos.
 * Cumple con DIP y OCP, permitiendo que el sistema dependa de abstracciones
 * y sea fácilmente extensible con nuevos tipos de vehículos.
 */
public interface Vehiculo {
    String getMatricula();
    void mostrarInfo();
}