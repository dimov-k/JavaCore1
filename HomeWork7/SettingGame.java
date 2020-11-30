import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingGame extends JFrame {

    private final GameWindow gameWindow;
    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String STR_WIN_LEN = "Winning Len: ";
    private static final String STR_FILED_SIZE = "Field Size: ";


    private JRadioButton humVSAI = new JRadioButton("Human vs Ai", true);
    private JRadioButton humVSHum = new JRadioButton("Human vs Human");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider slFieldSize;
    private JSlider slWinLenght;

    public SettingGame(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setTitle("Settings new game");
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocationRelativeTo(null);

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT / 2);

        setLocation(posX, posY);
        setLayout(new GridLayout(10, 1));

        addGameModeSetup();
        addGameControlsFieldWinLen();

        JButton btnStartGame = new JButton("Start a game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGame();
            }
        });
        add(btnStartGame);

    }

    void btnStartGame() {
        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else {
            gameMode = Map.MODE_HVH;
        }

        int fieldSize = slFieldSize.getValue();
        int winLen = slWinLenght.getValue();
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }

    private void addGameModeSetup() {
        add(new JLabel("Choose gaming mode:"));
        gameMode.add(humVSAI);
        gameMode.add(humVSHum);
        add(humVSAI);
        add(humVSHum);
    }

    void addGameControlsFieldWinLen() {
        add(new JLabel("Choose field size"));
        final JLabel lblFieldSize = new JLabel(STR_FILED_SIZE + MIN_FIELD_SIZE);
        add(lblFieldSize);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_WIN_LEN);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = slFieldSize.getValue();
                lblFieldSize.setText(STR_FILED_SIZE + currentFieldSize);
                slWinLenght.setMaximum(currentFieldSize);
            }
        });
        add(slFieldSize);

        add(new JLabel("Choose win len: "));
        final JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lblWinLen);

        slWinLenght = new JSlider(MIN_WIN_LEN, MAX_WIN_LEN, MIN_WIN_LEN);
        slWinLenght.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLen.setText(STR_WIN_LEN + slWinLenght.getValue());
            }
        });
        add(slWinLenght);

    }
}
