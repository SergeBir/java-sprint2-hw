import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearlyReport {
    static String[] sepYear;
    static String totalYear;
    static HashMap<String, String> descriptionYear = new HashMap<>();
    static int countYear = 1;//старт годовых отчетов

    //метод считывания файла года
    public String readYearlyReport(String path, int numb) {
        try {
            System.out.println("Файл y.202" + numb + ".csv считан");
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    //метод перебора годовых отчетов и считывания их
    public String toFollowInYears () {
        String yearName = "y.202" + countYear;
        String pathYear = "/Users/sergeibiryukov/dev/java-sprint2-hw/resources/y.202" + countYear + ".csv";
        totalYear = readYearlyReport(pathYear, countYear);
        descriptionYear.put(yearName,totalYear);
        return null;
    }

    //метод разделения файлов года
    public static String[] toSeparateYear(String fileContents) {
        String[] lines = fileContents.split(System.lineSeparator());
        return lines;
    }

    //Метод дополнительного разделения полученных данных
    private static String[] toSeparateYear() {
        for (String year: descriptionYear.keySet()) {
            sepYear = (toSeparateYear(descriptionYear.get(year)));
            for (int i = 1; i < sepYear.length; i ++) {
                String[] lineContents = sepYear[i].split(", ");
//                System.out.println(Arrays.toString(lineContents));
            }
//            System.out.println(" ");
        }
        return null;
    }

    }
