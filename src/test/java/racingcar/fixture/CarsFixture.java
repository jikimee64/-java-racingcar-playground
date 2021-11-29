package racingcar.fixture;

import java.util.ArrayList;
import java.util.List;
import racingcar.domains.Car;
import racingcar.domains.Cars;

public class CarsFixture {

    public static Cars getPositionZeroCars(){
        List<Car> carsList = new ArrayList<>();
        carsList.add(Car.from("포르쉐"));
        carsList.add(Car.from("현대"));
        carsList.add(Car.from("기아"));
        return new Cars(carsList);
    }

    public static Cars getNoneDuplicationPositionCars(){
        List<Car> carsList2 = new ArrayList<>();
        carsList2.add(Car.from("포르쉐", 3));
        carsList2.add(Car.from("현대", 4) );
        carsList2.add(Car.from("기아", 5));
        return new Cars(carsList2);
    }

    public static Cars getDuplicationPositionCars(){
        List<Car> carsList3 = new ArrayList<>();
        carsList3.add(Car.from("포르쉐", 3));
        carsList3.add(Car.from("현대", 3) );
        carsList3.add(Car.from("기아", 2));
        return new Cars(carsList3);
    }

}