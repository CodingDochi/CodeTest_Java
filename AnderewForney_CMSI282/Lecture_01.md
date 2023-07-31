# Problem Solving

## Forward

### What is an algorithm?
**A formalized procedure for accomplishing some task**

## Search

**Combinatorial Search(조합 검색)** (or just Search for short) is the study of algorithms that attempt to solve problems with a large number of potential solutions.

이러한 가능성 중에서 절차적으로 해결책을 *찾는* 알고리즘이 이 수업의 첫 번째 부분의 중심이 될 것입니다!

검색의 일부 영역은 인공 지능 연구에 속하지만 다른 많은 작업에도 적용될 수 있으므로 이 주제는 282에서 확실하게 다루겠습니다.

문제 해결 과정은 세 단계로 압축(be condensed to)될 수 있습니다.

1. **Formalize** the problem : 문제를 공식화하라
2. **Search** for a solution : 일부 일련의 작업을 통해 도달
3. **Execute** the plan of the action

검색 알고리즘에 사용할 수 있는 문제, 환경 및 작업을 정의하는 방법이 우리의 첫 번째 관심사(first concern)가 될 것입니다.

## Motivating Example

![](https://www.forns.lmu.build/assets/images/spring-2018/cmsi-485/week-2/search-0.PNG)

에이전트가 그리드의 특정 위치에서 시작하고 우리의 임무는 에이전트를 특정 목표 셀로 이동시키는 것인 고전적인 그리드 월드를 살펴보겠습니다.

If our agent can move Up, Down, Left, or Right, what are some solutions to this problem?

이 문제를 공식화하는 방법을 살펴보고 검색 전략을 살펴보겠습니다.