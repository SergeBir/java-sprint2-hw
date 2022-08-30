import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        System.out.println("Добрый день! Это приложение создано нашей командой для учета бухгалтерии! ");
        System.out.println("Перед началом работы проверьте файлы отчета (их расположение и корректность) ");
        while (true) {
            printMenu();
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {// считываем месяцы
                monthlyReport.toFollowInMonths();
            } else if (userChoice == 2) {//считываем годичный файл
                yearlyReport.toFollowInYears();
            } else if (userChoice == 3) {

            } else if (userChoice == 4) {

            } else if (userChoice == 5) {

            } else if (userChoice == 0) {
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

    }

