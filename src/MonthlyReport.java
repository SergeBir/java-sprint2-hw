import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class MonthlyReport {
    static String[] lineContents;
    static String[] sepMonths;
    static int countMonth = 1;//старт отчета по месяцам
    static HashMap<String, String> descriptionMonth = new HashMap<>();//для помещения данных по месяцам

    //метод считывания файлов месяцев
    public String readFileContentsOrNull(String path, int numb) {
        try {
            System.out.println("Файл m.20210" + numb + ".csv считан");
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }

    }

    //метод перебора месяцев и считывания их
    public String toFollowInMonths() {
        while (countMonth > 0 && countMonth <= 3) {
            String monthName = "m.20210" + countMonth;
            String pathMonth = "/Users/sergeibiryukov/dev/java-sprint2-hw/resources/m.20210" + countMonth + ".csv";
            String totalMonth = readFileContentsOrNull(pathMonth, countMonth);
            descriptionMonth.put(monthName, totalMonth);
            countMonth++;
        }
        return null;
    }

    //метод исходного разделения файлов месяцев
    public static String[] toSeparateMonth(String fileContents) {
        String[] lines = fileContents.split(System.lineSeparator());
        return lines;
    }

    //Метод дополнительного разделения полученных данных по месяцам
    static String[] toSeparateMonth() {
        for (String month : descriptionMonth.keySet()) {
            sepMonths = (toSeparateMonth(descriptionMonth.get(month)));
            for (int i = 1; i < sepMonths.length; i++) {
                lineContents = sepMonths[i].split(", ");
                //System.out.println(Arrays.toString(lineContents));
            }
//            System.out.println(" ");
        }
        return null;
    }
}
