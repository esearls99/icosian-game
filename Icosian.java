
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Icosian {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(20);
        UndirectedGraph.makeDodecahedron(graph);

        JFrame frame = new JFrame("Icosian Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GraphDrawer(graph));
        frame.pack();
        frame.setVisible(true);
    }
}

class GraphDrawer extends JPanel {
    private UndirectedGraph graph;
    public static final int BOX_WIDTH = 768;
    public static final int BOX_HEIGHT = 768;

    public GraphDrawer(UndirectedGraph graph) {
        this.graph = graph;
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }


    @Override
    public void paintComponent(Graphics g) {

        Graphics2D graphics2D = (Graphics2D)g;
            
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
        for (int i = 0; i < graph.vertices.length; i++) {
            drawNode(g,graph.vertices[i]);
        }
        for (int i = 0; i < graph.V; i++) {
            for (Integer node : graph.adjListArray.get(i)) {
                UndirectedGraph.Vertex a = graph.vertices[i];
                UndirectedGraph.Vertex b = graph.vertices[node];

                drawEdge(g, a, b);
            }


        }
            

    }

    public void drawNode (Graphics g, UndirectedGraph.Vertex v) {
        g.setColor(Color.RED);
        g.fillOval(v.x - 5, v.y - 5,10, 10);

       
        
    }
    public void drawEdge(Graphics g, UndirectedGraph.Vertex a, UndirectedGraph.Vertex b) {
        g.setColor(Color.BLACK);
        g.drawLine(a.x,a.y,b.x,b.y);
    }

}
