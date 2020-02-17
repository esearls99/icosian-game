
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph {
    int V;
    Vertex[] vertices;
    int[] cords;
    List<LinkedList<Integer>> adjListArray;

    public UndirectedGraph(int V) {
        this.V = V;
        vertices = new Vertex[V];
        cords = makeCords();
        

        adjListArray = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjListArray.add(new LinkedList<Integer>());
            
            
        }
        for (int i = 0; i < V; i++) {
            vertices[i] = new Vertex(i, cords[2 * i], cords[2 * i+1]);
        }
        
    }

    public int degree (int n) {
        return adjListArray.get(n).size();

    }

    public void removeEdge(int a, int b) {
        adjListArray.get(a).remove(Integer.valueOf(b));
        adjListArray.get(b).remove(Integer.valueOf(a));
    }

    private void addEdge(int a, int b) {
        adjListArray.get(a).add(b);
        adjListArray.get(b).add(a);
    }
    

    
    private static int[] makeCords (){ 
        int[] cords = {
            386,747,
            749,499,
            612,76,
            158,74,
            19,501,
            129,467,
            382,652,
            640,467,
            541,168,
            225,165,
            177,315,
            262,565,
            501,567,
            592,309,
            386,169,
            317,291,
            275,418,
            385,498,
            493,418,
            451,292};
            return cords;
    }

    public static void makeDodecahedron(UndirectedGraph graph) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 8);
        graph.addEdge(3, 4);
        graph.addEdge(3, 9);
        graph.addEdge(4, 5);
        graph.addEdge(5, 11);
        graph.addEdge(5, 10);
        graph.addEdge(6, 12);
        graph.addEdge(6, 11);
        graph.addEdge(7, 13);
        graph.addEdge(7, 12);
        graph.addEdge(8, 14);
        graph.addEdge(8, 13);
        graph.addEdge(9, 14);
        graph.addEdge(9, 10);
        graph.addEdge(10, 16);
        graph.addEdge(11, 17);
        graph.addEdge(12, 18);
        graph.addEdge(13, 19);
        graph.addEdge(14, 15);
        graph.addEdge(15, 19);
        graph.addEdge(15, 16);
        graph.addEdge(16, 17);
        graph.addEdge(17, 18);
        graph.addEdge(18, 19);
    }

    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("node");
            for (Integer node : adjListArray.get(i)) {
                System.out.print(" -> " + node);
            }
            System.out.println("\n");
        }
    }

    

    class Vertex {
        int v;
        int x;
        int y;

        public Vertex(int v, int x, int y) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

    }

}