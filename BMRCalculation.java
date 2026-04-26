public class BMRCalculation {

    public static double calculate(double weight, double height, int age, String gender) {

        if (gender.equalsIgnoreCase("Male")) {
            return 88.36 + (13.4 * weight) + (4.8 * height * 100) - (5.7 * age);
        } else {
            return 447.6 + (9.2 * weight) + (3.1 * height * 100) - (4.3 * age);
        }
    }
}