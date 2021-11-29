package racingcar.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {
    private List<Car> cars;

    public WinnerCars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getCarsName(){
        return cars.stream()
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }

}