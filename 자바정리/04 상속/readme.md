-상속
-
기존에 정의된 클래스에 메소드와 변수를 추가하여 새로운 클래스를 정의하는것 상위 클래스를 상속하는 클래스를 하위 클래스라고 한다.

하위 클래스는 상위 클래스의 멤버를 그대로 가져온다. 따라서 하위 클래스 인스턴스를 생성시 상위 클래스 변수역시 적절히 초기화해야 한다.

또한 하위 클래스의 인스턴스 생성 시 상위 클래스, 하위 클래스의 생성자 모두 호출되며 상위 클래스의 생성자가 먼저 호출된다.

**super**을 통해 상위 클래스의 생성자를 명시적으로 호출한다. 

상위 클래스의 생성자는 하위 클래스 생성자의 몸체 부분 앞에 실행되어야하며 따라서 super를 이용한 상위 생성자 호출은 하위 생성자의 첫 문장으로 들어간다. 

java에서는 **단일 상속**만을 지원하지만 상속의 깊이가 더해지는것은 가능하다

-
클래스 변수와 클래스 메소드는 상속의 대상이 아니다 . 하지만 하위 클래스는 상위 클래스 내의 클래스 변수에 **변수이름** 으로 접근이 가능하지만 private으로 선언된 경우는 불가능하다.

-IS-A관계
-
하위클래스는 상위 클래스의 모든 특성을 지닌다. 거기에 더하여 하위 클래스는 자신만의 추가적인 특성을 더하게 된다.  **하위 클래스 is-a 상위 클래스**

**상위 클래스의 참조변수는 하위 클래스의 인스턴스를 참조할 수 있다.**

ex) 스마트폰  폰 is a 모바일 폰  스마트폰은 모바일폰이 갖는 기능을 모두 갖는다. 

```
public class MobilePhone {
    protected String number;

    public MobilePhone(String num)
    {
        number=num;
    }
    public void answer(){
        System.out.println("Hi~ from "+number);
    }
}
class SmartPhone extends MobilePhone{
    private String androidver;
    public SmartPhone(String num,String ver)
    {
        super(num); //상위 생성자 호출
        androidver=ver;
    }
    public void playApp()
    {
        System.out.println("App is running in "+androidver);
    }
}
class MobileSmartphone{
    public static void main(String[] a)
    {
        SmartPhone phone=new SmartPhone("010-3001-3233","Nougat");
        phone.answer();
        phone.playApp();
    }
}
```
-참조변수의 타입
-


상위 클래스타입 참조변수로 하위 클래스 인스턴스를 참조하는 경우 상위 클래스에 정의된 메소드는 호출 가능하지만 하위 클래스의 메소드는 호출 불가능하다. -> 참조하는 인스턴스에 상관없이 참조변수의 타입에 맞춰 메소드 호출이 가능(코드를 단순화함)

** 참조변수가 참조하는 인스턴스의 종류에 상관없이 참조변수 타입에 해당하는 클래스와 그 클래스가 상속하는 상위 클래스에 정의된 메소드만 호출 가능**

상위클래스 참조변수로 하위 클래스 참조변수 참조 가능하지만 하위 클래스 참조변수로 상위 클래스 참조변수 참조는 불가능(실제 참조한 인스턴스의 타입이 아니라 참조변수C의 타입으로만 결정) 

**상위 타입의 참조변수에 대한 형변환을 통해 하위 클래스 참조변수로 상위 클래스 참조변수 참조가 가능**   cf)일반적으로는 하위 클래스 타입에 상위 클래스로 형변환을 한다, 실제 객체와 일치하지 않는 경우 ClassCast E가 발생
```
Cake ca1= new CheeseCake();
Cheesecake ca2= (CheeseCake)ca2
```

-메소드 오버라이딩
-
**상위 클래스에서 정의된 메소드를 하위 클래스에서 다시 정의하는것 **

상위 클래스를 상속하면서 메소드 이름, 메소드 반환타입 ,메소드 매개변수 선언 모두 같은 경우 메소드 오버라이딩 성립

**참조변수의 형에 상관없이 실제로 참조한 인스턴스가 마지막으로 오버라이딩 한 메소드가 호출된다.**

오버라이딩 과정에서 반환타입이 상속하는 상위클래스인 메소드는  하위클래스의 반환형으로 수정할 수 있다.  

메소드 오버라이딩을 통해 접근지시자의 접근 범위를 넓히는것이 가능하다 ex) protected -> public   반대로 좁히는 것은 불가능

 cf) super를 이용하여 오버라이딩되기전 상위 클래스의 메소드 호출이 가능하다.    변수를 비롯하여 클래스 메소드,클래스 변수는 오버라이딩의 대상이 아니다 

 ```
public class cake {
    void yummy(){
        System.out.println("Yummy cake");
    }
}
class CheeseCake extends cake{
    void yummy(){
        super.yummy();
        System.out.println("Yummy CheeseCake");
    }
}

class YummyCakeOverriding{
    public static void main(String[] a){
        cake ca1=new CheeseCake();
        CheeseCake ca2=new CheeseCake();

        ca1.yummy();ca2.yummy();
    }
}
```

-instanceof 연산자 
-
참조변수가 참조하는 **인스턴스**의 클래스 혹은 상속하는 클래스를 묻는 bool 타입을 반환하는 연산자.(참조변수의 타입이 아닌 실제 참조한 인스턴스의 타입이 기준이다)

-> 명시적 형 변환의 가능성을 판단해주는 연산자 


-상속의 활용
-
여러가지 하위 클래스에 대한 상위 클래스를 정의 함으로써 공통 규약을 적용하고 하나의 타입으로 여러 인스턴스를 참조 할 수 있다(다형성).

모든 클래스는 **Object**클래스를 상속한다. 

접근수준 지시자 뒤에 **final**을  선언하여 해당 클래스를 다른 클래스가 상속하지 않게 한다. 또한 메소드에 final을 붙이면 해당 메소드를 다른 클래스에서 오버라이딩 할 수 없다.

**@override(어노테이션)**을 활용하여 오버라이드 실수를 줄일 수 있다. ->오버라이드 어노테이션은 컴파일러에게 해당 메소드가 상위 클래스의 메소드를 오버라이딩 할 목적으로 정의했음을 알린다. 















