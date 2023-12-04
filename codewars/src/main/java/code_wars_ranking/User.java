package code_wars_ranking;

/*

Codewars가 사용하는 것과 유사한 순위 시스템을 통해 사용자가 진행할 금액을 계산하는 데 사용되는 User라는 클래스를 작성합니다.

비즈니스 규칙:
사용자는 -8 등급에서 시작하여 8등급까지 올라갈 수 있습니다.
0(영) 순위는 없습니다. -1 다음 순위는 1입니다.
사용자는 활동을 완료합니다. 이러한 활동에도 순위가 있습니다.
사용자가 순위가 매겨진 활동을 완료할 때마다 사용자 순위 진행 상황은 활동 순위에 따라 업데이트됩니다.
완료된 활동에서 얻은 진행 상황은 사용자의 현재 순위를 활동 순위와 비교하여 결정됩니다.
사용자의 순위 진행은 0부터 시작하며 진행 상황이 100에 도달할 때마다 사용자의 순위가 다음 레벨로 업그레이드됩니다.
이전 등급에서 얻은 남은 진행 상황은 다음 등급의 진행 상황에 적용됩니다(진행 상황은 버리지 않습니다). 단, 진행할 수 있는 다른 등급이 더 이상 남아 있지 않은 경우는 예외입니다(등급 8에 도달하면 더 이상 진행되지 않습니다).
사용자는 랭크 8 이상으로 진행할 수 없습니다.
유일하게 허용되는 순위 값 범위는입니다. 다른 값은 오류를 발생시킵니다.
진행 상황은 다음과 같이 점수가 매겨집니다.

사용자와 동일한 순위의 활동을 완료하면 3포인트를 얻습니다.
사용자보다 한 순위 낮은 활동을 완료하면 1포인트를 얻습니다.
사용자의 순위보다 2단계 이상 낮은 순위로 완료된 활동은 무시됩니다.
현재 사용자의 순위보다 높은 순위의 활동을 완료하면 순위 진행이 가속화됩니다. 순위 차이가 클수록 진행도가 높아집니다. 공식은 10 * d * d입니다. 여기서 d는 활동과 사용자 간의 순위 차이와 같습니다.
논리 예:
-8 등급의 사용자가 -7 등급의 활동을 완료하면 10개의 진행 상황을 받게 됩니다.
-8 등급의 사용자가 -6 등급의 활동을 완료하면 40개의 진행 상황을 받게 됩니다.
-8 등급의 사용자가 -5 등급의 활동을 완료하면 90개의 진행 상황을 받게 됩니다.
-8 순위의 사용자가 -4 순위의 활동을 완료하면 160개의 진행 상황을 받게 되며, 그 결과 사용자는 -7 순위로 업그레이드되고 다음 순위를 향해 60의 진행 상황을 얻게 됩니다.
-1 순위의 사용자가 1 순위의 활동을 완료하면 10개의 진행 상황을 받게 됩니다(0 순위는 무시된다는 점을 기억하세요).

if (user rank == activity rank) progress += 3
if (user rank -1 == activity rank) progress += 1
if (user rank -2 == activity rank) progress += 0

if (user rank < activity rank)
activity rank - d == user rank => progress += d * d * 10

progress = 0 ~ 100, 초과 분은 다음 progress에 누적, user rank가 8일 때 progress는 0이 되어야 함.
rank range =  -8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8

User user = new User();
user.rank; // => -8
user.progress; // => 0
user.incProgress(-7);
user.progress; // => 10
user.incProgress(-5); // will add 90 progress
user.progress; // => 0 // progress is now zero
user.rank; // => -7 // rank was upgraded to -7

 */

import java.util.Arrays;

public class User {
    int[] rank_range = new int[] {-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8};
    int rank = rank_range[0];
    int progress = 0;

    public void rankUp(int progress, int o_rank, int t_rank) {
        if (t_rank == 8) { this.progress = 0; return; }
        int o_rank_idx = Arrays.binarySearch(rank_range, o_rank);
        int t_rank_idx = Arrays.binarySearch(rank_range, t_rank);
        int diff = t_rank_idx - o_rank_idx;
        if (diff < 0) {
            this.progress = this.progress + diff * diff * 10;
        } else if (diff == 0) {
            this.progress += 3;
        } else if (diff == 1) {
            this.progress += 1;
        }
        if (this.progress >= 100) {
            this.rank++;
            this.progress = this.progress - 100;
            rankUp(this.progress, o_rank, this.rank);
        }
    }

    public int incProgress(int rank) {
        rankUp(this.progress, rank, this.rank);
        System.out.println("progress: " + this.progress + " rank: " + this.rank);
        return this.progress;
    }

    public static void main(String[] args) {
        new User().incProgress(1);
    }
}
