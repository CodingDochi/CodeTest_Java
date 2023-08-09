# 시간 복잡도

알고리즘의 효율성은 알고리즘의 수행 시간 또는 알고리즘이 수행하는 동안 사용되는 메모리 공간의 크기로 나타낼 수 있습니다. 이들을 각각 시간복잡도, 공간복잡도로 나타낼 수 있습니다.

시간복잡도는 알고리즘이 수행하는 기본적인 연산 횟수를 입력 크기에 비례한 함수로 표현합니다.

예를 들어, 숫자 카드가 10장이 있고 이 중에서 최대 숫자를 찾는데, 순차 탐색으로 찾는 경우에 숫자 비교가 기본적인 연산이고, 숫자 비교가 9번입니다.

숫자 카드가 만약에 n장이 있다면, 숫자 비교는 n -1 번을 하므로 n -1이 시간복잡도가 됩니다.

# 복잡도 분석 방식

## 최악 경우 분석
'어떤 입력이 주어지더라도 알고리즘의 수행시간이 얼마 이상은 넘지 않는다'라는 상한(Upper Bound)의 의미
보통 최악의 경우로 시간복잡도를 나타냅니다.

## 평균 경우 분석
입력의 확률 분포를 가정하여 분석하는데, 일반적으로 균등 분포(Uniform Distribution)를 가정

## 최선 경우 분석
가장 빠른 수행 시간을 분석하며, 최적(Optimal) 알고리즘을 찾는데 활용

## 상각 분석 
일련의 연산을 수행하여 총 수행 시간을 합하고 이를 연산 횟수로 나누어 수행 시간을 분석

[조건]: 알고리즘에서 적어도 두 종류의 연산이 수행되고, 그 중 하나는 수행 시간이 길고, 다른 하나는 짧으며, 수행 시간이 짧은 연산은 많이 수행되고, 수행 시간이 긴 연산은 적게 수행되어야 상각 분석이 의미를 갖는다.


※ 복잡도를 분석하는 방법은 시간복잡도 표기법과는 상관이 없습니다.


# 시간 복잡도의 점근적 표기법

입력 크기 n이 무한대로 커질 때의 복잡도를 간단히 표현하기 위해 사용하는 표기법

## 빅 오 : 점근적 상한
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Ftahax%2FbtqF9moXVED%2F35fpkZk9Vf4kTgHQr9aMDk%2Fimg.png)

<p>f(n) = 2n<sup>2</sup> + 8n + 3</p>

시간 복잡도를 나타내는 위 함수를 단순화하여 c &times; n<sup>2</sup> (단, c > 0 인 임의의 상수) 로 표현할 수 있다. 

이 때, f(n)의 n이 n<sub>0</sub>이상이 된다면, f(n)은 c &times; n<sup>2</sup> 보다 절대 커질 수 없다. 즉, n<sub>0</sub>은 n의 f(n)과 c &times; n<sup>2</sup>의 교차점인 셈이다. 

이러한 상한 관계가 있을 때, f(n) = O(<sup>2</sup>) 로 표기 가능하다.


## 빅 오메가 : 점근적 하한
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbpT12a%2FbtqF7uVQzEc%2FOqnbIpVVTnMqzK9ZgfZ4E1%2Fimg.png)

<p>f(n) = 2n<sup>2</sup> + 8n + 3</p>

시간 복잡도를 나타내는 함수가 위와 같을 때, f(n) = Ω(n<sup>2</sup>) 로 표기 가능하다. 빅 오 표기와 같아 보이지만, 'n이 증가함에 따라 f(n)은 c &times; n<sup>2</sup> 보다 작을 수 없다'는 점근적 하한을 나타낸다.  

## 빅 세타
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fq1bNp%2FbtqF7MaX34Q%2FtBzUj49xMRpkUWtknOV8E1%2Fimg.png)

θ-표기는 O-표기와 Ω-표기가 같은 경우에 사용한다. 

이는 'f(n)은 n이 증가함에 따라 n<sup>2</sup>와 동일한 증가율을 가진다'는 의미이다.

f(n) = θ(n<sup>2</sup>)로 표기할 수 있다.