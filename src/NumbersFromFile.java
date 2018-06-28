import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class NumbersFromFile {
    public static void main(String[] args) {

        String fileName = "numbers.txt";
        File file = new File(fileName);
        TreeMap<Integer, Integer> numbersMap = new TreeMap<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                Integer number = scan.nextInt();
                if (numbersMap.get(number) == null) {
                    numbersMap.put(number, 1);
                } else {
                    numbersMap.put(number, numbersMap.get(number) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak podanego pliku: " + fileName);
        }

        Set<Integer> keySet = numbersMap.keySet();

        for (Integer nb : keySet) {
            System.out.println(nb + " - liczba wystąpień: " + numbersMap.get(nb));
        }

    }

}