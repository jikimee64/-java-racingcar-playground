package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void findWinners() {
        //배드 스멜
//        Car car = new Car("pobi", 2);
//        car.move(4);
//        car.move(4);
//
//        Car car2 = new Car("crong");
//        car2.move(4);
//        car2.move(4);
//
//        Car car3 = new Car("crong");
//        car3.move(4);

        Car car = new Car("pobi", 2);
        Car car2 = new Car("crong", 2);
        Car car3 = new Car("crong", 1);

        List<Car> original = Arrays.asList(car, car2, car3);
        Cars cars = new Cars(original);
        assertThat(cars.findWinners()).contains(car, car2);

    }
}