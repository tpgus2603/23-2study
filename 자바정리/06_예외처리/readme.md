**Exception Handling**
-
프로그램 실행중에 생기는 다양한 예외를 처리하는 것을 말한다. 자바 가상머신은 일반적으로 예외가 발생하면 그 예외를 출력하고 프로그램을 종료하는데 자바에서는 예외 상황별로 그 상황을 알리기 위한 클래스를 정의한다.

예외가 발생하면 자바 가성머신은 해당 예외에 해당하는 인스턴스를 생성하는데 인스턴스를 프로그래머가 처리하면 예외는 처리된것으로 간주되어 프로그램을 종료하지 않는다.

예외 처리는 try~catch문을 통해 이루어진다.

try{                                 -> try영역에서 발생한 예외상황을 catch영역에서 처리한다. 
    관찰영역 
}catch(Excetpion name){
처리영역
}

try ~catch문에서 예외처리 이후 실행 코드는  try의 예외가 발생한 지점이후의 코드가 실행되는것이 아닌 catch문 이후 지점에서 실행이 이어나가진다. 또한 한 try블럭 내에서 여러가지 오류가 발생 가능한경우
여러 catch문을 삽입하거나 여러 조건을 catch문의 인자로 넣어준다. 

```
import java.util.Scanner;
import java.util.InputMismatchException;

public class Exceptioncase {
    public static void main(String[] s){
        Scanner ab= new Scanner(System.in);
        try{
            int n1= ab.nextInt();
            int n2=ab.nextInt();
            System.out.printf("%d /%d= %d\n",n1,n2,n1/n2);
            System.out.println((" start 1"));
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
        }
        System.out.println(" Start 2");
        //
        /*catch(InputMismatchException || ArithmeticException e){

        }*/

    }
}

```

자바에서 예외 클래스의 최상위 클래스는 java.lang.Thorwable 이고 이 클래스에는 발생한 예외의 정보를 알 수 있는 메소드가 정의되어 있다.

**public String getMessage( ) **는 예외의 원인을 담고있는 문자열을 반환하고   public void printStackTrace( )는 예외가 발생한 위치와 호출된 메소드의 정보를 출력한다. 

메소드 내에서 호출된 메소드에서 예외가 발생했는데 예외 처리가 되지않으면 호출한 메소드로 예외가 넘어간다 





