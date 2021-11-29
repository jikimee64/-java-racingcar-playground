package racingcar.domains;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.strategy.InjectMoveImpl;
import racingcar.strategy.MoveCarStrategy;
import racingcar.fixture.CarsFixture;

class CarsTest {

    Cars cars;
    Cars cars2;
    Cars cars3;

    @BeforeEach
    public void init(){
        cars = CarsFixture.getPositionZeroCars();
        cars2 = CarsFixture.getNoneDuplicationPositionCars();
        cars3 = CarsFixture.getDuplicationPositionCars();
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
            assertThat(cars.get(i).getPosition()).isEqualTo(1);
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
            assertThat(cars.get(i).getPosition()).isEqualTo(4);
        }

    }

    @Test
    void 자동차_우승자(){

        List<Car> winnerCar2 = cars2.winnerCar();

        List<Car> winnerCar3 = cars3.winnerCar();

        assertThat(winnerCar2.get(0).getName()).isEqualTo("기아");
        assertThat(winnerCar2.get(0).getPosition()).isEqualTo(5);

        assertThat(winnerCar3.get(0).getName()).isEqualTo("포르쉐");
        assertThat(winnerCar3.get(0).getPosition()).isEqualTo(3);
        assertThat(winnerCar3.get(1).getName()).isEqualTo("현대");
        assertThat(winnerCar3.get(1).getPosition()).isEqualTo(3);
    }

}