package solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * @author Sophie Song
 * @since 03/12/2018
 */
public class SendMail {

    private static String getAttachment() {
        String allRes = "This is what I want to write in the logs";
        String attachLogPath = null;
        try {
            File file = File.createTempFile("job_logs", ".log");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(allRes);
            writer.close();
            attachLogPath = file.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("The problem is: " + e.getMessage());
        }
        System.out.println("the log path is: " + attachLogPath);
        return attachLogPath;
    }

    public static void main(String[] args) throws IOException {
 /*       String attachment = getAttachment();
        try (Stream<String> stream = Files.lines(Paths.get(attachment))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (attachment != null) {
            Files.delete(Paths.get(attachment));
        }
        System.out.println(Files.exists(Paths.get(attachment)));*/


        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i= 0; i < 10; i++) {
            int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

}
