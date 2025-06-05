package main;

import vehiculos.*;
import estacionamiento.Estacionamiento;

/**
 * Clase principal para probar el sistema de gestión de vehículos.
 */
public class Main {
    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento();

        // Instanciación de los distintos vehículos
        Vehiculo coche = new Coche("ABC123", "Toyota Corolla", 4);
        Vehiculo moto = new Motocicleta("XYZ789", "Deportiva");
        Vehiculo bici = new Bicicleta("BICI001", 7);
        Vehiculo camion = new Camion("TRK999", 12.5);

        // Ingreso de vehículos al estacionamiento
        estacionamiento.ingresarVehiculo(coche);
        estacionamiento.ingresarVehiculo(moto);
        estacionamiento.ingresarVehiculo(bici);
        estacionamiento.ingresarVehiculo(camion);


        estacionamiento.mostrarVehiculos();

        // Demostración de ISP: solo conducibles pueden ser conducidos
        System.out.println("\nDemostrando conducción:");
        if (coche instanceof Conducible) ((Conducible) coche).conducir();
        if (moto instanceof Conducible) ((Conducible) moto).conducir();
        if (bici instanceof Conducible) ((Conducible) bici).conducir(); // No hace nada
        if (camion instanceof Conducible) ((Conducible) camion).conducir();

        // Retirar un vehículo
        System.out.println("\nRetirando un vehículo:");
        estacionamiento.retirarVehiculo("BICI001");

        // Mostrar el resumen por tipo
        System.out.println("\nResumen actual:");
        estacionamiento.mostrarResumenPorTipo();
    }
}