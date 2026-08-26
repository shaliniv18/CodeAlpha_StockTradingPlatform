import java.time.LocalDateTime;

public class Transaction{

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private LocalDateTime dateTime;

    public Transaction(String type, String stockSymbol, int quantity, double price){

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.dateTime = LocalDateTime.now();
    }
    public void displayTransaction(){

        double total = quantity * price;

        System.out.println("-------------------------------");
        System.out.println("Transaction :" + type);
        System.out.println("Stock :" + stockSymbol);
        System.out.println("Quantity :" + quantity);
        System.out.printf("Price : $%.2f%n", price);
        System.out.printf("Total Value : $%.2f%n", total);
        System.out.println("Date & Time :" + dateTime);

    }
}
