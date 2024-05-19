package CasoEstudio03;

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
}
