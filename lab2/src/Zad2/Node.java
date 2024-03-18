package Zad2;

public class Node{
    String board;
    Node prev;
    int g;
    int h;
    Node(String board, int g, int h, Node prev){
        this.board = board;
        this.prev = prev;
        this.g = g;
        this.h = h;
    }
}
