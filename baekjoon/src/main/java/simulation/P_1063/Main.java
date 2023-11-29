package simulation.P_1063;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    String king;
    String rock;

    class MovingObject{

        int col, row;
        public MovingObject(String spot) {
            this.col = (int) (spot.charAt(0));
            this.row = Integer.parseInt(spot.substring(1));
        }

        @Override
        public String toString() {
            return "MovingObject{" +
                    "col=" + col +
                    ", row=" + row +
                    '}';
        }

        private void permitCommand(String move) {

            if (Objects.equals(move, "R")) {
                this.col = this.col + 1;
                if (this.col > (int)'H') {
                    this.col -= 1;
                    return;
                }
            }

            if (Objects.equals(move, "L")) {
                this.col = this.col - 1;
                if (this.col < (int)'A') {
                    this.col += 1;
                    return;
                }
            }

            if (Objects.equals(move, "T")) {
                this.row = this.row + 1;
                if (this.row > 8) {
                    this.row -= 1;
                    return;
                }
            }

            if (Objects.equals(move, "B")) {
                this.row = this.row - 1;
                if (this.row < 1) {
                    this.row += 1;
                    return;
                }
            }

            if (Objects.equals(move, "RT")) {
                this.col = this.col + 1;
                this.row = this.row + 1;
                if (this.col > (int)'H' || this.row > 8) {
                    this.col -= 1;
                    this.row -= 1;
                    return;
                }
            }
            if (Objects.equals(move, "LT")) {
                this.col = this.col - 1;
                this.row = this.row + 1;
                if (this.col < (int)'A' || this.row > 8) {
                    this.col += 1;
                    this.row -= 1;
                    return;
                }
            }

            if (Objects.equals(move, "RB")) {
                this.col = this.col + 1;
                this.row = this.row - 1;
                if (this.col > (int)'H' || this.row < 1) {
                    this.col -= 1;
                    this.row += 1;
                    return;
                }
            }

            if (Objects.equals(move, "LB")) {
                this.col = this.col - 1;
                this.row = this.row - 1;
                if (this.col < (int)'A' || this.row < 1) {
                    this.col += 1;
                    this.row += 1;
                    return;
                }
            }
        }

    }



    private String location(int col, int row) {
        String loc_col = Character.toString((char) col);
        String loc_row = Integer.toString(row);
        String loc = loc_col.concat(loc_row);
        return loc;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken();
        rock = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        List<String> command = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            command.add(br.readLine());
        }

        MovingObject king_obj = new MovingObject(king);
        MovingObject rock_obj = new MovingObject(rock);

//        System.out.println("king obj : "+king_obj.toString()+"  (초기화)  ");

        for (String instruction : command) {
            int origin_king_col = king_obj.col;
            int origin_king_row = king_obj.row;
            king_obj.permitCommand(instruction);
//            System.out.println("instruction : "+instruction +"     king obj : "+king_obj.toString()+"  (1)  ");
            if (king_obj.col == rock_obj.col && king_obj.row == rock_obj.row) {
                int origin_col = rock_obj.col;
                int origin_row = rock_obj.row;
                rock_obj.permitCommand(instruction);
//                System.out.println("instruction : "+instruction +"     rock obj : "+rock_obj.toString()+"  (2)  ");
                if (rock_obj.col == origin_col && rock_obj.row == origin_row) {
                    king_obj.col = origin_king_col;
                    king_obj.row = origin_king_row;
//                    System.out.println("instruction : "+instruction +"     king obj : "+king_obj.toString()+"  (3)  ");
                }
            }
//            System.out.println("instruction : "+instruction +"     king obj : "+king_obj.toString()+"  (4)  ");
        }

        String last_loc_king = location(king_obj.col, king_obj.row);
        String last_loc_rock = location(rock_obj.col, rock_obj.row);
        System.out.println(last_loc_king);
        System.out.println(last_loc_rock);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}



