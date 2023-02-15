package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimpleStackQueue {
    public static void main(String[] args) {
        String[] data = {"four", "score", "and", "seven", "years", "ago"};
        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();

        for (String str : data) {
            q.add(str);
            s.push(str);
        }
        System.out.println("Initial queue = " + q);
        while (!q.isEmpty()) {
            String str = q.remove();
            System.out.println("removing " + str + " queue is now: " + q);
        }
        System.out.println();

        System.out.println("Initial stack = " + s);
        while (!s.isEmpty()) {
            String str = s.pop();
            System.out.println("removing " + str + " stack is now: " + s);
        }
    }

}
