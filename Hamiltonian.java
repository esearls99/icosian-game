import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        for (int i = 0; i < vertexOrder.length; i++) {
            int a = vertexOrder[i];
            Collections.shuffle(graph.adjListArray.get(a));
            if (graph.degree(a) > 2) {
                for (int j = 0; j < graph.degree(a); j++) {
                    int b = graph.adjListArray.get(a).get(0);
                    if (graph.degree(a) > 2 && graph.degree(b) > 2) {
                        graph.removeEdge(a, b);
                    }

                }
            }
        }
    }

    public void destroyer() {
        int[] remainders = this.findRemainders();
        int w = 1;
        destroyPath2(remainders[0], remainders[1], w);
        for (int i = 0; i < remainders.length; i++) {
            for (int j = i; j < remainders.length; j++) {
                if (remainders[i] != remainders[j]) {
                    // System.out.println(remainders[i] + " " + remainders[j]);
                    // destroyPath2(remainders[i], remainders[j], w);

                }
            }
        }

    }

    public int destroyPath(int x, int y, int w) {
        ArrayList<Integer> discovered = new ArrayList<Integer>();
        for (int e : graph.vertices[x].history) {
            discovered.add(x);
            int value = graph.areConnected(x, e);

            if (value == w) {
                System.out.println(x + " " + e);
                if (!discovered.contains(e)) {
                    if (value == 1 && w == 1 && y == e) {
                        System.out.println("toodles");
                        return 1;
                    } else if (value == w) {
                        if (destroyPath(e, y, 1 - w) == 1) {
                            System.out.println("yo");
                            if (w == 0)
                                graph.addEdge(x, e);
                            if (w == 1)
                                graph.removeEdge(x, e);
                            return 1;
                        } else
                            System.out.println("sup");
                        return 0;

                    } else if (value == 0 && e == y) {
                        System.out.println("hi");
                        return 0;
                    }

                }
            }
        }
        return -1;

    }

    public void destroyPath2(int x, int y, int w) {
        boolean[] isVisited = new boolean[30];
        ArrayList<Integer> pathList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();


        pathList.add(x);

        ArrayList<Integer> path = pathFinder(x, y, isVisited, pathList, w);
        System.out.println(path);
        //this.findInverse(path);
    }

    private ArrayList<Integer> pathFinder(Integer x, Integer y, boolean[] isVisited, ArrayList<Integer> path, int w) {
        isVisited[x] = true;

        for (Integer e : graph.vertices[x].history) {
            int value = graph.areConnected(x, e);
            if (value == w) {

                if (!isVisited[e]) {
                    path.add(e);
                    pathFinder(e, y, isVisited, path, 1 - w);
                    path.remove(e);
                }
            }
        }
        if (x.equals(y)) {
            System.out.println(path);
            return path;
        }
        
        return path;
    }

    private void findInverse(ArrayList<Integer> path) {
        int w = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            w = 1 - w;
            if (w == 0)
                graph.addEdge(path.get(i),path.get(i+1));
                
            else 
                graph.removeEdge(path.get(i),path.get(i+1));
                

        }
    }

    private int[] findRemainders() {
        int count = 0;
        for (int i = 0; i < graph.V; i++) {
            if (graph.degree(i) > 2) {
                count++;
            }
        }

        int[] remainders = new int[count];
        int j = 0;
        for (int i = 0; i < graph.V; i++) {
            if (graph.degree(i) > 2) {
                remainders[j] = i;
                j++;
            }
        }
        return remainders;

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