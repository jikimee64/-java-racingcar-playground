package racinggame.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    //private final String name;
//    private int position = 0;
    private Position position2;
    private final Name name;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position2 = new Position(position);
    }

    public Position getPosition2() {
        return position2;
    }

    //    public String getName() {
//        return name;
//    }

//    public int getPosition() {
//        return position;
//    }

    public void move(MovingStrategy movingStrategy){
        if(movingStrategy.movable()){
            position2 = position2.move();
            //this.position++;
        }
    }

    public void move(int randomNo){
        if(randomNo >= FORWARD_NUM){
            position2 = position2.move();
            //this.position++;
        }
    }

//    public void move(){
//        if(getRandomNo() >= FORWARD_NUM){
//            this.position++;
//        }
//    }

    public boolean isWinner(Position maxPosition){
        return position2.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
         if(position2.lessThan(maxPosition)){
             return maxPosition;
         }
        return this.position2;
    }

    //랜덤값을 외부에서 변경할 수 있어야 테스트 가능함(private)
    protected int getRandomNo(){
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(position2, car.position2) && Objects.equals(name,
            car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position2, name);
    }


}