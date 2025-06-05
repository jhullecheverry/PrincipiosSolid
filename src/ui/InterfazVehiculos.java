package ui;

import vehiculos.*;
import estacionamiento.Estacionamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfaz gráfica para el sistema de control de vehículos.
 * Permite agregar, retirar y mostrar vehículos usando el sistema de estacionamiento.
 */
public class InterfazVehiculos extends JFrame {
    private final Estacionamiento estacionamiento;
    private final JTextArea areaTexto;

    public InterfazVehiculos() {
        super("Sistema de Control de Vehículos");
        this.estacionamiento = new Estacionamiento();

        // --- Configuración de la ventana principal ---
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // --- Elementos de la interfaz ---
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 2, 10, 10));

        JButton btnAgregar = new JButton("Agregar Vehículo");
        JButton btnRetirar = new JButton("Retirar Vehículo");
        JButton btnMostrar = new JButton("Mostrar Vehículos");
        JButton btnResumen = new JButton("Ver Resumen por Tipo");

        areaTexto = new JTextArea(12, 50);
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnRetirar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnResumen);

        add(panelBotones, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // --- Acciones de los botones ---
        btnAgregar.addActionListener(e -> mostrarDialogoAgregar());
        btnRetirar.addActionListener(e -> mostrarDialogoRetirar());
        btnMostrar.addActionListener(e -> mostrarVehiculos());
        btnResumen.addActionListener(e -> mostrarResumen());

        setVisible(true);
    }

    /**
     * Muestra un diálogo para agregar un vehículo de cualquier tipo.
     */
    private void mostrarDialogoAgregar() {
        String[] tipos = {"Coche", "Motocicleta", "Bicicleta", "Camion"};
        String tipo = (String) JOptionPane.showInputDialog(this, "Seleccione el tipo de vehículo:",
                "Agregar Vehículo", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        if (tipo == null) return;

        String matricula = JOptionPane.showInputDialog(this, "Ingrese la matrícula (o código):");
        if (matricula == null || matricula.trim().isEmpty()) return;

        Vehiculo v = null;

        switch (tipo) {
            case "Coche" -> {
                String modelo = JOptionPane.showInputDialog(this, "Modelo:");
                String puertasStr = JOptionPane.showInputDialog(this, "Número de puertas:");
                int puertas = Integer.parseInt(puertasStr);
                v = new Coche(matricula, modelo, puertas);
            }
            case "Motocicleta" -> {
                String tipoMoto = JOptionPane.showInputDialog(this, "Tipo (deportiva, scooter, etc):");
                v = new Motocicleta(matricula, tipoMoto);
            }
            case "Bicicleta" -> {
                String marchasStr = JOptionPane.showInputDialog(this, "Número de marchas:");
                int marchas = Integer.parseInt(marchasStr);
                v = new Bicicleta(matricula, marchas);
            }
            case "Camion" -> {
                String capacidadStr = JOptionPane.showInputDialog(this, "Capacidad de carga (toneladas):");
                double capacidad = Double.parseDouble(capacidadStr);
                v = new Camion(matricula, capacidad);
            }
        }

        if (v != null) {
            estacionamiento.ingresarVehiculo(v);
            areaTexto.append("Vehículo agregado: " + matricula + "\n");
        }
    }

    /**
     * Solicita la matrícula y retira el vehículo si existe.
     */
    private void mostrarDialogoRetirar() {
        String matricula = JOptionPane.showInputDialog(this, "Matrícula del vehículo a retirar:");
        if (matricula == null || matricula.trim().isEmpty()) return;
        boolean exito = estacionamiento.retirarVehiculo(matricula);
        areaTexto.append(exito ? "Vehículo retirado: " + matricula + "\n" : "No se encontró el vehículo\n");
    }

    /**
     * Muestra todos los vehículos en el área de texto.
     */
    private void mostrarVehiculos() {
        areaTexto.append("\n--- Vehículos en el estacionamiento ---\n");
        estacionamiento.mostrarVehiculos(areaTexto);
    }

    /**
     * Muestra el resumen de vehículos por tipo.
     */
    private void mostrarResumen() {
        areaTexto.append("\n--- Resumen por tipo ---\n");
        estacionamiento.mostrarResumenPorTipo(areaTexto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfazVehiculos::new);
    }
}