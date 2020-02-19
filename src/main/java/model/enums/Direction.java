package model.enums;

import model.Position;

public enum Direction {
    N {
        @Override
        public Direction getRightDirection() {
            return E;
        }

        @Override
        public Direction getLeftDirection() {
            return W;
        }

        @Override
        public Position getForwardBackwardPosition(Position position) {
            position.setY(position.getY() + 1);
            return position;
        }

    }, E {
        @Override
        public Direction getRightDirection() {
            return S;
        }

        @Override
        public Direction getLeftDirection() {
            return N;
        }

        @Override
        public Position getForwardBackwardPosition(Position position) {
            position.setX(position.getX() + 1);
            return position;
        }

    }, W {
        @Override
        public Direction getRightDirection() {
            return N;
        }

        @Override
        public Direction getLeftDirection() {
            return S;
        }

        @Override
        public Position getForwardBackwardPosition(Position position) {
            position.setX(position.getX() - 1);
            return position;
        }

    }, S {
        @Override
        public Direction getRightDirection() {
            return W;
        }

        @Override
        public Direction getLeftDirection() {
            return E;
        }

        @Override
        public Position getForwardBackwardPosition(Position position) {
            position.setY(position.getY() - 1);
            return position;
        }
    };

    public abstract Direction getRightDirection();

    public abstract Direction getLeftDirection();

    public abstract Position getForwardBackwardPosition(Position position);

}
