-컬렉션프레임워크
-
여러 자료구조들이 담겨있는 플레임워크들의 집합 **Collection<E>** 를 상속하는 클래스들과 Map<k,v>등이 있음

컬렉션을 상속하는 클래스
Set<E> , List<E> Queue<E>

Collection<E>는 인터페이스 iterable<T>를 구현하는데  이 인터페이스는 iterater()라는 메소드를 통해 반복자(일종의 포인터)를 반환한다.
itr.next() , itr.hasNext() itr.remove()를 통해 반복자를 이동시키고 참조값을 반환한다.  

Set<E>을 상속하는 HashSet<E>의 경우 중복 저장이 허용되지 않는 hash함수를 지니는 자료구조이며 
**hashCdoe()와 equals()** 메소드를 적절히 오버라이드 해야 참조값이 아닌 인스턴스값을 기준으로 중복 판정이 가능하다.
Object에 정의된 **public static int hash( Object v)**를 활용하면 인자에 맞는 적절한 해쉬 값을 반환한다 .

TreeSet<E>는 정렬 상태가 유지되는 Set으로 인터페이스 Comparable<T>를 구현하는 방식으로 인스턴스의 정렬 기준을 정한다. 
