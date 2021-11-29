package racingcar.ui;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.InputValidation;

class InputViewTest {

    Scanner scanner;
    private final InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @ValueSource(strings = {"@@@@@@,!!!!!ss,asddas22"})
    void 자동차이름_사이즈가_5자이상일_경우_예외처리(String carName){
        InputStream in = generateInputStream(carName);
        System.setIn(in);
        scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner, inputValidation);

        assertThatThrownBy(() -> inputView.getCars())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(InputValidation.ERROR_CARNAME_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@","s"})
    void 숫자양식에_맞지않을경우_예외처리(String tryCount){
        InputStream in = generateInputStream(tryCount);
        System.setIn(in);
        scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner, inputValidation);

        assertThatThrownBy(() -> inputView.getTryCount())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(InputValidation.ERROR_NUMBER_FORMAT);
    }

    public static InputStream generateInputStream(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

}