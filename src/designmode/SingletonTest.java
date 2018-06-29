package designmode;

class Single{
    public static Single instance = new Single();

    private Single(){}

    public static Single getInstance() {
        return instance;
    }

    public void print(){
        System.out.println("success");
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Single a = Single.getInstance();
        a.print();

    }
}
