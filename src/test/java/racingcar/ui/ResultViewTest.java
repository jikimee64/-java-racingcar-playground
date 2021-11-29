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
import racingcar.fixture.CarsFixture;

class ResultViewTest {

    Cars cars;
    Cars cars2;
    ResultView resultView;

    @BeforeEach
    public void init() {
        cars = CarsFixture.getNoneDuplicationPositionCars();
        cars2 = CarsFixture.getDuplicationPositionCars();
        resultView = new ResultView();
    }

    @Test
    void 자동차_경주상황_출력() {
        //given
        resultView.comparePosition(cars);
        String expectedResult = "포르쉐 : ---\n" + "현대 : ----\n" + "기아 : -----\n\n";

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
        String expectedResult = "포르쉐, 현대가 최종 우승했습니다.";

        //when
        resultView.resultWinner(winnerCars2);
        String assertResult = resultView.getStringBuilder().toString();

        //then
        assertThat(assertResult).isEqualTo(expectedResult);

    }

}