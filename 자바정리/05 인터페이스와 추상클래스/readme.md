-interface(인터페이스)
-
연결점,접점 즉 둘 사이를 연결하는 매개체를 뜻하며 추상화에 쓰임 

interface는 메소드의 본체가 비어 있는 추상 메소드로 이루어져있다. 다른 클래스에 의해 implement(구현)되는데 한 클래스는 둘 이상의 인터페이스를 동시에 구현할 수 있으며 상속과 구현은 동시에 가능하다. 또한 인터페이스의 모든 메소드는 public이 선언된 것으로 간주한다. 

인터페이스를 구현하는 클래스는 추상 메소드를 모두 오버라이딩 한다. 클래스의 선언부에 **implement**를 붙여서 인터페이스를 구현한다

ex) class Robot extends Machine implements Movable,Runnable

인터페이스는 참조변수의 타입으로 사용 할 수있고 해당 인터페이스를 직,간접적으로 구현하는 모든 클래스의 인스턴스를 참조할 수 있으며 메소드를 호출하는 경우 메소드 오버라이딩이 적용된 메소드가 호출된다. 

cf)인터페이스의 직접구현-> 인터페이스에 implement하여 추상메소드를 구현하는 경우 , 간접구현: 인터페이스를 구현한 클래스를 상속하는 경우 

인터페이스 내에 선언된 변수는 반드시 선언과 동시에 값으로 초기화를 해야하며 모든 변수는 public ,static ,final이 선언된 것으로 간주한다.

-인터페이스 상속
-
확장성 있는 개발을 위하여 인터페이스 간에도 상속이 가능하다.(extend로명시)

디폴트 메소드: default로 선언된 메소드로 자체로 완전한 메소드이며 구현하는 클래스가 반드시 오버라이딩 하지는 않아도 되며 선택적으로 오버라이딩하여 구현한다. ->인터페이스에 추상메소드를 추가해야 하는 상황에서 이전 개발코드에 영향을 미치지 않기 위함 (별도의 인터페이스 추가 필요x)

static메소드: 인터페이스에도 static메소드를 넣는것이 가능해졌다. 추상메소드가 아니므로 오버라이딩 할 필요없이 인터페이스 이름으로 호출 가능하다.

인터페이스 대상으로 instanceof연산을 할 수 있는데 A instanceof B 인 경우 A가 B를 직,간접적으로 구현한 클래스의 인스턴스일때 true를 반환한다. 

-Marker Interface 
-
클래스에 특별한 표식을 다는 용도 해당 인터페이스를 구현했는지 안했는지에 따라 어떤 메소드의 형태가 달라짐.. 마커 인터페이스는 주로 아무 메소드가 존재하지 않는 경우가 많다.

-Abstract Class(추상클래스)
-
하나 이상의 추상 메소드를 갖는 클래스 선언부에 **abstract**를 붙임 추상 클래스를 대상으로는 인스턴스 생성이 불가능하며 다른 클래스에 의해 상속되어 오버라이딩을 통해 구현한다.  구상 메소드(메소드가 완전히 구현된)를 가질 수 있다.


상속,추상 ,인터페이스 요령
-
-클래스를 만들려 할때 그 클래스가 A는 B다 테스트를 통과 할수 없다면 그냥 클래스를 만듬

-더 구체적인 버전을 만들고 어떤 메소드를 오버라이드 하거나 새로운 메소드를 추가해야 한다면 하위 클래스를 만든다.

-일련의 하위 클래스에서 사용할 틀을 정의하거나 모든 하위 클래스에서 사용할 코드가 있거나 그 유형의 객체를 절대 만들 수 없게 하고싶다면 클래스를 추상클래스로 만든다.

- 상속 트리의 위치에 상관없이 어떤 클래스의 **역할**을 정의하고 싶을때 인터페이스 사용 



