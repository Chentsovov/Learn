package HomeWork10;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Ex2 {
    private static final String sourseFile2 = ".\\src\\Module10InputOutput\\HomeWork10\\sourceFileTwo.txt";
    private static final String resFile1 = ".\\src\\Module10InputOutput\\HomeWork10\\resFileOne.json";

    public void convert() {
        File file1 = new File(sourseFile2);
        ArrayList<User> gDate = new ArrayList<>();

        if (!file1.exists()) {
            throw new RuntimeException("file " + file1.getName() + " isn't exist");
        }

        try (Stream<String> stream = Files.lines(Paths.get(sourseFile2))) {
            stream.skip(1).forEach(s -> {
                gDate.add(new User(s.split(" ")[0], Integer.parseInt(s.split(" ")[1])));
            });
        } catch (IOException e) {
            System.err.println("forbidden to write already opened file " + file1.getName());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(resFile1))) {
            String res = new Gson().toJson(gDate);
            fileOutputStream.write(res.getBytes(StandardCharsets.UTF_8));
            System.out.println("file " + resFile1 + " created successfully");
        } catch (IOException e) {
            System.err.println("forbidden to write already opened file " + file1.getName());
        }

    }

    class User {

        private String firstParam;
        private int secondParam;

        public User(String firstParam, int secondParam) {
            this.firstParam = firstParam;
            this.secondParam = secondParam;
        }
    }
}
