package Exception;

public class MultipleExceptionsExample {
    public static void main(String[] args) {
        try{
            int[] arr = null;
            int res = arr[0]/0;

        }catch (ArithmeticException|NullPointerException|ArrayIndexOutOfBoundsException e){
            System.out.println("Exception caught:"+e);
        }
    }
}
