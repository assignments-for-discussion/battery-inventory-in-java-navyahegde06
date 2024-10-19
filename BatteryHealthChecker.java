public class BatteryHealthChecker {

    private static final double RATED_CAPACITY = 120; // Rated capacity of the batteries in Ah

    private static double calculateSoH(double presentCapacity) {
        if (presentCapacity < 0) {
            throw new IllegalArgumentException("Present capacity cannot be negative.");
        }
        return (presentCapacity / RATED_CAPACITY) * 100;
    }
    private static String classifyBattery(double presentCapacity) {
        double soh = calculateSoH(presentCapacity);
        if (soh > 80) return "healthy";
        if (soh >= 62) return "exchange";
        return "failed";
    }

    public static void main(String[] args) {

        double[] presentCapacities = {110, 85, 50, 95, 75, 120, 60};

        int healthyCount = 0, exchangeCount = 0, failedCount = 0;

        for (double presentCapacity : presentCapacities) {
            String classification = classifyBattery(presentCapacity);

            switch (classification) {
                case "healthy":
                    healthyCount++;
                    break;
                case "exchange":
                    exchangeCount++;
                    break;
                case "failed":
                    failedCount++;
                    break;
            }
        }

        System.out.println("Number of healthy batteries: " + healthyCount);
        System.out.println("Number of batteries for exchange: " + exchangeCount);
        System.out.println("Number of failed batteries: " + failedCount);
    }
}