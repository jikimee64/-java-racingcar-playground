package racingcar;

import java.util.List;
import racingcar.domains.Car;
import racingcar.domains.Cars;
import racingcar.domains.WinnerCars;
import racingcar.ui.ResultView;

public class RacingGame {

    final String[] carsName ;
    final int tryCount;

    public RacingGame(final String[] carsName, final int tryCount) {
        this.carsName = carsName;
        this.tryCount = tryCount;
    }

    public ResultView process(MoveCarStrategy randomMove){
        Cars cars = new Cars(Car.listFrom(carsName));

        ResultView resultView = new ResultView();
        resultView.comparePosition(cars);
        for(int i = 0; i < tryCount; i++){
            cars.racingCars(randomMove);
            resultView.comparePosition(cars);
        }

        List<Car> winnerCarList = cars.winnerCar();
        WinnerCars winnerCars = new WinnerCars(winnerCarList);
        resultView.resultWinner(winnerCars);
        return resultView;
    }

}