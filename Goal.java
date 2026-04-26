public class Goal {

    public static String getGoal(double currentWeight, double height) {

        double idealMin = 18.5 * height * height;
        double idealMax = 24.9 * height * height;

        if (currentWeight < idealMin) {

            double gain = idealMin - currentWeight;
            return "You are underweight.\nYou need to gain around "
                    + String.format("%.2f", gain) + " kg to reach ideal range.";

        } else if (currentWeight > idealMax) {

            double lose = currentWeight - idealMax;
            return "You are overweight.\nYou need to lose around "
                    + String.format("%.2f", lose) + " kg to reach ideal range.";

        } else {

            return "Perfect! You are in the ideal weight range 🎯";
        }
    }
}