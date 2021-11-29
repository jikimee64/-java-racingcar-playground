package racingcar;

import java.util.List;
import racingcar.domains.Car;
import racingcar.domains.Cars;

public class RacingGame {

    final String[] carsName ;
    final int tryCount;

    public RacingGame(final String[] carsName, final int tryCount) {
        this.carsName = carsName;
        this.tryCount = tryCount;
    }

    public void process(MoveCarStrategy randomMove){
        //자동차 세팅
        Cars cars = new Cars();
        cars.addCars(carsName);

        //레이싱
        for(int i = 0; i < tryCount; i++){
            List<Car> carsList = cars.racingCars(randomMove);
            //ResultView 출력
        }

        //승자 추출

    }

};