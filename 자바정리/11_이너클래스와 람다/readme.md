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

람다
-
















