/**
 * Represents the carbon footprint from driving a car.
 * This is another concrete implementation of the CarbonEmitter interface.
 */
public class Car implements CarbonEmitter {

    // Emission factor for gasoline (kg CO2e per gallon)
    private static final double GASOLINE_FACTOR = 8.89;

    private double milesDrivenPerYear;
    private double milesPerGallon;

    /**
     * Constructs a new Car object.
     *
     * @param milesDrivenPerYear Annual miles driven.
     * @param mpg                The car's fuel efficiency in miles per gallon (MPG).
     */
    public Car(double milesDrivenPerYear, double mpg) {
        this.milesDrivenPerYear = milesDrivenPerYear;
        // Avoid division by zero if MPG is 0
        if (mpg <= 0) {
            this.milesPerGallon = 1; // Set a default to prevent errors
        } else {
            this.milesPerGallon = mpg;
        }
    }

    /**
     * Calculates the total annual carbon footprint for the car.
     *
     * @return The total footprint from gasoline consumption in kg CO2e.
     */
    @Override
    public double getCarbonFootprint() {
        double gallonsUsedPerYear = milesDrivenPerYear / milesPerGallon;
        return gallonsUsedPerYear * GASOLINE_FACTOR;
    }
}
