-wrapper class: 기본자료형의 값을 감싸는 클래스 
-
int형이나 double형 실수 같은 기본자료형의 값들을 인스턴스로 표현해야 하는 경우가 있는데 이 경우 사용하는게 래퍼 클래스이다.

기본자료형에 대한 wrapper 클래스와 생성자

Boolean pulic Boolean(boolean v)
Character public Character(char v)
Byte public Byte(byte v)
Short public Short(short v)
Integer public Integer(int v)
Long public Long(long v)
Float public Float(float v)
Double public Double(double v)

값을 인스턴스에 감싸는 행위를 박싱이라고하고 꺼내는 행위를 언박싱이라고한다.

**래퍼 인스턴스들은 담고 있는 값을 수정하지 못한다** 따라서 값의 수정이 필요하면 새로운 래퍼 인스턴스를 생성해야한다. 

-오토 박싱, 오토 언박싱
-
박싱과 언박싱이 필요한 상황에서 자동처리하기 시작함 
```
 Integer iObj=10; //오토 박싱
        Double dObj=20.5;
        
        int num1=iObj;
        double num2=dObj;
```
