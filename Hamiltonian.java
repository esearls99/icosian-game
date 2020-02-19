import java.util.ArrayList;
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

    public ArrayList<Integer> mainHamiltonian() { // run all the methods. pick a point and one of its neighbors
        Random rand = new Random();
        int x = rand.nextInt(20);
        int tmp = rand.nextInt(3);
        int y = graph.adjListArray.get(x).get(tmp);
        
        this.findAllPaths(x, y);
        this.stackToLists(x, y);
        ArrayList<Integer> list = this.choosePath();

        return list;
    }

    private void stackToLists(int x, int y) { //converts my paths to array lists. adds the starting and terminal vertices
        for (Stack<Integer> i : connectionPaths) {
            ArrayList<Integer> list = new ArrayList<Integer>(i);
            paths.add(list);
        }
        for (int i = 0; i < paths.size(); i++) {
            paths.get(i).add(0,x);
            paths.get(i).add(y);
        }
    }

    private ArrayList<Integer> choosePath (){ //picks a hamiltonian path out of all the possible paths

        for(int i = 0; i < paths.size(); i++) {
            if (isHamiltonian(paths.get(i)) == true) {
                return paths.get(i);
            }
        }
        return null;
    }

    private boolean isHamiltonian (ArrayList<Integer> path) {
        if (path.size() == 20 && noBackTrack(path)) {
            return true;
        }
        else 
            return false;
    }

    private boolean noBackTrack (ArrayList<Integer> path) { //makes sure a path doesn't have any repeating vertices
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

    private void findAllPaths(int x, int y) { //main depth first seach. finds all paths between two vertices
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
}