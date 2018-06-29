package designmode;

interface Paint{
    public void draw();
}

class TestA implements Paint{
    @Override
    public void draw() {
        System.out.println("TestA");
    }
}

class TestB implements Paint{
    @Override
    public void draw() {
        System.out.println("TestB");
    }
}

class TestC implements Paint{
    @Override
    public void draw() {
        System.out.println("TestC");
    }
}

class Factory{
    public Paint getA(String s){
        if (s == null){
            return null;
        }else if(s.equalsIgnoreCase("A")){
            return new TestA();
        }else if(s.equalsIgnoreCase("B")) {
             return new TestB();
        }else if (s.equalsIgnoreCase("C")){
            return new TestC();
        }
        return null;
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Paint a = factory.getA("a");
        a.draw();
    }
}
