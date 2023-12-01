package stringExpression.P_9996;

import java.io.*;

public class Other {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();		//패턴
        String[] seperated = pattern.split("\\*");	//*을 기준으로 두개의 문자열로 나누기 (*로 나누려면 역슬래쉬 2개 붙여줘야함)

        for (int i = 0; i < N; i++) {
            String str_elem = br.readLine();		//검증할 파일 이름
            //*을 뺀 패턴 문자열보다 검증할 파일 이름 길이가 짧으면 검증이 안됨
            if (seperated[0].length() + seperated[1].length() > str_elem.length()) {
                System.out.println("NE");
                continue;
            }

            String front = str_elem.substring(0, seperated[0].length());	//파일이름 앞부분
            String back = str_elem.substring(str_elem.length()-seperated[1].length(), str_elem.length());	//파일이름 뒷부분

            if (front.equals(seperated[0]) && back.equals(seperated[1])) {	//앞, 뒤 모두 패턴과 같다면 일치
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}