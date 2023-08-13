package actions;

public class exceptionExample {

    public static void main(String[] args){

            try{
                int a = 10;
                int b = 0;
                int c = a/b;
                System.out.println("C=" + c);
            }catch (Exception e){
                e.printStackTrace();
            }


    }
}
