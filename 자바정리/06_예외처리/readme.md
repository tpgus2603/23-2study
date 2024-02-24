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

**public String getMessage()** 는 예외의 원인을 담고있는 문자열을 반환하고   public void printStackTrace( )는 예외가 발생한 위치와 호출된 메소드의 정보를 출력한다. 

메소드 내에서 호출된 메소드에서 예외가 발생했는데 예외 처리가 되지않으면 호출한 메소드로 예외가 넘어간다. 이때 throws를 메소드 끝에 명시 하는데 예외를 넘긴 순간 메소드는 종료된다.

**예외가 발생 할 수 있는 메소드를 호출 할때는 예외를 처리하든가 throws를 붙여서 자신을 호출한 상위 메소드로 예외처리를 넘긴다** -> 둘 이상의 예외를 throw할 수도 있음

-Excetpion 종류
-
Throwable을 상속하는 예외 클래스는 3가지 종류로 나뉜다.
1. Error 클래스를 상속하는 예외 클래스
: 가상머신에 오류가 발생하는 VM Error  혹은 입출력 관련해서 코드 수준 복구가 불가능한 오류인 IO error

2. Exception 클래스를 상속하는 예외 클래스
: 실제로 예외 처리를 try~catch를 통해 진행해야하는 예외 클래스 

3. RuntimeException 클래스를 상속하는 예외 클래스
:Arithmetic E, ClassCast E ,IndexOutOfBounds E , NullPointer E 등 실제로 예외처리를 하지 않아도 되고 실질적으로 코드를 수정해야하는 예외들

**Exception을 상속하는** 클래스를 정의하여 사용자가 정의하는 예외 클래스를 만들 수 있고. 특정 조건에서 **throw new Exceptionname** 을 통해 예외를 만든다

```

import java.util.Scanner;

class ReadAgeExectpion extends Exception{
    public ReadAgeExectpion(){
        super("유요하지 않은 나이가 입력됨");  //상위 클래스 생성자로 문자열 전달-> Throwable 에 정의된 getMessage 호출시 반환됨
    }
}
public class MyexceptionClass {
    public static void main(String[] a){
        System.out.print("나이 입력: ");

        try{
            int age=readAge();
            System.out.printf("입력된 나이: %d \n",age);
        }
        catch(ReadAgeExectpion e){
            System.out.println(e.getMessage());
        }
    }
    public static int readAge() throws ReadAgeExectpion{
        Scanner a= new Scanner(System.in);
        int age=a.nextInt();
        if(age<0)
        {
            throw new ReadAgeExectpion();
        }
        return age;
    }

}
```
잘못된 catch 구문의 구성
-
한 예외를 상속하는 또다른 예외가 있다고 할때 예외를 처리하는 try~catch문의 구성에는 주의가 필요하다. 예를 들어

class FirstException extends Exception{};
class SecondException extends Exception{};
class ThirdException extends Excetpion{};

이처럼 상속되는 구조를 갖는경우 catch문을
catch(FirstException e}{}
catch(SecondException e}{} catch(ThirdException e){} 처럼 구성하면 첫번째예외가 가장 상위의 예외이기에 모든 예외들이 해당 인자로 처리되어 두번째 세번째 예외에 대한 처리를 하지 못한다. 

따라서 catch문의 순서를 3->2->1순서로 하위 예외를 먼저 처리하게 구성해야한다.

finally 구문
-
try와 함께 쓰이는 구문으로 코드의 실행이 try안으로 진입하면 예외가 발생하든 안하든 무조건 실행하는 코드 블럭이다. (ex 파일입출력에서 파일을 닫는 close()를 finally문 안에 넣음)

->이 경우 finally문 안에서도 예외가 발생한다면 그 안에서도 예외처리를 해줘야하는데 코드의 길이가 길어질 수 있다.

이를 보완하기 위해 예외를 만드는 리소스에 대한 종료문(close)이 필요한경우 try-with resource문을 사용 할 수 있는데 try를 메소드 처럼 사용하는 것으로 종료의 과정을 필요로하는 리소스를 try(resource)로 try의 소괄호 안에 넣어서 사용한다

이렇게하면 해당 리소스가 try문을 빠져나가면서 자동으로 종료가된다.  

**예외처리 구문은 다른 코드에 비해 속도가 느려 성능의 저하로 이어지므로 불필요한 예외처리는 지양한다.**











