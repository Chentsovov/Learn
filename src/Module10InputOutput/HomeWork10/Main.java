package HomeWork10;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class Main {
    //private static String sourseFile1 = ".\\src\\TenModule\\sourceFileOne.txt";
    //private static String sourseFile2 = ".\\src\\TenModule\\sourceFileTwo.txt";
    //private static String sourseFile3 = ".\\src\\TenModule\\sourceFileThree.txt";
    //private static String resFile1 = ".\\src\\TenModule\\resFileSecond.json";
    public static void main(String[] args) throws IOException {
        Ex1 ex1 = new Ex1();
        Ex2 ex2 = new Ex2();
        Ex3 ex3 = new Ex3();

        ex1.read();
        ex2.convert();
        ex3.counter();
    }
}
//-----------------------------------------------------------------------------------------------------------------
//    Дан текстовый файл file.txt, необходимо считать файл в список объектов User и создать новый файл user.json.
//    Предполагаем, что каждая строка содержит одинаковое количество "колонок", разделенный пробелом.*/

