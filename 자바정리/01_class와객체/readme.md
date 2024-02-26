1.class: c의 구조체와 비슷한 역할을 하는 객체, 인스턴스 변수와 인스턴스 메소드로 구성된다

    인스턴스 변수: 클래스 내에 선언된 변수, 지역변수와 다르게 인스턴스 변수는 같은 클래스 내에 위치한 메소드 내에서 접근이 가능하다. 

    인스턴스 메소드: 클래스 내에 정의된 메소드로 인스턴스 변수에 접근할 수 있다. 서로다른 클래스의 메소드 호출시 객체가 생성되어야 한다.

  new를 통해 클래스를 객체화 할 수 있다,  생성한 객체를 가리킬 변수가 필요한데 이를 참조변수라고 한다. ex) myAcnt1= new Bankaccount(); -> new를 통해 인스턴스를 생성하면 생성된 인스턴스의 주소값이 반환된다. 참조변수에는 생성된 인스턴스의 주소값이 저장된다.

  참조변수는 인스턴스를 참조하고 가리킨다. 

  또한 하나의 인스턴스를 두 개 이상의 참조변수가 가리키는 것도 가능하다.

  메소드를 호출하면서 인스턴스의 참조값을 전달 하는 것도 가능하다. 
  ```
public class BankAccout {
    int balance=0;
    public int checkMybalance()
    {
        System.out.println("잔액 :"+balance);
        return balance;
    }
}

class PassingRef{
    public static void main(String[] argc)
    {
        BankAccout ref=new BankAccout();
        ref.deposit(3000);
        ref.withdraw((300));
        check(ref); //참조값 전달 
    }
    public static void check(BankAccout acc){
        acc.checkMybalance();
    }
}
```

참조변수에 null을 대입하여 인스턴스와의 관계를 끊을 수 있다. ex) ref =null;

-생성자: 클래스의 이름과 동일하며 값을 반환하지않고 반환형을 표시하지 않는 메소드로  인스턴스의 초기화를 위해 자동으로 호출된다. 
```
public BankAccout(String acc,String ss,int bal){
        accNumber=acc;
        ssNumber=ss;
        balance =bal;
    }
BankAccout ref=new BankAccout("12-34-89","990990-1232345",2313);
```
-디폴트 생성자: 생성자를 정의하지 않고 클래스를 정의하면 컴파일러가 디폴트 생성자라는 것을 클래스의 정의에 넣어준다. 








  
  
