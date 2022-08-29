import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.ArrayList;

public class MonthlyReport {


    //метод считывания файлов месяцев
    public String readFileContentsOrNull(String path,int numb) {
        try {
            System.out.println("Файл m.20210" + numb + ".csv считан");
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }

    }

    //метод разделения файлов месяцев
    public String[] toSeparateMonth(String fileContents) {
        String[] lines = fileContents.split(System.lineSeparator());
        return lines;
//       String[] lineContents = lines.split(",");
    }

}
