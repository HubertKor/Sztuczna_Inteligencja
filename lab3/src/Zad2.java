import java.util.ArrayList;
import java.util.List;

public class Zad2 {
    static boolean isConsistent(Node node, int attr1, int value1, int attr2, int value2) {
        return node.attributes[attr1] == value1 && node.attributes[attr2] == value2;
    }

    // Funkcja wykonująca algorytm pokrywania sekwencyjnego
    static void sequentialCovering(List<Node> nodes) {
        List<String> rules = new ArrayList<>();

        // Sprawdzamy reguły pierwszego rzędu
        for (int attr1 = 0; attr1 < 6; attr1++) {
            for (int value1 = 1; value1 <= 4; value1++) {
                boolean foundRule = false;
                for (Node node : nodes) {
                    if (node.attributes[attr1] == value1) {
                        rules.add("(a" + (attr1 + 1) + " = " + value1 + ") => (d = " + node.decision + ")");
                        int finalAttr = attr1;
                        int finalValue = value1;
                        nodes.removeIf(n -> n.attributes[finalAttr] == finalValue && n.decision == node.decision);
                        foundRule = true;
                        break;
                    }
                }
                if (foundRule) break;
            }
        }

        // Sprawdzamy reguły drugiego rzędu
        for (int attr1 = 0; attr1 < 6; attr1++) {
            for (int value1 = 1; value1 <= 4; value1++) {
                for (int attr2 = attr1 + 1; attr2 < 6; attr2++) {
                    for (int value2 = 1; value2 <= 4; value2++) {
                        boolean foundRule = false;
                        for (Node node : nodes) {
                            if (isConsistent(node, attr1, value1, attr2, value2)) {
                                rules.add("(a" + (attr1 + 1) + " = " + value1 + ") ∧ (a" + (attr2 + 1) + " = " + value2 + ") => (d = " + node.decision + ")");
                                int finalAttr = attr1;
                                int finalValue = value1;
                                int finalAttr1 = attr2;
                                int finalValue1 = value2;
                                nodes.removeIf(n -> isConsistent(n, finalAttr, finalValue, finalAttr1, finalValue1) && n.decision == node.decision);
                                foundRule = true;
                                break;
                            }
                        }
                        if (foundRule) break;
                    }
                }
            }
        }

        // Wyświetlamy znalezione reguły
        for (String rule : rules) {
            System.out.println(rule);
        }
    }
}
