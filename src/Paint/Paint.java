package Paint;

import Paint.Components.ColorButton;
import Paint.Components.PaintingArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import processing.core.PApplet;

public class Paint extends PApplet {

  private PaintingArea paintingArea;
  private ColorButton red, blue, green;

  public static void main(String[] args) {
    PApplet.main(Paint.class);
    JFrame frame = new JFrame(); // Erzeugt neues JFrame
    JButton button = new JButton("Klicke mich!"); // Button erzeugen
    frame.add(button); // Button hinufügen getContentPane()
    frame.setSize(400, 300); // Fenstergröße definieren
    frame.setLocationRelativeTo(null); // Fenster inmitten der Bildschirm zentrieren
    frame.setVisible(true); // Fenster sichtbar setzen
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    paintingArea = new PaintingArea(this);
    red = new ColorButton(30, 20, 20, 20, "test", this, 255, 0, 0);
    blue = new ColorButton(30, 50, 20, 20, "test", this, 0, 255, 0);
    green = new ColorButton(30, 80, 20, 20, "test", this, 0, 0, 255);
  }

  public void draw() {
    paintingArea.render();
    red.render();
    red.onClick(() -> paintingArea.setColor(255, 0, 0));
    blue.render();
    blue.onClick(() -> paintingArea.setColor(0, 255, 0));
    green.render();
    green.onClick(() -> paintingArea.setColor(0, 0, 255));
  }
}
