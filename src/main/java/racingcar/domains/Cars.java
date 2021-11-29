package racingcar.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.MoveCarStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> racingCars(final MoveCarStrategy moveCarStrategy){
        return cars.stream()
            .map(car -> moveCarStrategy.getCar(car))
            .collect(Collectors.toList());
    }

    public List<Car> winnerCar(){
        return cars.stream()
            .filter(car -> car.getPosition() == getMaxPosition())
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return this.cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .map(car -> car.getPosition())
            .get();
    }

}