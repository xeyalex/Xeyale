package Exception;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        try {
            try {
                int result = arr[3] / 0;

            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception caught");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds Exception caught");
        }



    }
}
