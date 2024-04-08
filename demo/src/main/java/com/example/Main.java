import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TrafficLightSimulation extends JFrame {
    private JLabel redLight, yellowLight, greenLight;

    public TrafficLightSimulation() {
        setTitle("Traffic Light Simulation");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        redLight = createLight(Color.RED);
        yellowLight = createLight(Color.YELLOW);
        greenLight = createLight(Color.GREEN);

        add(redLight);
        add(yellowLight);
        add(greenLight);

        setVisible(true);

        simulateTrafficLights();
    }

    private JLabel createLight(Color color) {
        JLabel light = new JLabel();
        light.setOpaque(true);
        light.setBackground(color);
        light.setPreferredSize(new Dimension(150, 150));
        return light;
    }

    private void simulateTrafficLights() {
        while (true) {
            // Red light
            redLight.setBackground(Color.RED);
            yellowLight.setBackground(Color.BLACK); // Off
            greenLight.setBackground(Color.BLACK); // Off
            sleep(3000);

            // Red and Yellow lights (transition)
            redLight.setBackground(Color.RED);
            yellowLight.setBackground(Color.YELLOW);
            greenLight.setBackground(Color.BLACK); // Off
            sleep(1000);

            // Green light
            redLight.setBackground(Color.BLACK); // Off
            yellowLight.setBackground(Color.BLACK); // Off
            greenLight.setBackground(Color.GREEN);
            sleep(3000);

            // Yellow light
            redLight.setBackground(Color.BLACK); // Off
            yellowLight.setBackground(Color.YELLOW);
            greenLight.setBackground(Color.BLACK); // Off
            sleep(1000);
        }
    }

    private void sleep(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLightSimulation::new);
    }
}
