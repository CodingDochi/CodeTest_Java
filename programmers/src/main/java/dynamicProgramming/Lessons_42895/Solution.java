package dynamicProgramming.Lessons_42895;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;


public class Solution {

    class Operand {
        Operand right;
        Operand left;
        int N;
        int digit;
        int idx;
        int cnt;
        int init = initialize(N, digit);
        String operator;
        Operand coupled;
        List<Operand> coupling = new LinkedList<>();


        private void init_coupling(){};

        public Operand (int N, int digit) {
            this.N = N;
            this.digit = digit;
            this.init = initialize(this.N, this.digit);
        }

        private int initialize (int N, int digit) {
            double res = 0;
            for (int i = digit-1; i>=0; i--) {
                res = res + Math.pow(10, digit)*N;
            }
            cnt = cnt + digit;
            return (int) res;
        }


    }


    List<Integer> res_mem;




    class Calculation {
        int left;
        int right;
        int res = 0;
        int cnt = 0;
        Set<Integer> term;
        List<Integer> coupling;

        Calculation(int left, int right) {
            this.left = left;
            this.right = right;
            this.res = res;
            this.cnt = cnt;
        }

        private int multiple (int left, int right) {
            int res = ( this.left * this.right );
            cnt++;
            return res;
        }
        private int divide (int left, int right) {
            int res = ( this.left / this.right );
            cnt++;
            return res;
        }

        private int sum (int left, int right) {
            int res = ( this.left + this.right );
            cnt ++;
            return res;
        }

        private int sub (int left, int right) {
            int res = (this.left - this.right);
            cnt++;
            return res;
        }



    }





    public int solution(int N, int number) {

        int result = 0;

        // 마지막 계산 값인 number는


        return 0;
    }


}
