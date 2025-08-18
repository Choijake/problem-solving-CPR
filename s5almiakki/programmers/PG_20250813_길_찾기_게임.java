import java.util.*;

public class PG_20250813_길_찾기_게임 {

    class Solution {

        private List<List<Integer>> visitedIndices = new ArrayList<>();

        {
            for (int i = 0; i < 2; i++) {
                visitedIndices.add(new ArrayList<>());
            }
        }

        public int[][] solution(int[][] nodeinfo) {
            Node[] nodes = new Node[nodeinfo.length];
            for (int i = 0; i < nodeinfo.length; i++) {
                nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            }
            Arrays.sort(nodes);
            Node root = nodes[0];
            for (int i = 1; i < nodes.length; i++) {
                root.addChild(nodes[i]);
            }
            visitPreorder(root);
            visitPostorder(root);
            int[][] result = new int[2][nodeinfo.length];
            for (int i = 0; i < 2; i++) {
                List<Integer> indices = visitedIndices.get(i);
                for (int j = 0; j < indices.size(); j++) {
                    result[i][j] = indices.get(j);
                }
            }
            return result;
        }

        private void visitPreorder(Node node) {
            visitedIndices.get(0).add(node.idx);
            if (node.left != null) {
                visitPreorder(node.left);
            }
            if (node.right != null) {
                visitPreorder(node.right);
            }
        }

        private void visitPostorder(Node node) {
            if (node.left != null) {
                visitPostorder(node.left);
            }
            if (node.right != null) {
                visitPostorder(node.right);
            }
            visitedIndices.get(1).add(node.idx);
        }

        private static class Node implements Comparable<Node> {

            int idx;
            int value;
            int height;
            Node left;
            Node right;

            public Node(int idx, int value, int height) {
                this.idx = idx;
                this.value = value;
                this.height = height;
            }

            public void addChild(Node child) {
                if (child.value < this.value) {
                    if (this.left == null) {
                        this.left = child;
                        return;
                    }
                    left.addChild(child);
                } else {
                    if (this.right == null) {
                        this.right = child;
                        return;
                    }
                    right.addChild(child);
                }
            }

            @Override
            public int compareTo(Node other) {
                return (this.height != other.height)
                        ? (other.height - this.height)
                        : (this.value - other.value);
            }

        }

    }

}
