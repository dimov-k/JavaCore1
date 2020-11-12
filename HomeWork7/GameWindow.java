import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {

    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 507;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    private static Map map;
    private static SettingGame startNewGameWindow;

    public GameWindow() {

        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setResizable(false);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton btnNewGame = new JButton("Start new game");
        JButton btnExit = new JButton("Exit");

        startNewGameWindow = new SettingGame(this);

        bottomPanel.add(btnNewGame);
        bottomPanel.add(btnExit);

        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        map = new Map();
        add(map, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
