import java.io.*;


public class HomeWork6 {

//1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
//2.Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("file1.txt");
            byte[] buffer = new byte[1 << 20];
            OutputStream os = new FileOutputStream(new File("file3.txt"), true);
            int count;
            while ((count = in.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
            in.close();
            in = new FileInputStream("file2.txt");

            while ((count = in.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
            System.out.println("Обьединение завершено");
            in.close();
            os.close();

//3.* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
            if (searchForWord("file3.txt", "теория")) System.out.println("Слово Найдено :)");
            else System.out.println("Такого слова нет =((");
            if (searchForWord("file3.txt", "заговора")) System.out.println("Слово Найдено :)");
            else System.out.println("Такого слова нет :'(");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean searchForWord(String path, String wordToSearch){
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br2 = new BufferedReader(isr);

            String[] wordsFromFile = null;
            String currentLine;

            while ((currentLine = br2.readLine()) != null) {
                wordsFromFile = currentLine.split(" ");
                for (String s : wordsFromFile) {
                    if (s.replaceAll("\\p{Punct}", "").toLowerCase().equals(wordToSearch)) {
                        br2.close();
                        return true;
                    }
                }
            }
            fis.close();
            isr.close();
            br2.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

}