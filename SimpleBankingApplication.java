import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBankingApplication {
    static String reset = "\u001B[0m";
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";
    static String blue = "\u001B[34m";
    static String yellow = "\u001B[33m";
    static String bold = "\u001B[1m";
    Scanner sc=new Scanner(System.in);
    ArrayList<String> accounts=new ArrayList<>();
    ArrayList<Integer> accounts_balance=new ArrayList<>();
    void addAccount(){
        System.out.println();
        sc.nextLine();
        System.out.print(blue+"Enter The name of account : "+reset);
        String name=sc.nextLine();
        accounts.add(name);
        System.out.print(blue+"Enter The initial balance in the account : "+reset);
        int balance=sc.nextInt();
        accounts_balance.add(balance);
        System.out.println();
        System.out.println(bold+green+"Successfully added"+reset);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menu();
    }
    void addMoney(int n){
        System.out.print(blue+"Enter money you want to deposit : "+reset);
        int money=sc.nextInt();
        int newBalane=money+accounts_balance.get(n);
        accounts_balance.set(n, newBalane);
        System.err.println();
        System.out.println(bold+green+"Successful Operation"+reset);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }  
    void withdraw(int n){
        System.out.print(blue+"Enter money you want to withdraw : "+reset);
        int money=sc.nextInt();
        if(accounts_balance.get(n)<money){
            System.out.println();
            System.out.println(bold+red+"Regected Operation: No enough Balance"+reset);
            
        }
        else{
            int newBalane=accounts_balance.get(n)-money;
            accounts_balance.set(n, newBalane);
            System.err.println();
            System.out.println(bold+green+"Successful Operation"+reset);
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void operations(int n){
        System.out.println();
        sc.nextLine();
        System.out.println(red+"Hi, You are browsing "+green+accounts.get(n)+red+" account"+reset);
        System.out.println(red+"Your Balance is : " +green+ accounts_balance.get(n) + reset);
        System.out.println();
        System.out.println(blue+"1 - Withdraw Money");
        System.out.println("2 - Deposit Money");
        System.out.println("3 - Return to accounts"+reset);
        System.err.print(green+"Choose operation you want : "+reset);
        char c=sc.nextLine().charAt(0);
        while(c!='1' && c!='2' && c!='3'){
            System.out.println(bold+red+"Error! Choose number between 1 : 3"+reset);
            c=sc.nextLine().charAt(0);
        }
        switch (c) {
            case '1':
                withdraw(n);
                operations(n);
            case'2':   
                addMoney(n);
                operations(n);
                break;
            case '3':
                viewAccount();
                break;
        }
    }
    void viewAccount(){
        System.out.println();
        if(accounts.size()==0){
            System.out.println(red+"Empty!"+reset);
            menu();
        }
        for(int i=0;i<accounts.size();i++){
            System.out.print(blue+(i+1)+"- ");
            System.out.println(accounts.get(i)+reset);
        }
        System.out.println(green+"Enter the number of account you want to browse"+red+" OR "+green+"Enter -1 to return to menu "+reset);
        int n = sc.nextInt();
        while(n<-1 || n>accounts.size() || n==0){
            System.out.println(bold+red+"Error! Enter the number of account you want to browse OR Enter -1 to return to menu "+reset);
            n=sc.nextInt();
        }
        if(n==-1){
            menu();
        }
        operations(n-1);
    }

    void menu(){
        System.out.println();
        System.out.println(blue+"1-Add account");
        System.out.println("2-View Exciting acounts");
        System.out.println("3-Exit"+reset);
        System.out.print(green+"Choose the operation you want : "+reset);
        char c = sc.next().charAt(0);
        while(c!='1'&& c!='2'&& c!='3'){
            System.out.println(bold+red+"Error! Choose a Number between 1 : 3"+reset);
            c = sc.next().charAt(0);
        }
        switch (c) {
            case '1':
                addAccount();
                break;
            case '2':
                viewAccount();
                break;
            case '3':
            System.out.println();
            System.out.println(bold+red+"Thanks for using our system :)"+reset);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        System.out.println();
        System.out.println(bold+red+"Welcome To Our Bank"+reset);
        SimpleBankingApplication temp=new SimpleBankingApplication();
        temp.menu();
    }
}
