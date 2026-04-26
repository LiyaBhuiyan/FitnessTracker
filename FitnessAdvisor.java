public class FitnessAdvisor {

    public static String getDiet(String category) {

        return switch (category) {
            case "Underweight" ->
                    "Diet: Milk, Eggs, Rice, Meat, Nuts";

            case "Normal" ->
                    "Diet: Balanced food, fruits, fish, rice";

            case "Overweight" ->
                    "Diet: Salad, chicken, oats, avoid sugar";

            case "Obese" ->
                    "Strict diet: no sugar, no fried food, more veggies";

            default -> "";
        };
    }

    public static String getWorkout(String category) {

        return switch (category) {
            case "Underweight" -> "Light gym + strength training";
            case "Normal" -> "Jogging + gym 3-4 days";
            case "Overweight" -> "Cardio + fat burn";
            case "Obese" -> "Daily cardio + strict workout";
            default -> "";
        };
    }
}