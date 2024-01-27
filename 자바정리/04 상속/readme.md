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
