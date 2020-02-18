import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Hamiltonian {
    UndirectedGraph graph;
    ArrayList<ArrayList<Integer>> paths;
    Stack<Integer> connectionPath = new Stack<Integer>();
    List<Stack<Integer>> connectionPaths = new ArrayList<>();

    public Hamiltonian(UndirectedGraph graph) {
        paths = new ArrayList<ArrayList<Integer>>();

        this.graph = graph;
    }

    public ArrayList<Integer> mainHamiltonian() {
        Random rand = new Random();
        int x = rand.nextInt(20);
        int tmp = rand.nextInt(3);
        int y = graph.adjListArray.get(x).get(tmp);
        
        this.findAllPaths(x, y);
        this.stackToLists(x, y);
        ArrayList<Integer> list = this.choosePath();

        return list;
    }

    public void stackToLists(int x, int y) {
        for (Stack<Integer> i : connectionPaths) {
            ArrayList<Integer> list = new ArrayList<Integer>(i);
            paths.add(list);
        }
        for (int i = 0; i < paths.size(); i++) {
            paths.get(i).add(0,x);
            paths.get(i).add(y);
        }
    }

    public ArrayList<Integer> choosePath (){

        for(int i = 0; i < paths.size(); i++) {
            if (isHamiltonian(paths.get(i)) == true) {
                return paths.get(i);
            }
        }
        return null;
    }

    private boolean isHamiltonian (ArrayList<Integer> path) {
        if (path.size() == 20 && isAcyclicPath(path)) {
            return true;
        }
        else 
            return false;
    }

    public boolean isAcyclicPath (ArrayList<Integer> path) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < path.size(); i ++) {
            if(!list.contains(path.get(i)))
            list.add(path.get(i));
        }
        if (list.equals(path)) {
            return true;
        }
        else
            return false;
    }

    void findAllPaths(int x, int y) {
        for (int e : graph.adjListArray.get(x)) {
            if (e == y) {
                Stack<Integer> temp = new Stack<Integer>();
                for (int node : connectionPath)
                    temp.add(node);
                connectionPaths.add(temp);
            } else if (!connectionPath.contains(e)) {
                connectionPath.push(e);
                findAllPaths(e, y);
                connectionPath.pop();
            }
        }
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