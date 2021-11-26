package racingcar.ui;

import java.util.Scanner;
import racingcar.InputValidation;

public class InputView {

    final Scanner scanner;
    final InputValidation inputValidation;
    public static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_COUNTS = "시도할 회수는 몇회인가요?";

    public InputView(final Scanner scanner, final InputValidation inputValidation) {
        this.scanner = scanner;
        this.inputValidation = inputValidation;
    }

    public void println(String text) {
        System.out.println(text);
    }

    public String[] getCars() {
        println(INPUT_CARS);
        return inputValidation.validCarNameSize(scanner);
    }

    public int getTryCount() {
        println(INPUT_COUNTS);
        return inputValidation.validNumberFormat(scanner);
    }

}