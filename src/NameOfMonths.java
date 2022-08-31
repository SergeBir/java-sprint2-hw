public class NameOfMonths {

    //название месяцев для прогона
    static String[] months = new String[]{
            "Январь", "Февраль", "Март"
    };

    public static String toGetNameOfMonth(int number) {
        return months[number - 1];
    }

}
