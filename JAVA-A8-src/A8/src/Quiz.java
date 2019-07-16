import java.util.*;

public class Quiz {

	double m_randomNumber1;
	double m_randomNumber2;
	List<Double> m_userAnswers;

	// Default constructor
	Quiz() {
		m_randomNumber1 = 0.0;
		m_randomNumber2 = 0.0;
		m_userAnswers = new ArrayList<Double>();
	}

	// setter methods
	void setRandomNumber1(int number) {
		m_randomNumber1 = number;
	}

	void setRandomNumber2(int number) {
		m_randomNumber2 = number;
	}

	void setUserAnswers(double add, double sub, double mult, double div) {
		m_userAnswers.add(add);
		m_userAnswers.add(sub);
		m_userAnswers.add(mult);
		m_userAnswers.add(div);
	}

	// getter methods
	double getRandomNumber1() {
		return m_randomNumber1;
	}

	double getRandomNumber2() {
		return m_randomNumber2;
	}

	double getUserAnswers(String calculation) {
		double answer = 0.0;
		if (calculation == "add") {
			answer = m_userAnswers.get(0);
		}
		if (calculation == "sub") {
			answer = m_userAnswers.get(1);
		}
		if (calculation == "mult") {
			answer = m_userAnswers.get(2);
		}
		if (calculation == "div") {	
			answer = m_userAnswers.get(3);
//			System.out.printf("getuseranswet() " + (m_userAnswers.get(3))+ "\n");
		}
		return answer;
	}

	// methods
	// generates a random number between 1 and 5
	void generateRandomNumber() {
		setRandomNumber1((int) (Math.random() * (4 - 1 + 1)) + 1);
		setRandomNumber2((int) (Math.random() * (4 - 1 + 1)) + 1);
		m_userAnswers.clear();
		
	}

	double add() {
		return getRandomNumber1() + getRandomNumber2();
	}

	double subtract() {
		return getRandomNumber1() - getRandomNumber2();
	}

	double multiply() {
		return getRandomNumber1() * getRandomNumber2();
	}

	double divide() {
//		System.out.printf("divide() " + (Math.round((getRandomNumber1() / getRandomNumber2()) * 100.0) / 100.0)+ "\n");
		return Math.round((getRandomNumber1() / getRandomNumber2()) * 100.0) / 100.0;
	}

	int getResults() {
		int correct = 0;
		if (add() == getUserAnswers("add")) {
			correct++;
		}
		if (subtract() == getUserAnswers("sub")) {
			correct++;
		}
		if (multiply() == getUserAnswers("mult")) {
			correct++;
		}
		if (divide() == getUserAnswers("div")) {
			correct++;
		}
		return correct;
	}
}
