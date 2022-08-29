import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    static String totalMonth;
    static String totalYear;
    static int countMonth = 1;
    static int countYear = 1;
    static MonthlyReport monthlyReport = new MonthlyReport();
    static YearlyReport yearlyReport = new YearlyReport();
    static HashMap<String, String> descriptionMonth = new HashMap<>();
    static HashMap<String, String> descriptionYear = new HashMap<>();
    static String[] sepMonths;
    static String[] sepYear;



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        System.out.println("Добрый день! Это приложение создано нашей командой для учета бухгалтерии! ");
        System.out.println("Перед началом работы проверьте файлы отчета (их расположение и корректность) ");

        while (true) {
            printMenu();
            int userChoice = scanner.nextInt();
            if (userChoice == 1) { // считываем месяцы
                while(countMonth <= 3 && countMonth > 0) {
                    String monthName = "m.20210" + countMonth;
                    String pathMonth = "/Users/sergeibiryukov/dev/java-sprint2-hw/resources/m.20210" + countMonth +".csv";
                    totalMonth = monthlyReport.readFileContentsOrNull(pathMonth,countMonth);
                    descriptionMonth.put(monthName,totalMonth);
                    countMonth++;
                }
//                System.out.println(descriptionMonth);
            }
            else if (userChoice == 2) {
                String yearName = "y.202" + countYear;
                String pathYear = "/Users/sergeibiryukov/dev/java-sprint2-hw/resources/y.202" + countYear + ".csv";
                totalYear = yearlyReport.readYearlyReport(pathYear, countYear);
                descriptionYear.put(yearName,totalYear);
//                System.out.println(descriptionYear);
            }
            else if (userChoice == 3) {

            }
            else if (userChoice == 4) {
                toSeparateMonth();
            }
            else if (userChoice == 5) {

            }
            else if (userChoice == 1234) {
                System.out.println("Завершение работы");
                break;
            } else {
                System.out.println("Извините, такой команды нет в системе! Повторите запрос.");
            }
        }

    }
    //метод главного меню
    private static void printMenu() {
        System.out.println("Что вы хотите сделать");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
    }

    //Вспомогательный метод разделения полученных данных по месяцам
    private static String[] toSeparateMonth() {
        for (String month: descriptionMonth.keySet()) {
            sepMonths = (monthlyReport.toSeparateMonth(descriptionMonth.get(month)));
            //System.out.println(Arrays.toString(sepMonths));
            for (int i = 1; i < sepMonths.length; i ++) {
                String[] lineContents = sepMonths[i].split(", ");
//                System.out.println(Arrays.toString(lineContents));

                }
//            System.out.println(" ");

            }
        return null;
    }

    //Вспомогательный метод разделения полученных данных годового файла
    private static String[] toSeparateYear() {
        for (String year: descriptionYear.keySet()) {
            sepYear = (yearlyReport.toSeparateYear(descriptionYear.get(year)));
            for (int i = 1; i < sepYear.length; i ++) {
                String[] lineContents = sepYear[i].split(", ");
//                System.out.println(Arrays.toString(lineContents));
            }
//            System.out.println(" ");
        }
        return null;
    }

        //метод подсчета данных по месяцам
    private static void toGetMonthsData(String[] data) {
        int maxIncome = 0;
        String maxIncomeThing = " ";
        for (String thing: data) {
            Integer countThings = Integer.valueOf(data[2]);
            Integer priceThing = Integer.valueOf(data[3]);
            if ((countThings * priceThing) > maxIncome ) {
                maxIncome = countThings * priceThing;
                maxIncomeThing = data[0];
            }
        }
        System.out.println("Самый прибыльный товар: " + maxIncomeThing);
        System.out.println("Он принес дохода: " + maxIncome);
    }

    }

