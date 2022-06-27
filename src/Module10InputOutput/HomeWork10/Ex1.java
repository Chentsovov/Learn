package HomeWork10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//----------------------------------------------------------------------------------------------
//Необъодимо написать метод, который будет считывать файл и выводить в
// консоль все валидные номера телефонов.
//Предполагаем, что "валидный" номер телефона - это строка в одном из
// двух форматов: (xxx) xxx-xxxx или xxx-xxx-xxxx (х обозначает цифру).
public class Ex1 {
    private static String sourseFile1 = ".\\src\\HomeWork10\\sourceFileOne.txt";

    public static void read() {
        try {
            FileReader filereader = new FileReader(sourseFile1);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String string1 = bufferedReader.readLine();
            while (string1 != null) {
                if (string1.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) { //три цыфры в скобках , пробел , три цыфры , дефис , 4 цыфры
                    System.out.println(string1);
                } else if (string1.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(string1);
                }
                string1 = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("forbidden to edit opened file ");
        }
    }
}
