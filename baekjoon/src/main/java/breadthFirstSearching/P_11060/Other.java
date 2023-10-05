package breadthFirstSearching.P_11060;

import java.util.*;
import java.io.*;

public class Other {
    //미로 위치 관련 클래스
    static class position{
        int index, count;
        public position(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    static int N;
    static int[] maze;	//미로 정보 저장 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        maze = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //미로에 대한 정보 저장
        for(int i=0;i<N;i++)
            maze[i] = Integer.parseInt(st.nextToken());

        int answer = search();	//BFS탐색으로 최소 점프 횟수 저장
        bw.write(answer + "");	//최소 점프 횟수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //미로를 BFS탐색하는 함수
    static int search(){
        Queue<position> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        queue.add(new position(0, 0));
        while(!queue.isEmpty()){
            position cur = queue.poll();
            if(cur.index == N-1)	//오른쪽 끝에 도달시.
                return cur.count;
            //점프하여 각 칸을 탐색
            for(int i=1;i<=maze[cur.index];i++){
                int tempIndex = cur.index + i;
                if(tempIndex<N && !visited[tempIndex]){
                    visited[tempIndex] = true;
                    queue.add(new position(tempIndex, cur.count + 1));
                }
            }
        }
        return -1;	//오른쪽 끝에 도달 불가능시.
    }
}