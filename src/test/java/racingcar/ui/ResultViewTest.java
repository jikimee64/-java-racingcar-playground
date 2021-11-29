package racingcar.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.WindowConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domains.Car;
import racingcar.domains.Cars;
import racingcar.domains.WinnerCars;

class ResultViewTest {

    Cars cars;

    Cars cars2;

    ResultView resultView;

    @BeforeEach
    public void init() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(Car.from("포르쉐", 1));
        carsList.add(Car.from("현대", 2));
        carsList.add(Car.from("기아", 3));
        cars = new Cars(carsList);

        List<Car> carsList2 = new ArrayList<>();
        carsList2.add(Car.from("포르쉐", 3));
        carsList2.add(Car.from("현대", 4));
        carsList2.add(Car.from("기아", 4));
        cars2 = new Cars(carsList2);

        resultView = new ResultView();
    }

    @Test
    void 자동차_경주상황_출력() {
        //given
        resultView.comparePosition(cars);
        String expectedResult = "포르쉐 : -\n" + "현대 : --\n" + "기아 : ---\n\n";

        //when
        String assertResult = resultView.getStringBuilder().toString();

        //then
        assertThat(assertResult).isEqualTo(expectedResult);
    }

    @Test
    void 최종우승자_출력() {
        //given
        List<Car> winnerCar2 = cars2.winnerCar();
        WinnerCars winnerCars2 = new WinnerCars(winnerCar2);
        String expectedResult = "현대, 기아가 최종 우승했습니다.";

        //when
        resultView.resultWinner(winnerCars2);
        String assertResult = resultView.getStringBuilder().toString();

        //then
        assertThat(assertResult).isEqualTo(expectedResult);

    }

}