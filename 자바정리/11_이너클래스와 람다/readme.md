-네스티드 클래스
-
  클래스 내에 정의된 클래스를 가리켜 네스티드 클래스라고 하고 이를 감싸는 클래스를 외부 클래스라고 한다. 
class Outer{
  class Nested{}   //네스티드 클래스
}
  클래스내에 정의된 모든 클래스를 네스티드 클래스라고 하는데 이는 Static 네스티드 클래스와 Non-static 네스티드 클래스(이너클래스) 두가지로 나뉜다.

**static 네스티드 클래스** : static 선언이 갖는 특성이 반영된 클래스로 외부 클래스의 인스턴스와 상관없이 해당 클래스의 인스턴스 생성 가능

static 네스티드 클래스 내에서 외부 클래스의 인스턴스 변수와 메소드에 접근하는것은 불가능 하다. 

**이너클래스** :  멤버 클래스 , 로컬 클래스 , 익명 클래스 세가지로 이루어져있다. 

멤버 클래스: 인스턴스 변수,인스턴스 메소드와 동일한 위치에 정의됨

```
class Outer{
  class MemberInner{ } 멤버 클래스

  void method() {
    class LocalInner{ }     -> 로컬 클래스
  }
}
```


**멤버 클래스**는 Outer클래스를 기반으로 생성되며 외부클래스의 인스턴스의 변수에 접근이 가능하고 종속적이다. 클래스의 정의를 감추려 할때 인터페이스와 같이 많이 사용됨 

-> private로 선언된 멤버 클래스는 감싸는 클래스 내에서만 생성이 가능하다. 즉 getter메소드를 만들어아한다.
```
interface Printable{
    void print();
}

public class Papers {
    private String con;
    public Papers(String s){con=s;}
    public Printable getPrinter(){
        return new Printer();
    }
    private class Printer implements Printable{
        public void print(){
            System.out.println(con);
        }
    }
}
class UseMemberInner{
    public static void main(String[] a)
    {
        Papers p =new Papers("서류 내용 :행복합니다");
        //Printable prn= p.new Printer();
        Printable prn= p.getPrinter();   -> getPrinter 메소드가 반환하는 인스턴스가 바뀌어도 외부 클래스를  수정 할 필요가 없게된다. 또한 외부에서는 어떤 인스턴스의 참조값을 반환하는지 아지 못한다. 
        prn.print();
    }
}

```

**로컬 클래스**: 중괄호 내에 ,특히 메소드 내에 정의 됨 -> 메소드 내에서만 인스턴스 생성이 가능 따라서 클래스의 private 선언이 크게 의미가없다.   
```
public class Papers {
    private String con;
    public Papers(String s){con=s;}
    public Printable getPrinter(){
        class Printer implements Printable{
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer();
    }
```




**익명 클래스** 
클래스의 이름을 숨기고 구현하는 인터페이스의 이름 혹은 상위 클래스 이름 만 사용한다. -> 인스턴스화 되는 지점에서 인라인으로 정의된다. 

new 키워드 뒤에 증괄호 세트와 더불어 인터페이스인 경우 메소드 구현을 포함하고 하위 클래스인경우 메소드를 재정의 할 수 있다. 

```
    public Printable getPrinter(){
        class Printer implements Printable{
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer();
    }
->
     public Printable getPrinter(){
        return new Printable(){  //클래스의 몸체를 덧 붙힘 
            public void print(){//  구현해야하는 메소드
                System.out.println(con);
            }
        };
    }

    
```

람다(->)
-
익명클래스와 유사하게 인스턴스를 생성하는데 코드를 간결하게 만드는 기법 ,클래스의 정의 및 인터페이스의 구현을 생략할 수 있다. 즉 -> 기호를 통해 인터페이스를 구현하는 인스턴스의 생성 및  추상메소드 구현을 동시에 할 수 있다

람다식에는 인터페이스의 추상메소드의 매개변수와 구현한 메소드가 중괄호 안에 나타나는데  메소드 이름과 관련된 정보를 생략할 수 있다. ,또한 람다식은 매개변수인자로 전달 될 수 있다. 

```
interface Printable{
    void print(String s);
}
class lamda{
    public static void ShowString(Printable prn,String s)
    {
        prn.print(s);
    }
    public static void main(String  [] a){
        Printable prn=(String s)->{System.out.println(s);};
        prn.print(("What is lamda?"));
        ShowString((String s)->{System.out.println(s);},"What is lamda2");
    }
}
```

위의 형태는 기본적인 람다식으로 매개변수의 타입을 생략 할 수 있다. 또한 메소드의 **몸체가 하나의 문장(세미 콜론 기준)으로 이루어져 있다면** 중괄호를 생략 할 수있다. 또한**매개변수가 하나라면** 소괄호도 생략 할 수있다.

**s-> System.out.println(s)** 이렇게 되면 중괄호를 생략하면서 중괄호 안에 있는 세미콜론도 같이 지우게된다. 

매개변수가 있고 값을  반환하는 람다식은 다음과 같이 되는데 return문이 메소드 몸체에 들어가면 그 문장이 하나여도 중괄호를 생략 할 수 없다.

Cal c=(a,b)-> {return a+b;}};    이 경우엔 매개변수 a와 b를 인자로 하고 메소드에서 a+b를 반환한다. 

위의 문장처럼 **return 문이 메소드 몸체를 이루는 유일한 문장**인 경우 return문과 중괄호가 생략가능하다.

Cal c=(a,b)-> a+b   ;

매개변수가 없는 람다식은 매개변수를 표현하는 소괄호 안을 비우면 된다. 

이렇게 하나의 추상 메소드가 존재하는 인터페이스를 **함수형 인터페이스**라고 한다.람다식은 이러한 함수형 인터페이스를 대상으로만 가능하다. 

제네릭으로 정의된 인터페이스는 람다식을 만들때 참조변수의 형을 지정해서 문장을 구성해야한다.

ex> Cal<Integer> c= (a,b)-> a+b;

함수형 인터페이스는 다양하게 존재하는데 그중에서도 Predicate<T>와 Supplier<T> , Consumer<T>, Function<T,R>이 많이 사용된다 java.utill.function 패키지에 존재한다. 

**Predicatea<T>** : 전달된 인자를 판단하여 true또는 false를 반환해야할때 사용한다. boolean test<T t> ; 메소드를 구현한다.

**Supplier<T>** : 단순히 무엇인가를 반환해야 할 때 유용하게 사용된다. T get() 추상메소드가 존재한다. 

**Consumer<T>** : 전달된 인자 기반으로 반환 이외의 다른 결과를 보일때 void accept(T t)  추상메소드가 존재한다.

**Function<T,R>**: 전달 인자와 반환 값이  모두 존재할 때 쓰인다. R apply(T t) 추상메소드가 존재한다. 

```
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] srt){
        Function<String,Integer> f= s-> s.length();
        System.out.println(f.apply("robot"));
    }
}
```








