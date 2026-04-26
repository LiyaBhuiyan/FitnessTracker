public class WorkoutPlan {

    public static String getWorkout(String category) {

        if (category.equals("Underweight")) {

            return "WORKOUT PLAN (Muscle Gain)\n" +
                    "- Light weight training\n" +
                    "- Push-ups (3 sets)\n" +
                    "- Squats (3 sets)\n" +
                    "- Gym 3-4 days/week";

        } else if (category.equals("Normal")) {

            return "WORKOUT PLAN (Fitness)\n" +
                    "- Jogging 20-30 min\n" +
                    "- Gym 3 days/week\n" +
                    "- Stretching daily";

        } else if (category.equals("Overweight")) {

            return "WORKOUT PLAN (Fat Burn)\n" +
                    "- Running 30 min\n" +
                    "- Cardio exercises\n" +
                    "- Cycling\n" +
                    "- Gym 4-5 days/week";

        } else if (category.equals("Obese")) {

            return "WORKOUT PLAN (Intensive Fat Loss)\n" +
                    "- Walking 40-60 min daily\n" +
                    "- Light cardio\n" +
                    "- No rest day (light activity)";

        } else {
            return "No Workout Plan Available";
        }
    }
}