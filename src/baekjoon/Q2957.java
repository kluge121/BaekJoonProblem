package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2957 {


    static int c = 0;
    static Node root = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        root = new Node(sc.nextInt());


        for (int i = 0; i < n - 1; i++) {
            insert(sc.nextInt(), root);
        }


    }


    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private static void insert(int value, Node node) {
        c++;
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                System.out.println(c);
            } else {
                insert(value, node.left);
            }
        } else if (node.value < value) {
            if (node.right == null) {
                node.right = new Node(value);
                System.out.println(c);
            } else {
                insert(value, node.right);
            }
        }


    }
}