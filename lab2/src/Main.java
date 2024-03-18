import Zad1.Zad1;
import Zad2.Zad2;
import Zad3.Zad3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zad1");
        System.out.println(Zad1.clean(new boolean[]{true,false,false,true,false,true,true,false},3));
        System.out.println("Zad2");
        Zad2.slidingPuzzle(new int[][]{
                            {7,2,4},
                            {5,0,6},
                            {8,3,1}
        });
        System.out.println("Zad3");
        System.out.println(Zad3.minimax(
                new int[]{3,12,8,2,4,6,14,5,2},
                0, 0, true,
                Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}