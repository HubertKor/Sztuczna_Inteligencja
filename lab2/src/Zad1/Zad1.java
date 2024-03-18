package Zad1;

import java.util.*;

public class Zad1 {

    private static final String[] actions = {"MoveLeft", "MoveRight", "Suck"};

    public static String clean(boolean[] board, int start) {
        Set<State> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(board.clone(), start, -1, null));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                if (visited.contains(current)) continue;
                visited.add(current);
                if (current.isClean()) {
                    Stack<String> stack = new Stack<>();
                    while (current != null) {
                        stack.push(current.action == -1 ? "START" : actions[current.action]);
                        current = current.prev;
                    }
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) sb.append(stack.pop()).append(" -> ");
                    sb.append("DONE!");
                    return sb.toString();
                }
                if (current.position > 0) {
                    State temp = new State(current.board.clone(), current.position - 1, 0, current);
                    if (!visited.contains(temp)) queue.offer(temp);
                }
                if (current.position < current.board.length - 1) {
                    State temp = new State(current.board.clone(), current.position + 1, 1, current);
                    if (!visited.contains(temp)) queue.offer(temp);
                }
                if(!current.board[current.position]) {
                    boolean[] tempBoard = current.board.clone();
                    tempBoard[current.position] = true;
                    State temp = new State(tempBoard, current.position, 2, current);
                    if (!visited.contains(temp)) queue.offer(temp);
                }
            }
        }
        return "No solution found!";
    }

}

