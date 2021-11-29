package racingcar;

import java.util.Random;
import racingcar.domains.Car;

public class RandomMoveImpl implements MoveCarStrategy {

    private static final int NUMBER_RANGE = 10;

    @Override
    public Car getCar(final Car car) {
        int randomNumber = new Random(NUMBER_RANGE).nextInt();
        car.checkMoveCondition(randomNumber);
        return car;
    }

}