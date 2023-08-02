package bubbleSortGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSortGUI {

    private JTextField[] inputFields;
    private JButton showButton;
    private JTextArea resultArea;

    public BubbleSortGUI() {
        JFrame frame = new JFrame("Bubble Sort GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        int tamanio = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el tamaño de la lista:"));
        inputFields = new JTextField[tamanio];

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Ingrese los elementos de la lista en orden ascendente:");

        // Leer los elementos de la lista
        for (int i = 0; i < tamanio; i++) {
            inputFields[i] = new JTextField(5);
            inputPanel.add(inputFields[i]);
        }

        showButton = new JButton("Mostrar resultado ordenado");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonAndResultPanel = new JPanel(); // Panel para contener el botón y el JTextArea
        buttonAndResultPanel.setLayout(new GridLayout(2, 1)); // GridLayout con 2 filas y 1 columna

        buttonAndResultPanel.add(showButton); // Agregar el botón
        buttonAndResultPanel.add(new JScrollPane(resultArea)); // Agregar el JTextArea con scroll

        mainPanel.add(buttonAndResultPanel, BorderLayout.SOUTH); // Agregar el panel al sur del mainPanel

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = inputFields.length;
                    int[] lista = new int[size];

                    for (int i = 0; i < size; i++) {
                        lista[i] = Integer.parseInt(inputFields[i].getText());
                    }

                    bubbleSort(lista);

                    StringBuilder sortedElements = new StringBuilder();
                    for (int num : lista) {
                        sortedElements.append(num).append(" ");
                    }

                    resultArea.setText("Lista ordenada:\n" + sortedElements.toString());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese números enteros válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void bubbleSort(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BubbleSortGUI());
    }
}
