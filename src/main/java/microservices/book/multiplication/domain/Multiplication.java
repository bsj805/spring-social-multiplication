package microservices.book.multiplication.domain;

import lombok.Getter;

@Getter
public class Multiplication {

    private int factorA;
    private int factorB;

    private int result;

    public Multiplication(int factorA, int factorB){
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = factorA*factorB;
    }

    public String toString(){
        return "Multiplication{"+
                "factorA=" + factorA +
                ", factorB=" + factorB  +
                ", result(A*B)=" + result +
                '}';
    }

}
