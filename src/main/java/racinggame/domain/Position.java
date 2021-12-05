package racinggame.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if(position < 0){
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    //cqrs 원칙 어김,but 이게 틀린건 아님
    //하지만 정답은 없다. 본인 기준에 따라 핼하
    public Position move2(){
        position = position + 1;
        return this;
    }

    public Position move(){
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public boolean lessThan(Position maxPosition) {
        return false;
    }

}