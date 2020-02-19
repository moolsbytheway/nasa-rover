package model.enums;

import model.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum RoverAction {
    SPIN_RIGHT {
        @Override
        public String getValue() {
            return "R";
        }
    },
    SPIN_LEFT {
        @Override
        public String getValue() {
            return "L";
        }
    },
    MOVE_FORWARD {
        @Override
        public String getValue() {
            return "M";
        }

        @Override
        public Position execute(Position currentPosition) {
            return currentPosition.getDirection().getForwardBackwardPosition(currentPosition);
        }
    };

    public abstract String getValue();


    public Position execute(Position currentPosition) {
        Direction nextDirection = null;

        if (RoverAction.SPIN_RIGHT.equals(this)) {
            nextDirection = currentPosition.getDirection().getRightDirection();
        } else if (RoverAction.SPIN_LEFT.equals(this)) {
            nextDirection = currentPosition.getDirection().getLeftDirection();
        }

        if (nextDirection == null) throw new IllegalStateException("Couldn't get next direction");

        currentPosition.setDirection(nextDirection);
        return currentPosition;

    }

    public static List<RoverAction> parse(String actionsString) {

        List<String> actionsList = new ArrayList<>();

        for (char ch : actionsString.toCharArray()) {
            actionsList.add(String.valueOf(ch));
        }

        List<RoverAction> actions = new ArrayList<>();

        actionsList.forEach(actionString -> {
            Optional<RoverAction> action = Arrays.stream(RoverAction.values())
                    .filter(a -> actionString.equals(a.getValue())).findFirst();
            action.ifPresent(actions::add);
        });

        return actions;

    }

}
