public class ForMonthRecord {
    String item_names = " ";
    boolean is_expenses = false;
    int quantity = 0;
    int sum_of_one = 0;

    //для записи месячных данных
    public ForMonthRecord(String item_names, boolean is_expenses, int quantity, int sum_of_one) {
        this.item_names = item_names;
        this.is_expenses = is_expenses;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }
}
