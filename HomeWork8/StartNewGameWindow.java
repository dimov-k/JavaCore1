import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartNewGameWindow extends JFrame {

    private final GameWindow gameWindow;
    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String STR_WIN_LEN = "Длина поля: ";
    private static final String STR_FILED_SIZE = "Размер поля: ";

    private JRadioButton jrbHumVsAi = new JRadioButton("Человек vs AI", true);
    private JRadioButton jrbHumVsHum = new JRadioButton("Игра на двоих");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider slFieldSize;
    private JSlider slWinLength;


    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setTitle("Setting");
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocationRelativeTo ( null );

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH/2);
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT/2);

        setLocation(posX, posY);
        setLayout(new GridLayout(10,1));

        addGameControlsMode();
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
        if(jrbHumVsAi.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else {
            gameMode = Map.MODE_HVH;
        }

        int fieldSize = slFieldSize.getValue();
        int winLen = slWinLength.getValue();
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }

    private void addGameControlsMode() {
        add(new JLabel("Выберите режим"));
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);
    }

    void addGameControlsFieldWinLen() {
        add(new JLabel("Выберите размер поля"));
        final JLabel lblFieldSize = new JLabel(STR_FILED_SIZE + MIN_FIELD_SIZE);
        add(lblFieldSize);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_WIN_LEN);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = slFieldSize.getValue();
                lblFieldSize.setText(STR_FILED_SIZE + currentFieldSize);
                slWinLength.setMaximum(currentFieldSize);
            }
        });
        add(slFieldSize);

        add(new JLabel("Выберите длину поля: "));
        final JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lblWinLen);

        slWinLength = new JSlider(MIN_WIN_LEN, MAX_WIN_LEN, MIN_WIN_LEN);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLen.setText(STR_WIN_LEN + slWinLength.getValue());
            }
        });
        add(slWinLength);

    }



}