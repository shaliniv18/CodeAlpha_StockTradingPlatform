public class User{

    private String name;
    private double cashBalance;
    private Portfolio portfolio;

    public User(String name, double cashBalance){

        this.name =  name;
        this.cashBalance = cashBalance;
        this.portfolio = new Portfolio();
    }

    public String getName(){
        return name;
    }

    public double getCashBalance(){
        return cashBalance;
    }
    public Portfolio getPortfolio(){
        return portfolio;
    }
    
    public boolean deductionCash(double amount){

        if(amount > cashBalance){
            return false;
        }
        
        cashBalance -= amount;
        return true;
    }
    
    public void addCash(double amount){
        cashBalance += amount;
    }

    public void displayAccount(){

        System.out.println("\n===== ACCONT DETAILS =====");
        System.out.println("User Name :" + name);
        System.out.printf("Cash Balance : $%.2f%n", cashBalance);
    }
}