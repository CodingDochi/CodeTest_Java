package breadthFirstSearching.P_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Other {

    class Node {
        Node pre;
        List<Node> post = new ArrayList<>();
        int self;

        Node(Node pre, List<Node> post, int self) {
            this.pre = pre;
            this.post = post;
            this.self = self;
        }

        Node(int self) {
            this.self = self;
        }
    }

    int total;
    int[] visited;
    int start, end;
    int edges;
    int cnt = 0;
    List<Node> family = new ArrayList<Node>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        visited= new int[total+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            family.add(new Node(i+1));
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            for (Node node : family) {
                if (node.self == parent) {
                    node.post.add(new Node(child));
                } else if (node.self == child) {
                    node.pre = new Node(parent);
                }
            }
        }

//        printFamilyStructure();
        System.out.println(traverse(start, end, 0));
    }

//    public void printFamilyStructure() {
//        for (Node node : family) {
//            System.out.println("Node " + node.self + ":");
//            System.out.println("   pre: " + (node.pre != null ? node.pre.self : null));
//            System.out.print("   post: ");
//            for (Node postNode : node.post) {
//                System.out.print(postNode.self + " ");
//            }
//            System.out.println("\n");
//        }
//    }

    public int traverse(int start, int end, int cnt) {
        Node startNode = family.get(start - 1);
        if (startNode.self == end) {
            System.out.println("inner cnt "+cnt);
            return cnt; // 첫 번째 조건이 만족되면 해당 시점의 cnt 값을 반환하고 종료
        } else {
            visited[startNode.self] = 1;

            // 형제 노드와 그들의 자식 노드를 모두 탐색
            if (startNode.pre != null && visited[startNode.pre.self] == 0) {
                traverse(startNode.pre.self, end, cnt + 1);
                visited[startNode.pre.self] = 1;

                for (Node sibling : startNode.pre.post) {
                    if (visited[sibling.self] == 0) {
                        traverse(sibling.self, end, cnt + 1); // 형제 노드 탐색
                        visited[sibling.self] = 1;

                        for (Node child : sibling.post) {
                            if (visited[child.self] == 0) {
                                traverse(child.self, end, cnt + 2); // 자식 노드 탐색
                                visited[child.self] = 1;
                            }
                        }
                    }
                }
            }

            // 후손 노드 탐색
            if (!startNode.post.isEmpty()) {
                for (Node child : startNode.post) {
                    if (visited[child.self] == 0) {
                        traverse(child.self, end, cnt + 1);
                        visited[child.self] = 1;
                    }
                }
            }
            //        System.out.println("v " + Arrays.toString(visited)+"  cnt "+cnt);
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        new Other().solution();
    }
}
