package greedyAlgorithm.P_2012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);	//예상 등수 기준 오름차순 정렬

        long answer = 0;	//최악의 경우 Int형의 범위를 초과하기 때문에 long으로 설정!

        //예상등수 높은 것부터 등수 선정 진행 및 불만도 더하기
        for(int i = 0; i < N; i++) {
            answer += Math.abs(arr[i] - (i + 1));
        }

        bw.write(answer + "");	//불만도의 합 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}
