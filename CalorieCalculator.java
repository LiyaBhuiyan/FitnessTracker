public class CalorieCalculator {

    public static double getCalories(double bmr, String category) {

        if (category.equals("Underweight")) return bmr + 500;
        else if (category.equals("Normal")) return bmr;
        else if (category.equals("Overweight")) return bmr - 500;
        else return bmr - 700;
    }
}