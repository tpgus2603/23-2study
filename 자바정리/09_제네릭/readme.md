-제네릭
-
자료형에 의존적이지 않게 클래스를 T로 정의하고 인스턴스를 생성할때 결정하는 방식 
```
class Apple{
    public String toString(){
        return "I am an apple";
    }
}
class Orange{
    public String toString(){
        return "I am an orange";
    }
}
class Box2<T>
{
    private T ob;
    public void set(T o) {
        ob = o;
    }
    public T get(){
        return ob;
    }
}

public class generic {
    public static void main(String[] args)
    {  
        Box2<Apple> aBox= new Box2<Apple>(); //T를 APPle로결정
        Box2<Orange>oBox=new Box2<Orange>();
        
        aBox.set(new Apple());
        oBox.set(new Orange());
    }
}
```
**T**를 자료형 정보를 인자로 전달 받는 형태이기 때문에  **타입 매개변수(type parameter)** 라고 한다. 

**타입인자(type arguement)** Apple이 매개변수T로 전달되어 새로운 자료형이 완성되었기 때문에 Box2<Apple>를 **매개변수화 타입 (제네릭 타입)** 이라고한다.
->타입 인자로 기본자료형은 쓰지못하고 래퍼클래스를 사용해야한다. 

-타입 인자는 <>같은 다이아몬드 기호에 의해 생략이 가능하며 이를 컴파일러가 추론한다. 
ex) Box<Apple> = new Box<>();

-또한 타입인자로 제네릭타입을 전달 할 수 있다.
```
public class BoxinBox {
    public static void main(String[] args){
        Box2<String> sBox=new Box2<>();
        sBox.set("I like kimchi");
        Box2<Box2<String>> wBox=new Box2<>();
        wBox.set(sBox);
        Box2<Box2<Box2<String>>> zBox=new Box2();
        zBox.set(wBox);
        System.out.println(zBox.get().get().get()); //최종적으로 박스에넣은 문자열 반환 
        
    }
}
```
-다중 타입 매개변수 설정도 가능하며 class DBox<L,R> 와 같이 제네릭 클래스를 설정하고
제네릭 타입을 Box<String, Integer> box=new Box<String ,Integer>()과 같이 설정한다.  

-제네릭 클래스의 타입 인자를 상속을 활용하여 제한 할 수 있다.
ex) class Box<T extends Number> 와 같이 사용하면 T는 Number를 상속하는 클래스만 타입 인자로 받게된다. 

-제네릭 클래스의 타입인자를 인터페이스로 제한 할 수 있는데. 이떄 extend interface와 같이 제한한다. 

-제네릭 메소드
-
클래스 전부가 아닌 일부 메소드에 대해서 제네릭으로 정의하는것이 가능하다. (클래스 메소드도 가능함)  -> 메소드 호출시 자료형이 결정된다. 
EX) Pulbic static <T> Box<T> makeBox(T o) -> 반환형이 Box<T>
    
    public static <T> T openBox(Box<T> box){
        return box.get();
    }
제네릭 메소드 역시 상속을 활용하여 타입 인자를 제한 할 수 있다. 

-제네릭 클래스 상속
-
제네릭 클래스의 경우 상속이 가능한데  Box<Integer>와 같은 제네릭 타입이 일종의 자료형으로써  상위 클래스로 간주되고 steelBox<Integer>이 하위 클래스로 간주된다.
```

class Box<T>{
    protected T ob;
    public void set(T o){
        ob=o;
    }
    public T get(){
        return ob;
    }
}
class steelBox<T> extends Box{
    public steelBox(T o){
        ob=o;
    }
}

public class genericInheritance {
    public static void main(String[] a){
        Box<Integer> iBox=new steelBox<>(7959);
        Box<String>sBox=new steelBox<>("Simple");
        System.out.println(iBox.get());
        System.out.println(sBox.get());
    }
}
```
그렇다면 **Box<Number> box=new Box<Integer>()** 같은 경우 Integer이 Number의 하위클래스이긴 하지만 제네릭타입 자체가 쌍으로 상속되는것이 아니기에 컴파일이 불가능하다.
하지만 **Box<Number>kBox=new steelBox<Integer>()** 같은 경우는 가능하다.

-**타켓 타입**
```
class EmptyBoxFactory{
    public static <T> Box<T> makeBox(){
        Box<T> box=new Box<T>();
        return box;
    }
}
```
컴파일러가 자료형을 유추하는 상황중 하나로 만약 제네릭 메소드에서 타입 인자가 전달되지 않는다면 

Box<Integer> iBox= EmptyBoxFactory.<Integer>makeBox();와 같이 타입인자를  <>안에 메소드 이름 옆에 표시한다.
한편 이렇게 하지않고 **Box<Integer> iBox= EmptyBoxFactory.makeBox();** 처럼 해도 컴파일이 가능한데 이 경우는 왼쪽에 선언된 Box<Integer>을 보고 컴파일러가 메소드의 타입을 유추하기 때문에 가능하다

이러한 상황에서 제네릭 메소드의 T유추에 사용된 정보 Box<Integer>을 타켓타입이라고 한다.

와일드 카드
-
**<?>** 기호로 활용  제네릭과 유사하게  타입인자를 더 범용성 있게 받을 수 있게한다. 와일드 카드는 코드를 간결하게 만든다
ex)
public static <T> void peekBox<Box<T> box) -> 제네릭 기반 메소드
public static void peekBox<Box<?> box) ->와일드 카드 기반 메소드

와일드 카드는 **상한**과 **하한** 제한으로 종류가 나뉜다. 

**상한 제한된 와일드카드(upper bounded)** : 하위 클래스인 제네릭 타입의 인스턴스만 전달되도록 제한 할때 사용하는 와일드카드 ->**꺼내는 작업(get)** 만 활용할때 자주사용

Box<? extends Number> box
-> box는 Box<T>를 인스턴스를 참조하는 참조변수
T는 Number 혹은 Number를 상속하는 하위 클래스여야한다.

public static void outBox Box<? extends Toy> box -> 인스턴스를 꺼내는 메소드인 get()은 호출 가능하지만 Toy 인스턴스를 저장하는 메소드인 set(new Toy())메소드는 호출이 불가능하게 한다. ( Box<toy> 타입을 저장 가능한지 보장이 안됨 -> 메소드의 활용제한

**하한 제한된 와일드카드(lower bounded)** : 상위클래스인 제네릭 타입의 인스턴스만 전달되도록 제한 할때 사용하는 와일드카드 ->**저장하는 작업(set)만** 활용할때 자주사용 

Box<? super Integer> box
-> box는 Box<T> 인스턴스를 참조하는 참조변수이다.
->Box<T> 인스턴스의 T는 Integer 혹은 Integer가 상속하는 상위클래스여야 한다. 이 경우 타입인자는 Integer, Number, Object로 제한되낟. 


public static void InBox Box<? super Toy> box ->  Toy 인스턴스를 저장하는 메소드인 set(new Toy())은 호출 가능하지만 Toy 인스턴스를 꺼내는 get(new Toy())메소드를 호출하여 저장하는것

Toy mytoy=box.get() 이 불가능한데 Box의 타입인자가 Toy로 확정되지 않기 떄문이다. 

 ( Box<toy> 타입을 저장 가능한지 보장이 안됨 -> 메소드의 활용제한

 **와일드 카드에서 범용성있는 상한 하한을 위해 제네릭과 혼합하여 사용이 가능하다**

public static <T> void outBox(Box? extends T> box){ };    -> 타입 매개변수 T에 대해 상속하는 와일드카드 

-제네릭 인터페이스
- 
인터페이스 역시 제네릭으로 정의가 가능하다 . 오버라이딩 할때의 추상 메소드의 타입에 맞게 구현 클래스의 타입을 정한다. 
```
interface Getable<T>{
    public T get();
}
class Box<T> implements Getable<T>{
    protected T ob;
    public void set(T o){
        ob=o;
    }
    @Override
    public T get(){
        return ob;
    }
}
```
Getable <T>형 참조변수는 T의 타입에 상관없이  이를 구현하는 클래스를 참조 할 수 있다. (Box<T>와 Gettable<T>의 타입 매개변수가 다를 수도 있음-> Getable<String>와 같이 인터페이스의 제네릭 타입이 결정된 상태 일수도 있고 그 상황에서 Box<T>는 정해지지 않아도 된다)












