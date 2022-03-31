public class DebitCard implements Runnable{
    private int balance;
    private TransactionVerificator transactionVerificator;
    private TransactionHistory transactionHistory;

    public DebitCard(int balance) {
        this.balance = balance;
        transactionVerificator = new TransactionVerificator();
        transactionHistory = new TransactionHistory();
    }

    public void run(){
        public void withdraw(int amount) {
            try{
                if (!transactionVerificator.isFraud(amount)) {
                    synchronized(this){
                        if (transactionVerificator.verifyWithdraw(balance, amount)) {
                            balance -= amount;
                            transactionHistory.addWithdraw(amount, true);
                        } else {
                            transactionHistory.addWithdraw(amount, false);
                        }
                    }
                }

            } catch (InterruptedException e){
                //nothing
            }
        }

        public void deposit(int amount) {
            try{
                if (!transactionVerificator.isFraud(amount)) {
                    synchronized(this){
                        if (transactionVerificator.verifyDeposit(balance, amount)) {
                            balance += amount;
                            transactionHistory.addDeposit(amount, true);
                        } else {
                            transactionHistory.addDeposit(amount, false);
                        }
                    }
                }

            } catch (InterruptedException e){
                //nothing
            }
        }
    }
    
    public void printTransactionsHistory() {
        transactionHistory.printTransactionsHistory();
        System.out.printf("\nCurrent Balance: %d\n", balance);
    }
}

    /*
    Objective: Buatlah method(-method) bisa digunakan main program untuk melakukan beberapa transaksi secara bersamaan (multithreading)

    Description:

    Sebelum melakukan transaksi withdraw maupun deposit, lakukanlah verifikasi dengan memanggil transactionVerificator.isFraud(amount).
    
    Berikut adalah contoh method withdraw dan deposit apabila transaksi BELUM BISA dilaksanakan secara multithreading:
    ```
    private void withdraw(int amount) {
        if (!transactionVerificator.isFraud(amount)) {
            if (transactionVerificator.verifyWithdraw(balance, amount)) {
                balance -= amount;
                transactionHistory.addWithdraw(amount, true);
            } else {
                transactionHistory.addWithdraw(amount, false);
            }
        }
    }

    private void deposit(int amount) {
        if (!transactionVerificator.isFraud(amount)) {
            if (transactionVerificator.verifyDeposit(balance, amount)) {
                balance += amount;
                transactionHistory.addDeposit(amount, true);
            } else {
                transactionHistory.addDeposit(amount, false);
            }
        }
    }
    ```

    Pada contoh tersebut, pemanggilan method transactionVerificator.isFraud(amount) adalah pemanggilan yang blocking (terdapat delay beberapa saat), 
    karena untuk melakukan aksi berikutnya perlu menunggu proses pengecekan isFraud selesai.

    Tugas anda adalah menambahkan dan/atau memodifikasi method(-method) sehingga ketika DebitCard sedang melakukan pemanggilan transactionVerificator.isFraud(amount) pada transaksi,
    DebitCard tetap dapat melakukan transaksi (dilakukan secara bersamaan).
    */
/*
    private static class withdraw implements Runnable{
        public void run(int amount){
        
            try{
                if (!transactionVerificator.isFraud(amount)) {
                    synchronized(this){
                        if (transactionVerificator.verifyWithdraw(balance, amount)) {
                            balance -= amount;
                            transactionHistory.addWithdraw(amount, true);
                        } else {
                            transactionHistory.addWithdraw(amount, false);
                        }
                    }
                }

            } catch (InterruptedException e){
                //nothing
            }
        }
    }

    private static class deposit implements Runnable{
        public void run(int amount){
        
            try{
                if (!transactionVerificator.isFraud(amount)) {
                    synchronized(this){
                        if (transactionVerificator.verifyDeposit(balance, amount)) {
                            balance += amount;
                            transactionHistory.addDeposit(amount, true);
                        } else {
                            transactionHistory.addDeposit(amount, false);
                        }
                    }
                }

            } catch (InterruptedException e){
                //nothing
            }
        }
    } */
    
    
