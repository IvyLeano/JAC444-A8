import javafx.application.Application;

public class TesterClass {
	//Task 2
	public static void main(String[] args) {
	Countries countries = new Countries();
	countries.initialize();
	countries.promptCountry();
	
	//Task 1
	Application.launch(QuizGUI.class);
	}
}
