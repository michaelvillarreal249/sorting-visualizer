import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class VisualizerPanel extends JPanel {

    private int[] array;

    public VisualizerPanel() {
        array = new int[100];
        generateRandomArray();
    }

    public void generateRandomArray() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500) + 20;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(i * 8, getHeight() - array[i], 6, array[i]);
        }
    }

    public int[] getArray() {
        return array;
    }

    public void refresh() {
        repaint();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
