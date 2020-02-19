package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.RoverAction;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rover {
    private Position position;
    private String name;
    private List<List<RoverAction>> actionSets = new ArrayList<>();

    public Rover(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public void executeInstructions() {

        actionSets.forEach(set -> set.forEach(action -> {
            Position newPosition = action.execute(getPosition());
            setPosition(newPosition);
        }));

        System.out.println(String.format("Final position %s", getPosition().toString()));

    }

    public void addActionSet(List<RoverAction> actionSet) {
        actionSets.add(actionSet);
    }
}
