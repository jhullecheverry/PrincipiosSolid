package vehiculos;

/**
 * Clase que representa un coche.
 * Cumple con SRP, OCP y LSP.
 */
public class Coche implements Vehiculo, Conducible {
    private final String matricula;
    private final String modelo;
    private final int numPuertas;

    public Coche(String matricula, String modelo, int numPuertas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Coche - Matrícula: " + matricula + ", Modelo: " + modelo + ", Puertas: " + numPuertas);
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo el coche " + modelo);
    }
}