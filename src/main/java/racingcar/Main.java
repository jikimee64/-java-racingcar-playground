package racingcar;

import java.util.Scanner;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in), new InputValidation());

        String[] cars = inputView.getCars();
        int tryCount = inputView.getTryCount();

        RacingGame racingGame = new RacingGame(cars, tryCount);
        racingGame.process(new RandomMoveImpl());

        //ResultView resultView = new ResultView();


    }
}
