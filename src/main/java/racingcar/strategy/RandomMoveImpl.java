package racingcar.strategy;

import racingcar.domains.Car;

public class RandomMoveImpl implements MoveCarStrategy {

    private static final int NUMBER_RANGE = 10;

    @Override
    public Car getCar(final Car car) {
        int randomNumber = (int)(Math.random() * 10);
        car.checkMoveCondition(randomNumber);
        return car;
    }

}