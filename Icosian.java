
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Icosian {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(20);
        UndirectedGraph.makeDodecahedron(graph);
        graph.printGraph();

        JFrame frame = new JFrame("DrawToScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GraphDrawer());
        frame.pack();
        frame.setVisible(true);
    }
}

class GraphDrawer extends JPanel {
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768;

    public GraphDrawer() {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }

    // Your code here, if you want to define additional methods.

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 50; i < BOX_WIDTH; i = i + 200)
            for (int j = 50; j < BOX_HEIGHT; j = j + 150)
                funnyShape(g, i, j);

    }

    public void funnyShape(Graphics g, int n, int y) {

        g.setColor(Color.ORANGE);
        g.fillOval(n, y, 100, 100);

        g.setColor(Color.RED);
        g.fillOval(n + 13, y + 12, 75, 75);

        g.setColor(Color.ORANGE);
        g.fillOval(n + 25, y + 25, 50, 50);

        g.setColor(Color.RED);
        g.fillRect(n + 50, y, 5, 100);

        g.setColor(Color.RED);
        g.fillRect(n, y + 50, 100, 5);

    }

}
