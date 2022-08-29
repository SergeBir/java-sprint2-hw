import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class YearlyReport {

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

    //метод разделения файлов года
    public String[] toSeparateYear(String fileContents) {
        String[] lines = fileContents.split(System.lineSeparator());
        return lines;
//       String[] lineContents = line.split(",");
    }
    }
