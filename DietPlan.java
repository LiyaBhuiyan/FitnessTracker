public class DietPlan {

    public static String getDiet(String category, int age) {

        String breakfast, lunch, dinner, snacks;
        String water, sleep;

        // ================= DIET =================
        switch (category) {

            case "Underweight":
                breakfast = "Eggs + Milk + Bread";
                lunch = "Rice + Chicken + Vegetables";
                dinner = "Fish + Rice";
                snacks = "Nuts + Banana";
                break;

            case "Normal":
                breakfast = "Oats + Egg";
                lunch = "Rice + Fish + Salad";
                dinner = "Light food + Vegetables";
                snacks = "Fruits";
                break;

            case "Overweight":
                breakfast = "Oats + Green tea";
                lunch = "Salad + Chicken (boiled)";
                dinner = "Soup + Vegetables";
                snacks = "Apple / Fruits";
                break;

            case "Obese":
                breakfast = "Only fruits";
                lunch = "Salad + Protein";
                dinner = "Soup (no oil)";
                snacks = "No sugar snacks";
                break;

            default:
                return "";
        }

        // ================= WATER =================
        if (age <= 18) water = "Water: 2 - 2.5 L/day";
        else if (age <= 40) water = "Water: 2.5 - 3 L/day";
        else water = "Water: 2 - 2.5 L/day";

        // ================= SLEEP =================
        if (age <= 18) sleep = "Sleep: 8 - 10 hours";
        else if (age <= 40) sleep = "Sleep: 7 - 8 hours";
        else sleep = "Sleep: 6 - 7 hours";

        return "🍳 Breakfast: " + breakfast +
               "\n🍛 Lunch: " + lunch +
               "\n🍽 Dinner: " + dinner +
               "\n🍎 Snacks: " + snacks +
               "\n\n💧 " + water +
               "\n😴 " + sleep;
    }
}