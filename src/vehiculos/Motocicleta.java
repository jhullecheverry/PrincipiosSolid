package vehiculos;

/**
 * Clase que representa una motocicleta.
 * Cumple con SRP, OCP y LSP.
 */
public class Motocicleta implements Vehiculo, Conducible {
    private final String matricula;
    private final String tipo;

    public Motocicleta(String matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Motocicleta - Matrícula: " + matricula + ", Tipo: " + tipo);
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo la motocicleta tipo " + tipo);
    }
}