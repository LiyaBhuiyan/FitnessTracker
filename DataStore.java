import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DataStore {

    private static final String FILE_NAME = "fitness_data.txt";

    // ================= SAVE DATA =================
    public static void save(User user, double bmi, double bmr, String category, double calories) {

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {

            fw.write("===== FITNESS REPORT =====\n");
            fw.write("Name: " + user.getName() + "\n");
            fw.write("Age: " + user.getAge() + "\n");
            fw.write("Gender: " + user.getGender() + "\n");
            fw.write("Weight: " + user.getWeight() + "\n");
            fw.write("Height: " + user.getHeight() + "\n");

            fw.write("BMI: " + String.format("%.2f", bmi) + "\n");
            fw.write("Category: " + category + "\n");
            fw.write("BMR: " + String.format("%.2f", bmr) + "\n");
            fw.write("Calories: " + String.format("%.2f", calories) + "\n");

            fw.write("---------------------------\n\n");

        } catch (IOException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    // ================= LOAD DATA =================
    public static String load() {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            return "No previous data found!";
        }

        return sb.toString();
    }
}