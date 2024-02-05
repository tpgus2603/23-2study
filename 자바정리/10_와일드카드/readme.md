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
