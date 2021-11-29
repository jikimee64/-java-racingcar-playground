package racingcar.domains;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int MOVE_CONDITION = 4;

    private String name;
    private int position;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void checkMoveCondition(int number) {
        if (number >= MOVE_CONDITION) {
            this.position += 1;
        }
    }

    public static Car from(final String name) {
        return new Car(name, 0);
    }

    public static Car from(final String name, int position) {
        return new Car(name, position);
    }

    public static List<Car> listFrom(String[] carsName) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carsName) {
            cars.add(Car.from(carName));
        }
        return cars;
    }

}