import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicInteger;

class WordCountThread extends Thread {
    private String fileName;
    private int wordcount;
    public WordCountThread(String fileName) {
        this.fileName = fileName;
        wordcount = 0;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordcount += words.length;
            }
            System.out.println(fileName+": "+wordcount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class WordCountPlus {
    public static void main(String[] args) throws InterruptedException {

        String fileName1 = "C:\\Users\\CSE\\Desktop\\Exam\\multithreading\\src\\file1.txt";
        String fileName2 = "C:\\Users\\CSE\\Desktop\\Exam\\multithreading\\src\\file2.txt";


        WordCountThread thread = new WordCountThread(fileName1);
        WordCountThread thread2 = new WordCountThread(fileName2);

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
    }
}
