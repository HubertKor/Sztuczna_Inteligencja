package Zad1;

import java.util.Arrays;

public class State {
    boolean[] board;
    int position;
    int action;
    State prev;

    public State(boolean[] board, int position, int action, State prev) {
        this.board = board;
        this.position = position;
        this.action = action;
        this.prev = prev;
    }

    public boolean isClean(){
        for(boolean b : board) if(!b) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State other = (State) o;
        return Arrays.equals(board, other.board) && position == other.position && action == other.action;
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(board) + position + action;
    }
}
