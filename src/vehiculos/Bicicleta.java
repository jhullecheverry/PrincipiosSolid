package vehiculos;

public class Bicicleta implements Vehiculo {
    private final String matricula;
    private final int marchas;

    public Bicicleta(String matricula, int marchas) {
        this.matricula = matricula;
        this.marchas = marchas;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Bicicleta - Matrícula: " + matricula + ", Marchas: " + marchas);
    }
}