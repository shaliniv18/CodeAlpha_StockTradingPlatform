import java.util.HashMap;
import java.util.Map;

public class Portfolio{

    private Map<String, Integer> holdings;

    public Portfolio(){
        holdings = new HashMap<>();
    }

    public void buyStock(String symbol, int quantity){
        int currentQuantity = holdings.getOrDefault(symbol, 0);
        holdings.put(symbol, currentQuantity + quantity);
    }

    public boolean sellStock(String symbol, int quantity){

        int currentQuantity = holdings.getOrDefault(symbol, 0);

        if(currentQuantity < quantity){
            return false;
        }
        int remaining = currentQuantity - quantity;

        if(remaining == 0){
            holdings.remove(symbol);
        }else{
            holdings.put(symbol, remaining);
        }

        return true;
    }
    public int getQuantity(String symbol){
        return holdings.getOrDefault(symbol, 0);
    }

    public void displayPortfolio(){

        System.out.println("\n===== MY PORTFOLIO =====");

        if(holdings.isEmpty()){

            System.out.println("Your portfolio is empty.");
            return;
        }

        for(Map.Entry<String, Integer> entry : holdings.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + "shares"); 
        }
    }
    }
