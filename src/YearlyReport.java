import java.util.ArrayList;

public class YearlyReport {
    ArrayList<ForYearRec> forYearRecs; // куда будут добавляться данные при разделении файла

    YearlyReport() {
        forYearRecs = new ArrayList<>();
    }

    //метод считывания годового файла
    public void readReportOfYear() {
        String yearReportRew = ForHelp.readFileContentsOrNull("resources/y.2021.csv");
        if (yearReportRew != null) {
            separateReportYear(yearReportRew);
            System.out.println("Годовой отчет считан");
        }
    }

    //метод разделения данных в файле
    private void separateReportYear(String yearlyReportRew) {
        String[] lines = yearlyReportRew.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            ForYearRec record = new ForYearRec(Integer.parseInt(lineContents[0]), Integer.parseInt(lineContents[1]), Boolean.parseBoolean(lineContents[2]));
            forYearRecs.add(record);
        }
    }

    //траты
    Integer toTakeYearMonthExpense(int month) {
        for (ForYearRec forYearRec : forYearRecs) {
            if ((forYearRec.months == month) && (forYearRec.is_exp)) {
                return forYearRec.amounts;
            }
        }
        return null;
    }

    //доход
    Integer getIncome(int month) {
        for (ForYearRec forYearRec : forYearRecs) {
            if ((forYearRec.months == month) && (!forYearRec.is_exp)) {
                return forYearRec.amounts;
            }
        }
        return null;
    }

    public void toAverYearRep() {
        if (forYearRecs.isEmpty()) {
            System.out.println("Данных нет!");
        } else {
            int averagInc = 0;
            int averageExp = 0;
            for (ForYearRec reportCompare : forYearRecs) {
                if (!reportCompare.is_exp) {
                    averagInc += reportCompare.amounts / 3;
                } else {
                    averageExp += reportCompare.amounts / 3;
                }
            }
            System.out.println("Средний доход составляет: " + averagInc + "\n" + "Средний расход составляет: " + averageExp);
        }
    }

    //метод получения месячного дохода
    public void monthReport() {
        if (forYearRecs.isEmpty()) {
            System.out.println("Отчетов еще нет!");
        } else {
            int moneyProfit = 0;
            int incrProfit = 0;
            int exprProfit = 0;
            for (ForYearRec reportCompare : forYearRecs) {
                if (!reportCompare.is_exp) {
                    incrProfit = reportCompare.amounts;
                } else {
                    exprProfit = reportCompare.amounts;
                }
            }
            moneyProfit = incrProfit - exprProfit;
            System.out.println("Доход составил: " + moneyProfit);
        }
    }

    //проверка заполненности
    public boolean isNotFull() {
        if (forYearRecs.size() != 0) {
            return false;
        } else {
            return true;
        }
    }
}

