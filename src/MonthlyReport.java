import java.util.ArrayList;
import java.util.HashMap;
public class MonthlyReport {
    HashMap<Integer, ArrayList<ForMonthRecord>> monthsRec = new HashMap<>();

    //метод считывания файлов месяцев
    public void readMonthReport() {
        for (int i = 1; i <= 3; i++) {
            String monthlyReportRew = ForHelp.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            parseMonthReport(monthlyReportRew, i);
        }
        System.out.println("Месячные отчеты считаны.");
    }

    //метод разделения данных
    private void parseMonthReport(String monthlyReportRew, int key) {
        String[] lines = monthlyReportRew.split("\n");
        ArrayList<ForMonthRecord> forMonthRecordArrayList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            ForMonthRecord record = new ForMonthRecord(
                    lineContents[0],
                    Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]),
                    Integer.parseInt(lineContents[3])
            );
            forMonthRecordArrayList.add(record);
            monthsRec.put(key, forMonthRecordArrayList);
        }
    }

    //метод находения самого прибыльного и убыточного товаров
    public void minAndMaReport(){
        if (monthsRec.isEmpty()) {
            System.out.println("Отчетов нет");
        } else {
            for (Integer month : monthsRec.keySet()) {
                int maxMonth = 0;
                int minMonth = 0;
                String maxMonthName = " ";
                String minMonthName = " ";
                for (ForMonthRecord reportCompare : monthsRec.get(month)) {
                    if (!reportCompare.is_expenses) {
                        int sum = reportCompare.sum_of_one * reportCompare.quantity;
                        if (sum > maxMonth){
                            maxMonth = sum;
                            maxMonthName = reportCompare.item_names;
                        }
                    } else {
                        int exp = reportCompare.sum_of_one * reportCompare.quantity;
                        if (exp > minMonth){
                            minMonth = exp;
                            minMonthName = reportCompare.item_names;
                        }
                    }
                }
                System.out.println("Отчет за месяц: " + NameOfMonths.toGetNameOfMonth(month) + "\n" + "Наиболее продаваемый товар: " + maxMonthName + " : " + maxMonth + "\n"
                        + "Наиболее убыточный товар: " + minMonthName + " : " + minMonth);
            }
        }
    }

    //получение месяных трат
    public int toGetOfMonthExpense(int month) {
        int allExpenses = 0;
        for (ForMonthRecord report : monthsRec.get(month)) {
            if (report.is_expenses) {
                allExpenses += report.quantity * report.sum_of_one;
            }
        }
        return allExpenses;
    }

    //получение месячного дохода
    public int toGetMonthIncome(int month) {
        int allIncomes = 0;
        for (ForMonthRecord report: monthsRec.get(month)) {
            if (!report.is_expenses) {
                allIncomes += report.quantity * report.sum_of_one;
            }
        }
        return allIncomes;
    }

    public boolean isNotFull() {
        if(monthsRec.size() != 0){
            return false;
        } else {
            return true;
        }
    }
}
