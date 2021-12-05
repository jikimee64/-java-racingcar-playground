package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.util.StringUtils;

public class RacingGame {
    private final List<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        this.cars = initCars(carNames);
        this.tryNo = tryNo;
    }

    private static List<Car> initCars(String carNames){
        if(!StringUtils.hasText(carNames)){
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : names){
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race(){
        this.tryNo--;
        moveCars();
    }

//    private void moveCars2(){
//        for(Car car : cars){
//            car.move();
//        }
//    }

    private void moveCars(){
        for(Car car : cars){
            car.move(new RandomMovingStrategy());
        }
    }

    public boolean racing(){
        return this.tryNo > 0;
    }
    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

}