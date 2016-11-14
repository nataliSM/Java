import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Created by Natalia on 11.11.16.
 */
public class Main extends JFrame {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 11);


        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);
        fileMenu.addSeparator();

        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        fileMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        fileMenu.add(itemExit);

        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setFont(font);

        JMenuItem aboutItem = new JMenu("About");
        aboutItem.setFont(font);
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hey Hasla");
            }
        });
        aboutMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);




        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Button redButton = new Button("Show Red");
        redButton.addActionListener(n ->frame.getContentPane().setBackground(Color.RED));

        Button timeButton = new Button("Show Time");
        timeButton.addActionListener(n -> JOptionPane.showMessageDialog(null, new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())));

        Button weatherButton = new Button("Show weather");
        JTextField textField = new JTextField();

        weatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameOfCity = JOptionPane.showInputDialog(
                        textField,
                        "Write Your city",
                        "Weather",
                        JOptionPane.PLAIN_MESSAGE);


            }
        });
        panel.add(redButton);
        panel.add(timeButton);
        panel.add(weatherButton);


        frame.getContentPane().add(panel, BorderLayout.EAST);
        frame.setJMenuBar(menuBar);
        frame.setBounds(200, 200, 500, 500);
        frame.setVisible(true);

    }
}
