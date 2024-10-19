public class BatterySoHCalculator {

    public static double calculateSoH(double ratedCapacity, double presentCapacity) {
        if (ratedCapacity <= 0) {
            throw new IllegalArgumentException("Rated capacity must be greater than zero.");
        }
        if (presentCapacity < 0) {
            throw new IllegalArgumentException("Present capacity cannot be negative.");
        }
        return 100 * presentCapacity / ratedCapacity;
    }

    public static void main(String[] args) {
        double ratedCapacity = 120; 
        double presentCapacity = 105; 
        double soh = calculateSoH(ratedCapacity, presentCapacity);
        System.out.printf("The State of Health (SoH) of the battery is: %.2f%%%n", soh);
    }
}