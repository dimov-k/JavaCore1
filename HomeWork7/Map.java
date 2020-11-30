import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Map extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;


    char[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLenght;
    int mode;
    int cellHeight;
    int cellWidth;
    boolean isInitialized = false;


    Map() {
        setBackground(Color.GRAY);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
        void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
            System.out.println("mode = " + mode +
                    "\n fieldSizeX = " + fieldSizeX +
                    "\n fieldSizeY = " + fieldSizeY +
                    "\n winLength = " + winLength);


            this.fieldSizeX = fieldSizeX;
            this.fieldSizeY = fieldSizeY;
            this.winLenght = winLength;
            this.mode = mode;
            field = new char[fieldSizeY][fieldSizeX];

            isInitialized = true;
            repaint();
    }
        void render(Graphics g) {
            if(!isInitialized) return;

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));

            cellWidth = panelWidth/fieldSizeY;
            cellHeight = panelHeight/fieldSizeX;

            for (int i = 0; i < fieldSizeY; i++) {
                int y = i * cellHeight;
                g.drawLine(0, y, panelWidth, y);
            }

            for (int i = 0; i < fieldSizeX; i++) {
                int x = i * cellWidth;
                g.drawLine(x,0,x, panelHeight);
            }

            g.setColor(Color.DARK_GRAY);
            for (int i = 0; i < fieldSizeY; i++) {
                for (int j = 0; j < fieldSizeX; j++) {

                }
            }
        }


}