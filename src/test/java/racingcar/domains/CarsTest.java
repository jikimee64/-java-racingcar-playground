package racingcar.domains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.InjectMoveImpl;
import racingcar.MoveCarStrategy;

class CarsTest {

    Cars cars;

    Cars cars2;

    @BeforeEach
    public void init(){
        List<Car> carsList = new ArrayList<>();
        carsList.add(Car.from("포르쉐"));
        carsList.add(Car.from("현대"));
        carsList.add(Car.from("기아"));
        cars = new Cars(carsList);

        List<Car> carsList2 = new ArrayList<>();
        carsList2.add(Car.from("포르쉐", 1));
        carsList2.add(Car.from("현대", 3));
        carsList2.add(Car.from("기아", 5));
        cars2 = new Cars(carsList2);
    }

    @Test
    void 자동차_레이싱_시작_4미만일경우_움직임_없음() {
        int tryCount = 3;
        MoveCarStrategy moveCarStrategy = new InjectMoveImpl(3);


        for(int i = 0; i < tryCount; i++){
            this.cars.racingCars(moveCarStrategy);
        }

        List<Car> cars = this.cars.getCars();

        for(int i = 0; i < cars.size(); i++){
            assertThat(cars.get(i).getPosition()).isEqualTo(0);
        }

    }

    @Test
    void 자동차_레이싱_시작_4이상일경우_움직임() {
        int tryCount = 3;
        MoveCarStrategy moveCarStrategy = new InjectMoveImpl(4);

        for(int i = 0; i < tryCount; i++){
            this.cars.racingCars(moveCarStrategy);
        }

        List<Car> cars = this.cars.getCars();

        for(int i = 0; i < cars.size(); i++){
            assertThat(cars.get(i).getPosition()).isEqualTo(3);
        }

    }

    @Test
    void 자동차_레이싱후_가장높은_위치값_추출() {
        int maxPosition = cars2.getMaxPosition();

        assertThat(maxPosition).isEqualTo(5);
    }

}