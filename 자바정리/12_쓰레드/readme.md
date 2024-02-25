쓰레드
-
프로세스 내에서 실행중인 또다른 실행의 흐름을 말한다. 

Thread ct= Thread.currentThread();를 통해 메인 함수에서 실행하는 쓰레드를 지칭하는 쓰레드의 참조값을 얻을 수 있다.

새로운 쓰레드의 실행과정 

1단계 : Runnable 구현한 인스턴스 생성

2단계 Thread인스턴스 생성

3단계 Start메소드 호출 

예시코드
```

class MakeThread {
  public static void main(String[] args) {
    Runnable task=()-> { 
      int n1=10;
      int n2=20;
      String name =Thread.currentThread().getName();   
      System.out.println(name+": "+(n1+n2));
    };
    Thread t=new Thread(task);
    t.start();
    System.out.println("End"+Thread.currentThread().getName());

  }
}
```
쓰레드에서 일을 하는 주체는 Runnable 인터페이스를 구현하는 인스턴스가 된다. 이 인스턴스는 void run( )이라는 메소드를 구현한다 

Thread의 생성자는 다음과 같다.

public Thread(Runnable target, String name) 두번째 인자를 통해 쓰레드의 이름을 지정할 수 있다. 

또한 쓰레드 클래스의 sleep 메소드를 통해 쓰레드의 실행 속도를 늦출 수 있다 

혹은 Thread를 상속하는 클래스를 정의하고 해당 클래스에서 run 메소드를 오버라이딩 하여 바로 그 클래스를 통해 일하는 run객체가 들어있는 쓰레드와 유사하게 생성 할 수 있다.

-쓰레드 동기화문제
-
둘 이상의 쓰레드가 하나의 메모리 공간에 접근하여 예상과는 다르게 프로그램이 작동 할 수있다. 따라서 이를 해결하기 위해 동기화를 해야한다. 동기화가 된 메소드는 메소드가 끝날때 까지 한 쓰레드만 해당 메소드에 접근 할 수 있게한다. 

**synchronized**를 붙인  **동기화 메소드**를 통해 쓰레드의 동기화 문제를 해결 할 수 있다.

이러면 메소드에서 동기화가 불필요한 부분까지 동기화를 하는 단점이 있는데 synchronized 블록을 통해 동기화가 필요한 부분만 동기화를 할 수도있다.  




