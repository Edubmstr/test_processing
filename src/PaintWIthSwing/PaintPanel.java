package PaintWIthSwing;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import processing.core.PApplet;

public class PaintPanel extends PApplet {

    private static Color color = Color.black;
    private static int strokeWeight = 2;
    private static boolean clearBoolean = false;

    public static void main(String[] args) {
        PApplet.main(PaintPanel.class);

        JFrame settingsFrame = new JFrame();
        settingsFrame.setTitle("Draw Settings");
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.setResizable(false);

        settingsFrame.setVisible(true);
        settingsFrame.setLocationRelativeTo(null);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setPreferredSize(new Dimension(400, 100));
        settingsPanel.setBackground(Color.LIGHT_GRAY);
        settingsPanel.setFocusable(true);
        settingsPanel.setLayout(null);
        settingsFrame.add(settingsPanel);

        JButton button = new JButton("Farbe wählen");
        button.setSize(100, 100);
        button.setLocation(0, 0);
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                color = JColorChooser.showDialog(settingsPanel, "Wählen Sie eine Farbe", color);
                if (color == null) {
                    color = Color.LIGHT_GRAY;
                }
                button.setBackground(color);
                System.out.println(color);
                System.out.println(color.getRGB());
            }
        });
        settingsPanel.add(button, BorderLayout.CENTER);

        JButton width = new JButton("Strichstärke");
        width.setSize(100, 100);
        width.setLocation(100, 0);
        width.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer input = parseInt(JOptionPane.showInputDialog(settingsPanel, "Bitte Strichstärke auswahlen.",
                            "Strichstärke", JOptionPane.PLAIN_MESSAGE));

                    if (!(input instanceof Integer)) {
                        strokeWeight = 2;
                    } else if (input <= 0) {
                        strokeWeight = 2;
                    } else if (input > 100) {
                        strokeWeight = 100;
                    } else {
                        strokeWeight = input;
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        });
        settingsPanel.add(width, BorderLayout.CENTER);

        JButton clear = new JButton("Reset");
        clear.setSize(100, 100);
        clear.setLocation(300, 0);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBoolean = true;
            }
        });
        settingsPanel.add(clear, BorderLayout.CENTER);

        JButton eraser = new JButton("Radierer");
        eraser.setSize(100, 100);
        eraser.setLocation(200, 0);

        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = new Color(200, 200, 200);
            }
        });
        settingsPanel.add(eraser);

        settingsFrame.pack();
    }

    public void settings() {
        size(800, 800);
    }

    public void draw() {
        if (mousePressed) {
            stroke(255);
            strokeWeight(strokeWeight);
            stroke(color.getRGB());
            line(mouseX, mouseY, pmouseX, pmouseY);
        }

        if (clearBoolean) {
            background(200, 200, 200);
            clearBoolean = false;
        }
    }
}