package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.Direction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private Integer x;
    private Integer y;
    private Direction direction;

    public String toString() {
        return String.format("%d %d %s", getX(), getY(), getDirection());
    }

    public Position(String position) {
        String[] positionList = position.split(" ");

        this.x = Integer.valueOf(positionList[0]);
        this.y = Integer.valueOf(positionList[1]);
        this.direction = Direction.valueOf(positionList[2]);
    }

}
