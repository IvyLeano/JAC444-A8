
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuizGUI extends Application {

	// Here I declares a new instance of the Quiz class and my gridpane and scene
	Quiz quiz = new Quiz();
	GridPane GridQuizApplication = new GridPane();
	Scene SceneQuizApplication = new Scene(GridQuizApplication);

	// Below are all the TextField, user input fields
	TextField additionInput = new TextField();
	TextField subtractionInput = new TextField();
	TextField multiplicationInput = new TextField();
	TextField divisionInput = new TextField();
	TextField tryAgainInput = new TextField();

	// Below are all the Text Fields for the quiz
	Text heading;
	Text addition;
	Text subtraction;
	Text multiplication;
	Text division;
	Text tryAgain;

	// Below are the Text fields for the results of the quiz
	Text correctAnswers = new Text();
	Text incorrectAnswers = new Text();
	Text addResult = new Text();
	Text subResult = new Text();
	Text multResult = new Text();
	Text divResult = new Text();

	// Below are the gridpane buttons
	Button btnSubmit = new Button("Submit");
	Button btnSubmitAnswers = new Button("Submit Answers");

	@Override
	public void start(Stage primaryStage) {
		// Calls the generateRandomNumber() function to create two random numbers
		quiz.generateRandomNumber();

		// Below are all the Text Fields for the quiz set with random number values
		heading = new Text(
				"\nRandomly generated numbers: " + quiz.getRandomNumber1() + " and " + quiz.getRandomNumber2() + "\n");
		addition = new Text(
				"        Question 1)       " + quiz.getRandomNumber1() + "  +  " + quiz.getRandomNumber2() + "  = ");
		subtraction = new Text(
				"        Question 2)       " + quiz.getRandomNumber1() + "  -  " + quiz.getRandomNumber2() + "   = ");
		multiplication = new Text(
				"        Question 3)       " + quiz.getRandomNumber1() + "  x  " + quiz.getRandomNumber2() + "   = ");
		division = new Text(
				"        Question 4)       " + quiz.getRandomNumber1() + "  /  " + quiz.getRandomNumber2() + "   = ");
		tryAgain = new Text("Would you like to try two new numbers: ");

		// GridPane and button settings
		GridQuizApplication.setHgap(6);
		GridQuizApplication.setVgap(6);
		GridQuizApplication.setPrefSize(500, 350);
		GridQuizApplication.setAlignment(Pos.CENTER);
		btnSubmitAnswers.setMaxWidth(Double.MAX_VALUE);
		btnSubmit.setMaxWidth(Double.MAX_VALUE);

		// Adding the elements to GridPane
		GridQuizApplication.add(heading, 0, 0);
		GridQuizApplication.add(addition, 0, 1);
		GridQuizApplication.add(additionInput, 1, 1);
		GridQuizApplication.add(subtraction, 0, 2);
		GridQuizApplication.add(subtractionInput, 1, 2);
		GridQuizApplication.add(multiplication, 0, 3);
		GridQuizApplication.add(multiplicationInput, 1, 3);
		GridQuizApplication.add(division, 0, 4);
		GridQuizApplication.add(divisionInput, 1, 4);
		GridQuizApplication.add(btnSubmitAnswers, 1, 5);

		// Button on click event handlers
		btnSubmitAnswers.setOnAction(event -> {
			
			try {
				quiz.setUserAnswers(Double.parseDouble(additionInput.getText()),
						Double.parseDouble(subtractionInput.getText()),
						Double.parseDouble(multiplicationInput.getText()), Double.parseDouble(divisionInput.getText()));
				checkAnswers();
			} catch (Exception e) {
				System.out.printf("Incorrect value entered, please try again.\n");
				clearInputFields();
			}
		});
		// Submit button for the tryAgain field
		btnSubmit.setOnAction(event -> {
			try {
				boolean length = tryAgainInput.getText().length() == 1;

				if (length & tryAgainInput.getText().equalsIgnoreCase("N")) {
					System.exit(0);
				} else if (length & tryAgainInput.getText().equalsIgnoreCase("Y")) {

					reset();
					clearInputFields();
					GridQuizApplication.add(btnSubmitAnswers, 1, 5);
				} else {
					throw new Exception();

				}
			} catch (Exception e) {
				System.out.print("Invalid input. Please enter Y or N.\n");
			}
		});

		primaryStage.setTitle("Quiz Application");
		primaryStage.setScene(SceneQuizApplication);
		primaryStage.show();
	}

	// Compares the values that the user input (stored in the List array) to the
	// calculation of the add, subtract, multiply and divide functions
	void checkAnswers() {
		int correct = quiz.getResults();
		int incorrect = 4 - quiz.getResults();

		addResult = (quiz.getUserAnswers("add") == quiz.add()) ? new Text("Correct") : new Text("Incorrect");
		GridQuizApplication.add(addResult, 2, 1);

		subResult = (quiz.getUserAnswers("sub") == quiz.subtract()) ? new Text("Correct") : new Text("Incorrect");
		GridQuizApplication.add(subResult, 2, 2);

		multResult = (quiz.getUserAnswers("mult") == quiz.multiply()) ? new Text("Correct") : new Text("Incorrect");
		GridQuizApplication.add(multResult, 2, 3);

		divResult = (quiz.getUserAnswers("div") == quiz.divide()) ? new Text("Correct") : new Text("Incorrect");
		GridQuizApplication.add(divResult, 2, 4);

		correctAnswers = new Text("     Number of Correct Answers: " + correct);
		incorrectAnswers = new Text("Number of Wrong Answers: " + incorrect);

		GridQuizApplication.add(correctAnswers, 0, 6);
		GridQuizApplication.add(incorrectAnswers, 1, 6);
		GridQuizApplication.add(tryAgain, 0, 8);
		GridQuizApplication.add(tryAgainInput, 1, 8);
		GridQuizApplication.add(btnSubmit, 1, 9);
		GridQuizApplication.getChildren().remove(btnSubmitAnswers);
	}

	// Clears all of the input fields for a fresh page, if user inputs "Y" to trying
	// again
	void clearInputFields() {

		GridQuizApplication.getChildren().remove(additionInput);
		additionInput = new TextField();
		GridQuizApplication.add(additionInput, 1, 1);

		GridQuizApplication.getChildren().remove(subtractionInput);
		subtractionInput = new TextField();
		GridQuizApplication.add(subtractionInput, 1, 2);

		GridQuizApplication.getChildren().remove(multiplicationInput);
		multiplicationInput = new TextField();
		GridQuizApplication.add(multiplicationInput, 1, 3);

		GridQuizApplication.getChildren().remove(divisionInput);
		divisionInput = new TextField();
		GridQuizApplication.add(divisionInput, 1, 4);
		
	

	}

	// Resets the quiz to the original state, with new Text fields
	void reset() {
		quiz.generateRandomNumber();
		GridQuizApplication.getChildren().remove(correctAnswers);
		GridQuizApplication.getChildren().remove(incorrectAnswers);
		GridQuizApplication.getChildren().remove(tryAgain);
		GridQuizApplication.getChildren().remove(tryAgainInput);
		tryAgainInput = new TextField();
		GridQuizApplication.getChildren().remove(btnSubmit);

		GridQuizApplication.getChildren().remove(addResult);
		GridQuizApplication.getChildren().remove(subResult);
		GridQuizApplication.getChildren().remove(multResult);
		GridQuizApplication.getChildren().remove(divResult);

		GridQuizApplication.getChildren().remove(heading);
		GridQuizApplication.getChildren().remove(addition);
		GridQuizApplication.getChildren().remove(multiplication);
		GridQuizApplication.getChildren().remove(subtraction);
		GridQuizApplication.getChildren().remove(division);

		heading = new Text(
				"\nRandomly generated numbers: " + quiz.getRandomNumber1() + " and " + quiz.getRandomNumber2() + "\n");
		addition = new Text(
				"        Question 1)       " + quiz.getRandomNumber1() + "  +  " + quiz.getRandomNumber2() + "  = ");
		subtraction = new Text(
				"        Question 2)       " + quiz.getRandomNumber1() + "  -  " + quiz.getRandomNumber2() + "   = ");
		multiplication = new Text(
				"        Question 3)       " + quiz.getRandomNumber1() + "  x  " + quiz.getRandomNumber2() + "   = ");
		division = new Text(
				"        Question 4)       " + quiz.getRandomNumber1() + "  /  " + quiz.getRandomNumber2() + "   = ");

		GridQuizApplication.add(heading, 0, 0);
		GridQuizApplication.add(addition, 0, 1);
		GridQuizApplication.add(subtraction, 0, 2);
		GridQuizApplication.add(multiplication, 0, 3);
		GridQuizApplication.add(division, 0, 4);
	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}
