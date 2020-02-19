import model.Position;
import model.Rover;
import model.enums.RoverAction;

import java.util.List;

public class RoverApp {

    public static void main(String[] args) {
        new RoverApp();
    }

    public RoverApp() {
        Position position = new Position("3 3 E");

        Position expectedFinalPosition = new Position("5 1 E");

        List<RoverAction> actionSet = RoverAction.parse("MMRMMRMRRM");

        Rover moulaye = new Rover(position, "Moulaye");
        moulaye.addActionSet(actionSet);

        System.out.println(String.format("Executing instructions for Rover named %s", moulaye.getName()));
        System.out.println(String.format("Initial position %s", moulaye.getPosition().toString()));
        System.out.println(String.format("Expected final position : %s", expectedFinalPosition));

        moulaye.executeInstructions();


    }
}
