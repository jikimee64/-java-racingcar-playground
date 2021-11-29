package racingcar.domains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.MoveCarStrategy;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void addCars(String[] carsName){
        for (String carName : carsName) {
            cars.add(Car.from(carName));
        }
    }

    public List<Car> racingCars(MoveCarStrategy moveCarStrategy){
        return cars.stream()
            .map(car -> moveCarStrategy.getCar(car))
            .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .map(car -> car.getPosition())
            .get();
    }

}