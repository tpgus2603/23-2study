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








