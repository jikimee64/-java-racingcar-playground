package racingcar.domains;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 숫자4_이상일경우_자동차_위치_증가() {
        //given
        Car car = new Car("쉐보레", 0);
        int number = 4;

        Car car2 = new Car("현대", 0);
        int number2 = 6;

        //when
        car.checkMoveCondition(number);
        car.checkMoveCondition(number);

        car2.checkMoveCondition(number2);
        car2.checkMoveCondition(number2);
        car2.checkMoveCondition(number2);

        //then
        assertThat(car.getPosition()).isEqualTo(2);
        assertThat(car2.getPosition()).isEqualTo(3);

    }

    @Test
    void 숫자4_미만일경우_자동차_위치_변화없음() {

        Car car = new Car("기아", 0);
        int number = 1;

        Car car2 = new Car("폭스바겐", 0);
        int number2 = 3;

        car.checkMoveCondition(number);

        car2.checkMoveCondition(number2);
        car2.checkMoveCondition(number2);

        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);

    }

    @Test
    void 자동차_객체_리스트_반환(){
        String[] carsName = {"포르쉐", "현대", "기아"};
        List<Car> cars = Car.listFrom(carsName);

        assertThat(cars.size()).isEqualTo(3);
        for(int i = 0; i < carsName.length; i++){
            assertThat(cars.get(i).getName()).isEqualTo(carsName[i]);
        }

    }

}