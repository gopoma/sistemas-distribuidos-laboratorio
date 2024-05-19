package creditcards;

import java.io.Serializable;

public class CreditCard implements Serializable {
    public int id;
    public String number;     //? Número de la tarjeta
    public String holderDNI;  //? DNI del titular de la tarjeta
    public String holderName; //? Nombre del titular de la tarjeta
    public double balance;    //? Saldo actual

    public CreditCard() {}
    public CreditCard(
        int id,
        String num,
        String hDNI,
        String hName,
        double b
    ) {
        this.id         = id;
        this.number     = num;
        this.holderDNI  = hDNI;
        this.holderName = hName;
        this.balance    = b;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
        "Número de la tarjeta: " + this.number + "\n" +
        "DNI del titular de la tarjeta: " + this.holderDNI + "\n" +
        "Nombre del titular de la tarjeta: " + this.holderName + "\n" +
        "Saldo actual: " + this.balance; 
    }
}
