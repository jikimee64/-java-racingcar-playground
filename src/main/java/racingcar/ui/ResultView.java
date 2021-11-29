package racingcar.ui;

import java.util.List;
import racingcar.domains.Cars;
import racingcar.domains.WinnerCars;

public class ResultView {

    public static final String INPUT_COUNTS = "실행결과";

    private final StringBuilder stringBuilder = new StringBuilder();

    public ResultView() {
        System.out.println("\n" + INPUT_COUNTS);
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void comparePosition(Cars cars) {
        cars.getCars().forEach(car -> {
            stringBuilder.append(car.getName()).append(" : ").append(replaceNumberToString(
                    car.getPosition()))
                .append("\n");
        });
        stringBuilder.append("\n");
    }

    public void resultWinner(WinnerCars winnerCars) {
        List<String> carsName = winnerCars.getCarsName();
        int size = carsName.size();
        for (int i = 0; i < size; i++) {
            commaDivision(i, size, carsName.get(i));
        }
        stringBuilder.append("가 최종 우승했습니다.");
    }

    private StringBuilder commaDivision(int index, int size, String carName) {
        if (size - 1 == index) {
            return stringBuilder.append(carName);
        }
        return stringBuilder.append(carName).append(", ");
    }

    private String replaceNumberToString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}