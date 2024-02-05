와일드 카드
-
**<?>** 기호로 활용  제네릭과 유사하게  타입인자를 더 범용성 있게 받을 수 있게한다. 와일드 카드는 코드를 간결하게 만든다
ex)
public static <T> void peekBox<Box<T> box) -> 제네릭 기반 메소드
public static void peekBox<Box<?> box) ->와일드 카드 기반 메소드

와일드 카드는 **상한**과 **하한** 제한으로 종류가 나뉜다. 

**상한 제한된 와일드카드(upper bounded)** : 하위 클래스인 제네릭 타입의 인스턴스만 전달되도록 제한 할때 사용하는 와일드카드
Box<? extends Number> box
-> box는 Box<T>를 인스턴스를 참조하는 참조변수
T는 Number 혹은 Number를 상속하는 하위 클래스여야한다.

**하한 제한된 와일드카드(lower bounded)** : 상위클래스인 제네릭 타입의 인스턴스만 전달되도록 제한 할때 사용하는 와일드카드

Box<? super Integer> box
-> box는 Box<T> 인스턴스를 참조하는 참조변수이다.
->Box<T> 인스턴스의 T는 Integer 혹은 Integer가 상속하는 상위클래스여야 한다. 이 경우 타입인자는 Integer, Number, Object로 제한되낟. 
