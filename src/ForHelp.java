import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForHelp {

    //метод считывания данных
    static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    //метод проверки совпадения данных в отчетах
    public static void orderReport(MonthlyReport forMonthReport, YearlyReport forYearReport) {
        boolean checking = true;
        if (!forMonthReport.isNotFull() && !forYearReport.isNotFull()) {
            for (int i = 1; i < 4; i++) {
                if ((forMonthReport.toGetMonthIncome(i) != forYearReport.getIncome(i)) ||
                        (forMonthReport.toGetOfMonthExpense(i) != (forYearReport.toTakeYearMonthExpense(i)))) {
                    System.out.println(NameOfMonths.toGetNameOfMonth(i) + " не совпадают");
                    checking = false;
                }
            }
            if (checking) {
                System.out.println("Значения в отчетах совпадают.");
            }
        } else {
            System.out.println("Не загружены отчеты");
        }
    }


}


