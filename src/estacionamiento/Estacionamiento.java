package estacionamiento;

import vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Clase que gestiona el estacionamiento de vehículos.
 * Depende de la abstracción Vehiculo (DIP).
 * Incluye métodos para ingresar, retirar y mostrar vehículos.
 */
public class Estacionamiento {
    private final List<Vehiculo> vehiculos;

    public Estacionamiento() {
        this.vehiculos = new ArrayList<>();
    }

    public void ingresarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo ingresado: " + vehiculo.getMatricula());
    }

    public boolean retirarVehiculo(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculos.remove(v);
                System.out.println("Vehículo retirado: " + matricula);
                return true;
            }
        }
        System.out.println("Vehículo no encontrado: " + matricula);
        return false;
    }

    /**
     * Muestra todos los vehículos actualmente en el estacionamiento en consola.
     */
    public void mostrarVehiculos() {
        for (Vehiculo v : vehiculos) {
            v.mostrarInfo();
        }
    }

    /**
     * Muestra todos los vehículos en un JTextArea.
     */
    public void mostrarVehiculos(JTextArea area) {
        for (Vehiculo v : vehiculos) {
            area.append(v.getClass().getSimpleName() + ": ");
            area.append(v.getMatricula() + " - ");
            // Descripción extendida
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            java.io.PrintStream old = System.out;
            System.setOut(ps);
            v.mostrarInfo();
            System.out.flush();
            System.setOut(old);
            area.append(baos.toString());
        }
    }

    /**
     * Muestra la cantidad de vehículos por tipo en consola.
     */
    public void mostrarResumenPorTipo() {
        int coches = 0, motos = 0, bicis = 0, camiones = 0;
        for (Vehiculo v : vehiculos) {
            switch (v.getClass().getSimpleName()) {
                case "Coche" -> coches++;
                case "Motocicleta" -> motos++;
                case "Bicicleta" -> bicis++;
                case "Camion" -> camiones++;
            }
        }
        System.out.println("Coches: " + coches);
        System.out.println("Motocicletas: " + motos);
        System.out.println("Bicicletas: " + bicis);
        System.out.println("Camiones: " + camiones);
    }

    /**
     * Muestra la cantidad de vehículos por tipo en un JTextArea.
     */
    public void mostrarResumenPorTipo(JTextArea area) {
        int coches = 0, motos = 0, bicis = 0, camiones = 0;
        for (Vehiculo v : vehiculos) {
            switch (v.getClass().getSimpleName()) {
                case "Coche" -> coches++;
                case "Motocicleta" -> motos++;
                case "Bicicleta" -> bicis++;
                case "Camion" -> camiones++;
            }
        }
        area.append("Coches: " + coches + "\n");
        area.append("Motocicletas: " + motos + "\n");
        area.append("Bicicletas: " + bicis + "\n");
        area.append("Camiones: " + camiones + "\n");
    }
}