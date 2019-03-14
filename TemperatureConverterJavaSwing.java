package temperatureconvertjavaswing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverterJavaSwing {
    // Nom des titres pour le panel
    private final JLabel celsius;
    private final JLabel directions;
    private final JLabel inputLabel;
    private final JLabel outputLabel;
    
    // Titre de la box
    private final JTextField fahrenheit;
    
    // Taille des panels
    private final int WIDTH = 350;
    private final int HEIGHT = 150;

  public TemperatureConverterJavaSwing() {
        // Pour creer un nouveau jFrame conteneur
        JFrame jfrm = new JFrame("Convertisseur de temperature");

        // Definit le layout
        jfrm.setLayout(new FlowLayout());
        
        // Initialiser la taille des cellules
        jfrm.setSize(WIDTH, HEIGHT);

        // Tuer le programme quand l'utilisateur quitte 
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creer des texts
        directions = new JLabel("Entrer la temperature et cliquer sur entrer");
        inputLabel = new JLabel("Temperature en Fanheireit");
        outputLabel = new JLabel("Temperature en celsius: ");
        celsius = new JLabel("");
        
        fahrenheit = new JTextField(6);
        fahrenheit.addActionListener(new TempListener());
        
        
        jfrm.add(directions);
        jfrm.add(inputLabel);
        jfrm.add(fahrenheit);
        jfrm.add(outputLabel);
        jfrm.add(celsius);
        
        // Afficher le frame
        jfrm.setVisible(true);
  }

  private class TempListener implements ActionListener {
      // Convertir la temperature entrer par l'
    @Override
    public void actionPerformed(ActionEvent event) throws NumberFormatException {
        double celsiusTemp;
        double fahrenheitTemp;
        try {
            String text = fahrenheit.getText();
            fahrenheitTemp = Double.parseDouble(text);
            celsiusTemp = Math.round((fahrenheitTemp - 32) * 5 / 9);
            celsius.setText(Double.toString(celsiusTemp));
        } catch (NumberFormatException e) {
            celsius.setText("Entrer un chiffre");
            System.err.println("NumberFormatException dans TempListener: " + e.getMessage());
        }
    }
  }
  
  public static void main(String args[]) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverterJavaSwing();
            }
        });
    }
  
}
