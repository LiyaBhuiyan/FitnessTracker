public class BMICalculation {

    public static double calculate(double weight, double height) {
        return weight / (height * height);
    }

    public static String getCategory(double bmi) {

        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
}