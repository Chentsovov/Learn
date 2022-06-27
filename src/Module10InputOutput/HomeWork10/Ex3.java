package HomeWork10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//------------------------------------------------------------------------------------------------
//Напишите метод, который будет подсчитывать частоту каждого слова в файле words.txt.
//Предпалагаем, что:
//words.txt содержит только слова в нижнем регистре, разделенные пробелом
//Каждое слово содержит только символы-буквы в нижнем регистре.
//Слова разделены одим или несколькими пробелами, либо переносом строки.
public class Ex3 {
    private static final String sourseFile3 = ".\\src\\Module10InputOutput\\HomeWork10\\sourceFileThree.txt";
    private static final String sourseFile4 = ".\\src\\Module10InputOutput\\HomeWork10\\147695.txt";

    public void counter() {
        File file = new File(sourseFile4);
        if (!file.exists()) {
            throw new RuntimeException("file " + file.getName() + " isn't exist");
        }

        try (Stream<String> stream = Files.lines(Paths.get(sourseFile4))) {
            Map<String, Long> wordFreq = stream.flatMap(s -> Stream.of(s.split(" ")))
                    .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));

            for (var entry : wordFreq.entrySet()) {
                System.out.print(entry.getKey() + " " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("forbidden to write already opened file " + file.getName());
        }
    }
}
