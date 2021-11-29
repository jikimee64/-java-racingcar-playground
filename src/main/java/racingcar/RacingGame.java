package racingcar;

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
        Cars cars = new Cars(Car.listFrom(carsName));

        //레이싱
        for(int i = 0; i < tryCount; i++){
            cars.racingCars(randomMove);
            //ResultView 출력
        }

        //승자 추출

    }

}