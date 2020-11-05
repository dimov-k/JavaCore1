import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static final char meatbag = 'X';
    public static final char bender = 'O';
    public static final char EMPTY_DOT = '_';
    public static char[][] map;
    public static int sizeX;
    public static int sizeY;
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static void initMap() {
        sizeX = 3;
        sizeY = 3;
        map = new char[sizeY][sizeX];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || isEmptyCell(y, x)); //&& - and / || - or
        map[y][x] = meatbag;
    }

    public static void pcTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(sizeX); // 0...2
            y = RANDOM.nextInt(sizeY);
        } while (isEmptyCell(y, x));
        map[y][x] = bender;
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] != EMPTY_DOT;
    }

    public static boolean checkWin(char c) {
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) return true;
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) return true;
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) return true;

        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) return true;
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) return true;
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) return true;

        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
        return false;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if(map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(meatbag)) {
                System.out.println("Тебе просто повезло MeatBag");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println();
            pcTurn();
            printMap();
            if (checkWin(bender)) {
                System.out.println("Слава роботам! Убить всех человеков!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println();
        }
    }
}
