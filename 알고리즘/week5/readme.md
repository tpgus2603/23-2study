이번주차에서는 bfs 플로이드 mst 그래프 다익스트라 까지 그래프 문제위줄 풀었는데 다익스트라 부분에서 어려운 문제가 많았다. 그중 특히 다익스트라를 변형한 2번쨰 최단경로와 k번째 최단경로를 묻는 문제가 가장 어려웠다


5719 거의 최단 경로: https://www.acmicpc.net/problem/5719
-

기존 다익스트라와 완전히 다른 문제이다. 제일 최적의 경로를 구하는 경우가 대다수지만 이 문제의 경우는 최적의 경로의 모든 간선을 제외한 경로중 최적을 구해야 한다.

또한 최적의 경로가 여러가지가 있을 수 있다. 따라서 처음에는 최적의 경로를 다익스트라로 구하고 테이블로 각 경로에 대한 값을 저장한다음 다시한번 다익스트라를 사용하여 테이블 보다 작은 경우만 경로를 갱신하도록

하였으나 이렇게 되는 경우 기존 최적경로의 간선을 사용할 수 있어 정답이 아니게된다. 따라서 최적의 경로에 사용된 모든 간선을 따로 마킹한다음 그 간선을 제외한 간선들 중 최적의 경로를 구해야한다.

따라서 인접리스트를 만들때 간선의 크기와 정점 뿐만 아니라 간선을 식별 할 수 있는 고유 id를 추가한 3가지의 멤버를 가지는 구조체 tuple을 사용해야 했다.

이후 인접리스트 말고도 나중에 다익스트라를 통해 구한 최적경로 기반으로 다시 역추적할 별도의 리스트가 필요하는데 이를 위해 인접리스트와 정점 순서가 반대인 별도의 리스트를 만들고 

그 리스트를 기반으로 최적경로를 역추적하여 사용된 간선들을 모두 구하는데 이때 자료구조 queue를 사용하여 최종 도착지와 연결된 간선중에서 최적경로의 테이블 값과 일치하는 경우를 큐에 집어넣고 해당 간선들의 id를 최적경로 간선 마킹을 한다.


 1854 k번쨰 최단 경로  https://www.acmicpc.net/problem/1854
 -
 이 문제역시 기존 다익스트라를 변형해야 하는 문제인데 결론적으로 자료구조 heap을 배열로 사용하여 한다.

 그 이유는 시작 정점과 특정 정점과의 연결된 코스트 중에서 정확히 k번째를 구하기 위해 최대 heap을 이용하여 heap속에 모든 경로중 제일 작은 k개

 만 딱 넣어서 heap의 top에 위치하는 값을 이용해 k번째 경로를 구하는 방식이 해당문제의 스케일의 시간복잡도를 o(eloge)에 맞출 수 있는 유일한 방법

 이기 떄문이다.  heap을 활용하여 다익스트라를 사용하는 구체적인 방법은 먼저 경로 크기 저장용 최대힙과 다익스트라 알고리즘 구현용 최소 힙 두가지를

 사용해야한다. 시작 경로를 최소 힙에 넣는 과정을 동일하지만 이후 연결된 간선을 힙에 넣는 방식이 완전 다른데 

 최소힙에서 꺼낸 현재 간선의 최적경로 값에 연결된 간선 값을 더한 후 연결된 간선에 해당하는 정점의 힙의 크기가 k이하인 경우는 그냥 넣고

 k를 넘어가고 연결된 간선의 최대힙의 가장 큰 원소가 cost값 보다 크면 원소를 pop하고 갱신한다.
