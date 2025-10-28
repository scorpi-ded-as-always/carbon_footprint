/**
 * Represents the carbon footprint from air travel.
 * This is a third, distinct implementation of the CarbonEmitter interface.
 */
public class Flight implements CarbonEmitter {

    // Approximate emission factor for long-haul flights
    // (kg CO2e per passenger-mile)
    private static final double FLIGHT_FACTOR = 0.18;

    private double milesFlownPerYear;

    /**
     * Constructs a new Flight object.
     *
     * @param milesFlownPerYear Annual miles flown by the user.
     */
    public Flight(double milesFlownPerYear) {
        this.milesFlownPerYear = milesFlownPerYear;
    }

    /**
     * Calculates the total annual carbon footprint for air travel.
     *
     * @return The total footprint from flying in kg CO2e.
     */
    @Override
    public double getCarbonFootprint() {
        return milesFlownPerYear * FLIGHT_FACTOR;
    }
}
