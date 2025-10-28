import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class to run the carbon footprint calculator.
 * This class demonstrates POLYMORPHISM.
 */
public class CarbonFootprintCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // This list will hold all our different types of emission sources.
        // Because they all implement CarbonEmitter, we can store them in
        // the same list. This is POLYMORPHISM in action.
        List<CarbonEmitter> emitters = new ArrayList<>();

        System.out.println("--- Carbon Footprint Calculator ---");

        // 1. Get Household Data
        System.out.println("\n--- Household Energy ---");
        System.out.print("Enter yearly electricity usage (kWh): ");
        double electricity = scanner.nextDouble();
        System.out.print("Enter yearly natural gas usage (therms): ");
        double gas = scanner.nextDouble();
        System.out.print("Enter yearly heating oil usage (gallons): ");
        double oil = scanner.nextDouble();

        // Create a Household object and add it to the list
        emitters.add(new Household(electricity, gas, oil));

        // 2. Get Car Data
        System.out.println("\n--- Transportation (Car) ---");
        System.out.print("Enter yearly miles driven: ");
        double milesDriven = scanner.nextDouble();
        System.out.print("Enter your car's fuel efficiency (miles per gallon): ");
        double mpg = scanner.nextDouble();

        // Create a Car object and add it to the list
        emitters.add(new Car(milesDriven, mpg));

        // 3. Get Flight Data
        System.out.println("\n--- Transportation (Flights) ---");
        System.out.print("Enter yearly miles flown: ");
        double milesFlown = scanner.nextDouble();

        // Create a Flight object and add it to the list
        emitters.add(new Flight(milesFlown));

        // 4. Calculate Total Footprint
        double totalFootprintKg = 0;

        // This is the magic of POLYMORPHISM.
        // We loop through the list and call getCarbonFootprint() on each
        // object. We don't need to know if it's a Car, Household, or Flight.
        // Java calls the correct method for each object's actual class.
        for (CarbonEmitter emitter : emitters) {
            totalFootprintKg += emitter.getCarbonFootprint();
        }

        // 5. Display Results
        double totalFootprintTonnes = totalFootprintKg / 1000.0;

        System.out.println("\n--- Your Total Annual Carbon Footprint ---");
        System.out.printf("Total: %.2f kg CO2e per year\n", totalFootprintKg);
        System.out.printf("Total: %.2f tonnes CO2e per year\n", totalFootprintTonnes);

        System.out.println("\n(For reference, the average annual carbon footprint in the US is ~16 tonnes.)");

        scanner.close();
    }
}
