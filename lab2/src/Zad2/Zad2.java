package Zad2;

import java.util.*;

public class Zad2 {
    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void slidingPuzzle(int[][] board) {
        Node last = slide(board);
        if (last == null) {
            System.out.println("Not possible");
            return;
        }
        Stack<String> steps = new Stack<>();
        while (last != null) {
            steps.push(last.board);
            last = last.prev;
        }
        while (!steps.isEmpty()) {
            char[] current = steps.pop().toCharArray();
            System.out.println(current[0] + " | " + current[1] + " | " + current[2]);
            System.out.println("---------");
            System.out.println(current[3] + " | " + current[4] + " | " + current[5]);
            System.out.println("---------");
            System.out.println(current[6] + " | " + current[7] + " | " + current[8]);
            System.out.println();
        }
    }

    private static Node slide(int[][] board) {
        String startBoard = getBoard(board);
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.g + a.h, b.g + b.h));
        queue.offer(new Node(startBoard, 0, -1, null));
        visited.add(startBoard);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.h == 0) return current;
            getNextBoard(current, visited, queue);
        }
        return null;
    }

    private static void getNextBoard(Node prev, Set<String> visited, Queue<Node> queue) {
        int emptyIndex = prev.board.indexOf('0');
        int emptyRow = emptyIndex / 3;
        int emptyCol = emptyIndex % 3;
        for (int[] move : moves) {
            int newRow = emptyRow + move[0];
            int newCol = emptyCol + move[1];
            if (newRow < 0 || newRow >= 3 || newCol < 0 || newCol >= 3) continue;
            int newIndex = newRow * 3 + newCol;
            char[] temp = prev.board.toCharArray();
            temp[emptyIndex] = temp[newIndex];
            temp[newIndex] = '0';
            String newBoard = new String(temp);
            if (!visited.contains(newBoard)) {
                int h = h(temp);
                visited.add(newBoard);
                queue.offer(new Node(newBoard, prev.g + 1, h, prev));
            }
        }
    }

    private static int h(char[] board){
        int[][] correct = {{2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}};
        int h = 0;
        for (int i = 0; i < 9; i++) {
            int value = board[i] - '0';
            int x = i / 3;
            int y = i % 3;
            h += (Math.abs(x - correct[value][0]) + Math.abs(y - correct[value][1]));
        }
        return h;
    }
    private static String getBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board)
            for (int col : row) sb.append(col);
        return sb.toString();
    }
}
