package vehiculos;

/**
 * Clase que representa un camión.
 * Ejemplo de extensión (OCP): se puede agregar sin modificar las clases existentes.
 */
public class Camion implements Vehiculo, Conducible {
    private final String matricula;
    private final double capacidadCarga; // toneladas

    public Camion(String matricula, double capacidadCarga) {
        this.matricula = matricula;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Camion - Matrícula: " + matricula + ", Capacidad de carga: " + capacidadCarga + " toneladas");
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo el camión con capacidad de " + capacidadCarga + " toneladas");
    }
}