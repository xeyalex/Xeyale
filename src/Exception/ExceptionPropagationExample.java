package Exception;

public class ExceptionPropagationExample {
    public static void main(String[] args) {
        try{
            A();
        }catch (Exception e){
            System.out.println("Exception handled in method A");
        }
    }
    public static void A() throws Exception{
        B();
    }
    public static void B() throws Exception{
    throw new Exception("Exception handled in method B");
    }
}
