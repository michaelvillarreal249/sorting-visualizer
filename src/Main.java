import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sorting Algorithm Visualizer");

        VisualizerPanel panel = new VisualizerPanel();

        JButton shuffleButton = new JButton("Shuffle");
        JButton startButton = new JButton("Start");

        String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
        JComboBox<String> algorithmBox = new JComboBox<>(algorithms);

        shuffleButton.addActionListener(e -> {
            panel.generateRandomArray();
        });

        startButton.addActionListener(e -> {
            new Thread(() -> {
                String selected = (String) algorithmBox.getSelectedItem();

                if (selected.equals("Bubble Sort")) {
                    SortingAlgorithms.bubbleSort(panel.getArray(), panel);
                } else if (selected.equals("Selection Sort")) {
                    SortingAlgorithms.selectionSort(panel.getArray(), panel);
                } else if (selected.equals("Insertion Sort")) {
                    SortingAlgorithms.insertionSort(panel.getArray(), panel);
                }
            }).start();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(algorithmBox);
        buttonPanel.add(shuffleButton);
        buttonPanel.add(startButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

