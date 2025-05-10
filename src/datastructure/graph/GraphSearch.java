package datastructure.graph;

import java.util.*;

public class GraphSearch {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6;
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 무방향 그래프 간선 추가
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 6);

        System.out.println("DFS: ");
        dfs(1);

        System.out.println("\nBFS: ");
        bfs(1);

    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // 무방향
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for(int next : graph.get(node)) {
            if (!visited[next]) dfs(next);
        }
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

    }

}
