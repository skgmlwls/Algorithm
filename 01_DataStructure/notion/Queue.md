# 🚚 Queue (큐)

큐(Queue)는 **먼저 들어간 데이터가 먼저 나오는** **FIFO(First In, First Out)** 규칙을 따르는 선형 자료구조입니다.

---

## 📌 규칙: FIFO

- **FIFO** = First In, First Out
- **예시**
    1. **마트 계산대** : 줄을 선 순서대로 계산
    2. **운영체제 프로세스 스케줄링**
        - 커널이 작업 요청을 받은 순서대로 큐에 저장
        - CPU는 큐에서 **순서대로** 꺼내서 처리 → **FIFO 스케줄링**

---

## ⚙️ 큐의 기본 연산 (ADT)

| 연산          | 설명                                  |
|---------------|---------------------------------------|
| `enqueue()`   | 데이터를 **삽입** (큐에 추가)          |
| `dequeue()`   | 데이터를 **제거** (큐에서 꺼냄)         |
| `front()`   | 큐의 가장 앞 데이터를 참조 (조회만) |
| `isEmpty()`   | 큐가 비어 있는지 확인                  |

---

## 🔎 동작 과정 예시

> **데이터 1 → 2 → 3 → 4** 순서대로 삽입,  
> **head** 가 큐의 **앞**(front)을 가리킨다고 가정


- **단일 연결리스트 + head만** 보유 시
    - **삽입(enqueue)**: `head` 앞에 O(1)
    - **제거(dequeue)**: 마지막 노드까지 순회 후 제거 → **O(n)**

---

## ⚠️ 단점 및 성능 개선

| 접근 방법 | 삽입 | 제거 | 문제점 |
|-----------|------|------|--------|
| **head만 보유** (단일 리스트) | O(1) | **O(n)** | 마지막 노드 찾기 위해 매번 순회 |
| **head + tail** (단일 리스트) | O(1) | O(1) (꺼냄)<br>**하지만** 삭제 후 새 tail을 찾기 위해 **O(n)** | 여전히 전체 순회 필요 |
| **head + tail** (이중 연결리스트) | **O(1)** | **O(1)** | 이전 노드 포인터 덕분에 즉시 tail 갱신 |

> ✅ **해결책** : **이중 연결리스트**(Doubly Linked List)를 사용해 `tail.prev`로 이전 노드를 즉시 찾으면 **삽입·제거 모두 O(1)** 달성 가능

---

## ✅ 요약

| 항목            | 내용                                                |
|-----------------|-----------------------------------------------------|
| 핵심 규칙       | FIFO (First In, First Out)                          |
| 주요 연산       | enqueue, dequeue, peek, isEmpty                     |
| 대표 활용       | 마트 줄서기, 운영체제 프로세스 스케줄링             |
| 성능 개선 포인트| `tail` 포인터 + **이중 연결리스트**로 O(1) 제거 구현 |
