package racingcar;

import racingcar.domains.Car;

public interface MoveCarStrategy {
    Car getCar(Car car);
}