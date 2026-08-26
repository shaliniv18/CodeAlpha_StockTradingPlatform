import java.util.ArrayList;

public class TradingPlatform{

    private ArrayList<Stock> stocks;
    private ArrayList<Transaction> transactions;

    public TradingPlatform(){
        stocks = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }

    public void displayMarket(){

        System.out.println("\n========== STOCK MARKET ==========");
        System.out.printf("%-10s %-20s %s%n", "Symbol", "Company", "Price");

        System.out.println("--------------------------------");

        for(Stock stock : stocks){
            stock.displayStock();
        }
    }

    public Stock findStock(String symbol){

        for(Stock stock : stocks){

            if(stock.getSymbol().equalsIgnoreCase(symbol)){
                return stock;
            }
        }
        
        return null;
    }

    public boolean buyStock(User user, String symbol, int quantity){

        Stock stock = findStock(symbol);

        if (stock== null || quantity <= 0){
            return false;
        }

        double totalCost = stock.getPrice() * quantity;

        if(!user.deductionCash(totalCost)){
            return false;
        }
        user.getPortfolio().buyStock(stock.getSymbol(), quantity);

        transactions.add(new Transaction("BUY", stock.getSymbol(), quantity, stock.getPrice()));

        return true;
    }

    public boolean sellStock(User user, String symbol, int quantity){

        Stock stock = findStock(symbol);

        if(stock == null || quantity <= 0){
            return false;
        }

        if(!user.getPortfolio().sellStock(stock.getSymbol(), quantity)){

            return false;
        }

        double totalValue = stock.getPrice() * quantity;

        user.addCash(totalValue);

        transactions.add(new Transaction ("SELL", stock.getSymbol(), quantity, stock.getPrice()));
        
        return true;
    }

    public void displayTransactions(){

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if(transactions.isEmpty()){
            System.out.println("No transactions available.");
            return;
        }

        for(Transaction transaction : transactions){
            transaction.displayTransaction();
        }
    }
}