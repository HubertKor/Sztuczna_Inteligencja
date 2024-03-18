package Zad3;

public class Zad3 {
    public static int minimax(int[] values, int depth, int index, boolean player, int alpha, int beta) {
        if (depth == 2) return values[index];
        int best;
        if (player) {
            best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                best = Math.max(best, minimax(values, depth + 1, index * 3 + i, false, alpha, beta));
                alpha = Math.max(alpha, best);
                if (beta <= alpha) break;
            }
        } else {
            best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                best = Math.min(best, minimax(values, depth + 1, index * 3 + i, true, alpha, beta));
                beta = Math.min(beta, best);
                if (beta <= alpha) break;
            }
        }
        return best;
    }
}
