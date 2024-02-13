-컬렉션프레임워크
-
여러 자료구조들이 담겨있는 플레임워크들의 집합인 인터페이스 **Collection<E>** 를 상속하는 인터페이스, 클래스들과 Map<k,v>등이 있음

컬렉션을 상속하는 인터페이스 
Set< E >  -> 구현 클래스 : HashSet< E > TreeSet< E >
List< E > -> 구현 클래스 : Arraylist< E > , LinkedList< E >
Queue< E >  -> 구현 클래스 : LinkedList< E > ,  
Dequue<E> -> 구현 클래스 : ArrayDequeu< E > LinkedList<E>
Vector<E> -> Stack< E >

ArrayList< E > 같은 경우  Arrays객체를 생성하여 처음에 초기화 후 다시 ArrayList 객체를 생성하고 인자로 넣는 방식으로 초기에 여러 객체를 초기화 하는게 가능하다.

```
 List<String> list=Arrays.asList("Toys","Box","Robot","Box");
        list=new ArrayList<>(list);
        list.add("str");
```

Collection<E>는 인터페이스 iterable<T>를 구현하는데  이 인터페이스는 iterator()라는 메소드를 통해 반복자(일종의 포인터)를 반환한다.
itr.next() , itr.hasNext() itr.remove()를 통해 반복자를 이동시키고 참조값을 반환한다.  

Set<E>을 구현하는 HashSet<E>의 경우 중복 저장이 허용되지 않는 hash함수를 지니는 자료구조이며 
**hashCdoe()와 equals()** 메소드를 적절히 오버라이드 해야 참조값이 아닌 인스턴스값을 기준으로 중복 판정이 가능하다. 기본적으로는 hashCode() 메소드는 인스턴스의 주소값을 기반으로 비교하게 되어있다 
Object에 정의된 **public static int hash( Object v)**를 활용하면 인자에 맞는 적절한 해쉬 값을 반환한다 .(Objects.hash() 사용)

TreeSet<E>는 정렬 상태가 유지되는 Set으로 인터페이스 **Comparable< T >** 를 구현하는 방식으로 인스턴스의 정렬 기준을 정한다.  (sort에서는 Comparable를 구현했다)

범용적인 클래스의 정렬 기준은 int compareTo(T o)  

일시적인 객체의 정렬 기준은  **Comparator< T >**  인터페이스를 구현하여 int compare(T o1 ,T o2)를 통해 기준을 정한고  이를 TreeSet의 생성자의 인자로 넣어 객체를 생성한다. ->String 같이 자바에서 제공되는 기본 클래스의 정렬 기준을 바꿀때 좋은 해결책이된다.

**List에 있는 중복된 인스턴스를 다시 HashSet에 넣고 다시 List에 넣으면 중복된 인스턴스 제거가 가능하다.**   

자바의 Queue<E> 인터페이스의 메소드는  offer(넣기) ,poll(꺼내기) ,peek(확인하기) 세가지를 사용한다. 

Queue


-Map<K,V> 인터페이스
-
**HashMap<K,V>와 TreeMap<K,V>** 두 가지 클래스가 맵 인터페이스를 구현한다.  Hash는 해쉬테이블 TreeMap은 Key의 정렬 상태를 유지하는 Map이다

map.get(Key)를 통해 저장된 Value값을 얻을 수 있다.

**TreeMap**에서는 Comparator<T>인터페이스를 기반으로 정렬 기준을 결정한다.

-컬렉션에 대한 정렬 알고리즘
-
정렬 메소드 Sort에 대해서 컬렉션 인터페이스에 따라 다양하게 메소드 오버로딩이 되어있는데 

예를 들어List<E>에 대해서는 public static <T extends Comparable < T >> void sort<List< T > list)가 있다면 , 이 경우 인자를 List<T>를 받는데 타입 매개변수T는 Comparable< T >인터페이스를 구현한 상태여야한다.

하지만 실제로 오버로딩 된 메소드는 Public static<T extends Comparablr<? super T>> void (List< T > list)로 정의되어 있는데 이 경우는 T를 포함해 T의 상위클래스가 Comparable< >를 구현한 상태여야 한다. 즉 인터페이스가 간접 구현되어 있는 경우 타입인자로 가능한것이다. 

**Comparator**기반 메소드도 존재하는데 이 경우 public static <T> void sort(List <T> list,Comparator<? superT> c) 
로 Comparator c는 T를 포함해  상위 클래스에 대한 Comparator를 구현해야 한다 즉 T는 Comparator 인터페이스를 간접 구현해야한다.



