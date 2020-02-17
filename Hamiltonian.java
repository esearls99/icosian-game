import java.util.Random;

public class Hamiltonian {
    UndirectedGraph graph;

    public Hamiltonian(UndirectedGraph graph) {
        this.graph = graph;
    }

    public void surplusRemoval() {
        int[] vertexOrder = new int[20];
        for (int i = 0; i < vertexOrder.length; i++)
            vertexOrder[i] = i;
        shuffleArray(vertexOrder);
        
    }

    private static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }
}