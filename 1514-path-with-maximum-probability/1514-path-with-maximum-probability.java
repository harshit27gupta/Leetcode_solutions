import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return Double.compare(p2.cost, p1.cost); 
            }
        });     
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;     
        pq.offer(new Pair(start, 1.0));
              while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int vertex = current.vertex;
            double prob = current.cost;          
            if (vertex == end) {
                return prob;
            }       
            for (Pair neighbor : graph.get(vertex)) {
                double newProb = prob * neighbor.cost;
                if (newProb > maxProb[neighbor.vertex]) {
                    maxProb[neighbor.vertex] = newProb;
                    pq.offer(new Pair(neighbor.vertex, newProb));
                }
            }
        }
        
        return 0.0;
    }
    
    class Pair {
        int vertex;
        double cost;
        
        public Pair(int vertex, double cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
