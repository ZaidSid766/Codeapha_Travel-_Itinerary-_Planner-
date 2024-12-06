import java.util.*;

class TravelItineraryPlanner {

    static Scanner scanner = new Scanner(System.in);

    static class Destination {
        String name;
        String date;
        String preference;
        double estimatedCost;

        Destination(String name, String date, String preference, double estimatedCost) {
            this.name = name;
            this.date = date;
            this.preference = preference;
            this.estimatedCost = estimatedCost;
        }

        @Override
        public String toString() {
            return "Destination: " + name + ", Date: " + date + ", Preference: " + preference + ", Cost: $" + estimatedCost;
        }
    }

    static List<Destination> itinerary = new ArrayList<>();
    static double totalBudget = 0.0;

    static void addDestination() {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter travel date (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        System.out.print("Enter preference (e.g., Adventure, Relaxation): ");
        String preference = scanner.nextLine();

        System.out.print("Enter estimated cost for this destination: ");
        double estimatedCost = scanner.nextDouble();
        scanner.nextLine();

        itinerary.add(new Destination(name, date, preference, estimatedCost));
        totalBudget += estimatedCost;

        System.out.println("Destination added successfully!");
    }

    static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added yet.");
            return;
        }

        System.out.println("Your Travel Itinerary:");
        for (int i = 0; i < itinerary.size(); i++) {
            System.out.println((i + 1) + ". " + itinerary.get(i));
        }
        System.out.println("Total Estimated Budget: $" + totalBudget);
    }

    static void getWeatherInfo() {
        System.out.print("Enter destination name to check weather: ");
        String destination = scanner.nextLine();

        String[] weatherOptions = {"Sunny", "Rainy", "Cloudy", "Snowy"};
        String weather = weatherOptions[new Random().nextInt(weatherOptions.length)];

        System.out.println("Weather forecast for " + destination + ": " + weather);
    }

    static void viewMap() {
        System.out.print("Enter destination name to view map: ");
        String destination = scanner.nextLine();

        System.out.println("Opening map for " + destination + " (Simulated).");
        System.out.println("Feature will display a graphical map in a real-world system.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Check Weather");
            System.out.println("4. View Map");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addDestination();
                case 2 -> viewItinerary();
                case 3 -> getWeatherInfo();
                case 4 -> viewMap();
                case 5 -> {
                    System.out.println("Thank you for using the Travel Itinerary Planner!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
