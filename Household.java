/**
 * Represents the carbon footprint from household energy usage.
 * This class demonstrates ENCAPSULATION by bundling data (usage)
 * and behavior (calculation) together.
 */
public class Household implements CarbonEmitter {

    // Emission factors (kg CO2e per unit)
    // Sources are approximate, e.g., from EPA.
    private static final double ELECTRICITY_FACTOR = 0.37; // kg CO2e per kWh
    private static final double GAS_FACTOR = 5.3;         // kg CO2e per therm
    private static final double OIL_FACTOR = 10.18;       // kg CO2e per gallon

    // Encapsulated data
    private double yearlyElectricityUsageKWh;
    private double yearlyNaturalGasUsageTherms;
    private double yearlyHeatingOilUsageGallons;

    /**
     * Constructs a new Household object with its annual energy consumption.
     *
     * @param electricityKWh Annual electricity usage in kWh.
     * @param gasTherms      Annual natural gas usage in therms.
     * @param oilGallons     Annual heating oil usage in gallons.
     */
    public Household(double electricityKWh, double gasTherms, double oilGallons) {
        this.yearlyElectricityUsageKWh = electricityKWh;
        this.yearlyNaturalGasUsageTherms = gasTherms;
        this.yearlyHeatingOilUsageGallons = oilGallons;
    }

    /**
     * Calculates the total annual carbon footprint for the household.
     * This is the required method from the CarbonEmitter interface.
     *
     * @return The total footprint from electricity, gas, and oil in kg CO2e.
     */
    @Override
    public double getCarbonFootprint() {
        double electricityFootprint = yearlyElectricityUsageKWh * ELECTRICITY_FACTOR;
        double gasFootprint = yearlyNaturalGasUsageTherms * GAS_FACTOR;
        double oilFootprint = yearlyHeatingOilUsageGallons * OIL_FACTOR;

        return electricityFootprint + gasFootprint + oilFootprint;
    }
}
