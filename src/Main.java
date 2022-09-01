import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //ForHelp forHelp = new ForHelp();

        YearlyReport yearlyReport = new YearlyReport();

        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();

        System.out.println("Добрый день! Это приложение создано нашей командой для учета бухгалтерии! ");
        System.out.println("Перед началом работы проверьте файлы отчета (их расположение и корректность) ");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.readMonthReport();
            } else if (command == 2) {
                yearlyReport.readReportOfYear();
            } else if (command == 3) {
                ForHelp.orderReport(monthlyReport, yearlyReport);
            } else if (command == 4) {
                monthlyReport.minAndMaReport();
            } else if (command == 5) {
                yearlyReport.monthReport();
                yearlyReport.toAverYearRep();

            } else if (command == 0) {
                System.out.println("Завершение работы");
                break;
            } else {
                System.out.println("Такой команды пока что нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Считать все месячные отчёты.");
        System.out.println("2. Считать годовой отчёт.");
        System.out.println("3. Сверить отчёты.");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("0. Выход.");
    }
}
