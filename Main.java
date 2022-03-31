import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner();
    int balance = scanner.nextInt();
    int Q = scanner.nextInt();
    for (int i=0;i=Q; i++){
    	String a = scanner.next();
    	int x = scanner.nextInt();
    	if(a=="W"){
    		DebitCard.withdraw(x);
    	}
    	else if (a=="D"){
    		Debitcard.deposit(x);
    	}
    }
    thread.wait();
    printTransactionsHistory();


    }
}
