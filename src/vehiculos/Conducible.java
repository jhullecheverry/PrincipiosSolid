package vehiculos;

/**
 * Interfaz para vehículos que pueden ser conducidos (no pedaleados).
 * Cumple con ISP; solo los vehículos relevantes la implementan.
 */
public interface Conducible {
    void conducir();
}