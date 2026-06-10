public class DijkstraCaseStudy {

    static final int V = 6;

    int minDistance(int dist[], boolean visited[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void dijkstra(int graph[][], int src) {

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])

                    dist[v] = dist[u] + graph[u][v];
            }
        }

        char places[] = {'A','B','C','D','E','F'};

        System.out.println("Shortest Distances:");

        for (int i = 0; i < V; i++)
            System.out.println("A -> " + places[i] + " = " + dist[i]);
    }

    public static void main(String[] args) {

        int graph[][] = {
                {0,4,2,0,0,0},
                {4,0,5,10,0,0},
                {2,5,0,0,3,0},
                {0,10,0,0,0,4},
                {0,0,3,0,0,2},
                {0,0,0,4,2,0}
        };

        new DijkstraCaseStudy().dijkstra(graph,0);
    }
}
