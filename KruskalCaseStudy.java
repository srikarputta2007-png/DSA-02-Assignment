import java.util.*;

public class KruskalCaseStudy {

    static class Edge implements Comparable<Edge> {
        String src, dest;
        int weight;

        Edge(String s, String d, int w) {
            src = s;
            dest = d;
            weight = w;
        }

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) {

        Edge[] edges = {
                new Edge("A", "C", 2),
                new Edge("B", "D", 3),
                new Edge("C", "D", 4),
                new Edge("D", "E", 5),
                new Edge("E", "F", 6),
                new Edge("A", "B", 7),
                new Edge("A", "D", 8),
                new Edge("B", "C", 9),
                new Edge("C", "E", 10)
        };

        Arrays.sort(edges);

        int totalCost = 0;

        System.out.println("Selected MST Edges:");

        for (int i = 0; i < 5; i++) {
            System.out.println(edges[i].src + " - "
                    + edges[i].dest + " = "
                    + edges[i].weight);
            totalCost += edges[i].weight;
        }

        System.out.println("Minimum Cost = " + totalCost);
    }
}
