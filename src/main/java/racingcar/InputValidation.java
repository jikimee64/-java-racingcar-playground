package racingcar;

import java.util.Scanner;

public class InputValidation {

    public static final String ERROR_CARNAME_SIZE = "자동차 이름은 5자를 초과할 수 없습니다.";
    public static final String ERROR_NUMBER_FORMAT = "시도 횟수는 숫자 형식으로 입력해주세요.";
    public static final int CARNAME_SIZE_RESTRICE = 5;
    public static final String DEFAULT_DELIMITER = ",";

    public int validNumberFormat(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
        }
    }

    public String[] validCarNameSize(Scanner scanner) {
        String[] carNames = scanner.nextLine().split(DEFAULT_DELIMITER);
        for (String carName : carNames) {
            if(carName.length() > CARNAME_SIZE_RESTRICE){
                throw new IllegalArgumentException(ERROR_CARNAME_SIZE);
            }
        }
        return carNames;
    }

}