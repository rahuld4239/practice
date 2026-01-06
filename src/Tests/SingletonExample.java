package Tests;

public class SingletonExample {

    private SingletonExample instance;


    private SingletonExample() {

    }

    public SingletonExample getInstance() {

        synchronized (SingletonExample.class) {
            if(instance == null)
                this.instance = new SingletonExample();
        }
        return this.instance;
    }

    public int minNotes(int notes1000, int notes500, int notes100, int amount ) {

        int count = 0;

        while(amount > 1000 && notes1000 > 0) {
            count++;
            amount-=1000;
            notes1000--;
        }
        while(amount > 500 && notes500 > 0) {
            count++;
            amount-=500;
            notes500--;
        }
        while(amount > 100 && notes100 > 0) {
            count++;
            amount-=100;
            notes100--;
        }

        if(amount > 0)
            return -1;
        else return count;

    }
}

/*
Problem Statement (ATM Cash Dispensing):
An ATM has the following denominations available:
₹1000 notes → 5 available
₹500 notes → 10 available
₹100 notes → 10 available
If a customer enters ₹3700 as the withdrawal amount, determine how the ATM should dispense the money using the minimum number of notes possible

 */


