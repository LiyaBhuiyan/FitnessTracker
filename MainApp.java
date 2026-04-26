import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {

    Scene scene;

    @Override
    public void start(Stage stage) {

        String bgStyle =
                "-fx-background-color: linear-gradient(to bottom right, #f3e5f5, #ede7f6);";

        String btnStyle =
                "-fx-background-color:#d1c4e9;" +
                "-fx-text-fill:#2c003e;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:20;" +
                "-fx-padding:10 18;";

        VBox home = new VBox(12);
        home.setAlignment(Pos.CENTER);
        home.setStyle(bgStyle);

        Label title = new Label("💜 Fitness Tracker");
        title.setStyle("-fx-font-size:26px; -fx-font-weight:bold; -fx-text-fill:#4a148c;");

        Label subtitle = new Label("Track BMI • Diet • Workout • Health");
        subtitle.setStyle("-fx-font-size:13px; -fx-text-fill:#6a1b9a;");

        Button startBtn = new Button("Start");
        startBtn.setStyle(btnStyle);

        home.getChildren().addAll(title, subtitle, startBtn);

        VBox input = new VBox(10);
        input.setAlignment(Pos.CENTER);
        input.setStyle(bgStyle);

        TextField name = new TextField(); name.setPromptText("Name");
        TextField age = new TextField(); age.setPromptText("Age");

        
        ToggleGroup genderGroup = new ToggleGroup();

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");

        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        male.setStyle("-fx-text-fill:#4a148c;");
        female.setStyle("-fx-text-fill:#4a148c;");

        HBox genderBox = new HBox(20, male, female);
        genderBox.setAlignment(Pos.CENTER);

        TextField weight = new TextField(); weight.setPromptText("Weight (kg)");
        TextField height = new TextField(); height.setPromptText("Height (cm)");

        Button calcBtn = new Button("Generate Report");
        Button clearBtn = new Button("Clear");

        calcBtn.setStyle(btnStyle);
        clearBtn.setStyle(btnStyle);

        input.getChildren().addAll(
                name, age, genderBox, weight, height,
                calcBtn, clearBtn
        );
        VBox result = new VBox(10);
        result.setAlignment(Pos.CENTER);
        result.setStyle(bgStyle);

        Label output = new Label();
        output.setStyle("-fx-text-fill:#2c003e;");

        Button goalBtn = new Button("Goal");
        Button dietBtn = new Button("Diet");
        Button workoutBtn = new Button("Workout");
        Button finishBtn = new Button("Finish");

        goalBtn.setStyle(btnStyle);
        dietBtn.setStyle(btnStyle);
        workoutBtn.setStyle(btnStyle);
        finishBtn.setStyle(btnStyle);
        
        result.getChildren().addAll(output, goalBtn, dietBtn, workoutBtn, finishBtn);
        VBox goalPage = new VBox(10);
        goalPage.setAlignment(Pos.CENTER);
        goalPage.setStyle(bgStyle);

        Label goalLabel = new Label();
        goalLabel.setStyle("-fx-text-fill:#2c003e;");

        Button goalBack = new Button("Back");
        goalBack.setStyle(btnStyle);

        goalPage.getChildren().addAll(goalLabel, goalBack);

        VBox dietPage = new VBox(10);
        dietPage.setAlignment(Pos.CENTER);
        dietPage.setStyle(bgStyle);

        Label dietLabel = new Label();
        dietLabel.setStyle("-fx-text-fill:#2c003e;");

        Button dietBack = new Button("Back");
        dietBack.setStyle(btnStyle);

        dietPage.getChildren().addAll(dietLabel, dietBack);

        VBox workoutPage = new VBox(10);
        workoutPage.setAlignment(Pos.CENTER);
        workoutPage.setStyle(bgStyle);

        Label workoutLabel = new Label();
        workoutLabel.setStyle("-fx-text-fill:#2c003e;");

        Button workoutBack = new Button("Back");
        workoutBack.setStyle(btnStyle);

        workoutPage.getChildren().addAll(workoutLabel, workoutBack);

        VBox thanksPage = new VBox(20);
        thanksPage.setAlignment(Pos.CENTER);
        thanksPage.setStyle(bgStyle);

        Label thanksTitle = new Label("💜 Thank You!");
        thanksTitle.setStyle("-fx-font-size:26px; -fx-font-weight:bold; -fx-text-fill:#4a148c;");

        Label thanksMsg = new Label("Keep your fitness journey strong 💪");
        thanksMsg.setStyle("-fx-text-fill:#6a1b9a;");

        Button exitBtn = new Button("Exit");
        exitBtn.setStyle(btnStyle);

        thanksPage.getChildren().addAll(thanksTitle, thanksMsg, exitBtn);

        scene = new Scene(home, 420, 520);
        stage.setScene(scene);
        stage.setTitle("Fitness Tracker 💜");
        stage.show();

       
        startBtn.setOnAction(e -> scene.setRoot(input));

        goalBack.setOnAction(e -> scene.setRoot(result));
        dietBack.setOnAction(e -> scene.setRoot(result));
        workoutBack.setOnAction(e -> scene.setRoot(result));

        finishBtn.setOnAction(e -> scene.setRoot(thanksPage));
        exitBtn.setOnAction(e -> stage.close());

        clearBtn.setOnAction(e -> {
            name.clear();
            age.clear();
            weight.clear();
            height.clear();
            genderGroup.selectToggle(null);
        });

       
        calcBtn.setOnAction(e -> {

            try {

                String n = name.getText();
                int a = Integer.parseInt(age.getText());

                Toggle selected = genderGroup.getSelectedToggle();
                if (selected == null) throw new Exception("Select Gender");

                String g = ((RadioButton) selected).getText();

                double w = Double.parseDouble(weight.getText());
                double h = Double.parseDouble(height.getText()) / 100;

                User user = new User(n, a, g, w, h);

                double bmi = BMICalculation.calculate(w, h);
                String category = BMICalculation.getCategory(bmi);

                double bmr = BMRCalculation.calculate(w, h, a, g);

                double calories = CalorieCalculator.getCalories(bmr, category);

                output.setText(
                        "Name: " + n +
                        "\nGender: " + g +
                        "\nBMI: " + String.format("%.2f", bmi) +
                        "\nCategory: " + category +
                        "\nBMR: " + String.format("%.2f", bmr) +
                        "\nCalories: " + String.format("%.2f", calories)
                );

                goalBtn.setOnAction(ev -> {
                    goalLabel.setText(Goal.getGoal(w, h));
                    scene.setRoot(goalPage);
                });

                dietBtn.setOnAction(ev -> {
                    dietLabel.setText(DietPlan.getDiet(category, a));
                    scene.setRoot(dietPage);
                });

                workoutBtn.setOnAction(ev -> {
                    workoutLabel.setText(WorkoutPlan.getWorkout(category));
                    scene.setRoot(workoutPage);
                });

                scene.setRoot(result);

            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
                scene.setRoot(input);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}