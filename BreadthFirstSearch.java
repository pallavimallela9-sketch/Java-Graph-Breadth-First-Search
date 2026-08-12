import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges:");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbor : graph.get(current)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        sc.close();
    }
}
