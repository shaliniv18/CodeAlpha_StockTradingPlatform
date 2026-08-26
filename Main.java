import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        TradingPlatform platform = new TradingPlatform();

        platform.addStock(new Stock("APPL", "Apple Inc.", 150.00));
        platform.addStock(new Stock("GOoGL", "Alphabet Inc", 2800.00));
        platform.addStock(new Stock("MSFT", "Microsoft Corp.", 300.00));
        platform.addStock(new Stock("AMZN", "Amazon.com", 3500.00));

        System.out.println("=======================================");
        System.out.println("      STOCK TRADING PLATFORM");
        System.out.println("=======================================");

        System.out.print("Enetr your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter starting cash balance: $");
        double balance = scanner.nextDouble();

        User user = new User(name, balance);

        int choice;

        do{

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Display Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Display Market");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Account");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    platform.displayMarket();
                    break;

                    case 2:

                    scanner.nextLine();

                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.nextLine();
                
                   System.out.print("Enter quantity: ");
                   int buyQuantity = scanner.nextInt();

                   if(platform.buyStock(user, buySymbol, buyQuantity)){

                    System.out.println("Stock purchased successfully!");


                   }else{
                    System.out.println("Unable to complete purchase.");
                   }

                   break;

                   case 3:

                   scanner.nextLine();

                   System.out.print("Enter stock symbol: ");
                   String sellSymbol = scanner.nextLine();
                   System.out.print("Enter quantity: ");
                   int sellQuantity = scanner.nextInt();

                   if(platform.sellStock(user, sellSymbol, sellQuantity)){

                    System.out.println("Stock sold successfully!");
                   }else{

                    System.out.println("unable to complete sale.");

                   }

                   break;

                   case 4:
                    user.getPortfolio().displayPortfolio();
                    break;

                    case 5:
                        user.displayAccount();
                        break;

                        case 6:
                            platform.displayTransactions();
                            break;

                            case 7:

                            System.out.println("Thank you for using Stock Trading Platform!");
                            break;

                            default:
                                System.out.println("Invalid choice. Please try again");
            }

        }while(choice != 7);

        scanner.close();
    }
}