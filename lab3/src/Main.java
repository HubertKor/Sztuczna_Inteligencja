import Strategies.NotEqual;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] domena = new String[3][];
        domena[0] = new String[]{"R", "G", "B"};
        domena[1] = new String[]{"R"};
        domena[2] = new String[]{"G"};
        List<List<String>> list = Zad1.findListOfNotDuplicatedComponents(domena, new NotEqual());
        System.out.println("Zad1:");
        for (List<String> l : list) {
            System.out.print("X1 = " + l.get(0) + ", X2 = " + l.get(1) + ", X3 = " + l.get(2));
            System.out.println();
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(new int[]{1, 1, 1, 1, 1, 1}, 1));
        nodes.add(new Node(new int[]{1, 1, 1, 2, 1, 2}, 1));
        nodes.add(new Node(new int[]{1, 2, 1, 2, 2, 1}, 0));
        nodes.add(new Node(new int[]{2, 2, 1, 2, 1, 2}, 1));
        nodes.add(new Node(new int[]{2, 2, 2, 1, 2, 1}, 0));
        nodes.add(new Node(new int[]{2, 3, 2, 2, 3, 2}, 0));
        nodes.add(new Node(new int[]{3, 3, 2, 2, 3, 1}, 0));
        nodes.add(new Node(new int[]{3, 4, 2, 1, 4, 2}, 1));
        System.out.println("Zad2:");
        Zad2.sequentialCovering(nodes);
    }
}