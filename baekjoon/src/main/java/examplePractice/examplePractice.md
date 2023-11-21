# 백준 Java 답안 제출 방법

## 1. public 클래스는 단 하나 'Main', 패키지는 없어야 한다.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //... 생략
}
```

## 2. Main 이외의 클래스는 public이 아니다. Inner 클래스 사용 가능하다.
```java
class Pos {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    class Node {
        int n, dist;
        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
    
    private void solution() throws Exception {
        Pos p = new Pos(1, 2);
        Node node = new Node(r, 45);
    }
    
}

```

## main 함수 내부에서 사용하는 전역변수 및 함수는 모두 static

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int max = 0;
    private static int n, k;
    private static int[] arr;

    private static void dfs(int cnt, int num) {
        if (cnt == 8) {
            return;
        }
    }

    //... 중략
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
    
        // ... 중략
    }
    
}
```
## main 함수의 래핑과 static 멤버 변화

```java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int max = 0;
    private int n, k;
    private int[] arr;

    private void dfs(int cnt, int num) {
        if (cnt == 8) {
            return;
        }
    }

    //... 중략
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
    
        // ... 중략
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

```

## 입력 시 BufferedReader와 StringTokenizer를 활용
더 빠른 입력을 위해서는 아래 링크를 참고
https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/


## 입력을 위해 System.in을 사용한 클래스는 하나만 존재해야 한다.
백준에서 실제로 입력되는 것은 파일이며, Scanner, BufferedReader 모두 미리 일정량을 읽어들인 후 사용자의 요청(readLine() 등)에 따라 해당 버퍼에서 꺼내온다. 

## 출력 시 BufferedWriter, StringBuilder를 활용

## 자바로 풀 수 없는 문제, 또는 자바로 풀 수 있지만 난이도가 매우 상승하는 문제도 간혹 있다.


