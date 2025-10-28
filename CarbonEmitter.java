/**
 * Interface for any object that can produce a carbon footprint.
 * This demonstrates ABSTRACTION. Any class that is a "CarbonEmitter"
 * must provide a way to get its footprint.
 */
public interface CarbonEmitter {

    /**
     * Calculates the annual carbon footprint for this entity.
     *
     * @return The annual carbon footprint in kilograms (kg) of CO2e.
     */
    double getCarbonFootprint();
}
