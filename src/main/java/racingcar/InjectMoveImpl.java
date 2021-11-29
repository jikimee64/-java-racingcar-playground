package racingcar;

import racingcar.domains.Car;

public class InjectMoveImpl implements MoveCarStrategy {

    final int number;

    public InjectMoveImpl(final int number) {
        this.number = number;
    }

    @Override
    public Car getCar(final Car car) {
        car.checkMoveCondition(number);
        return car;
    }

}