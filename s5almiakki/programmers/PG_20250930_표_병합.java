import java.util.*;

public class PG_20250930_표_병합 {

    class Solution {

        public String[] solution(String[] commands) {
            Cell[][] table = new Cell[50][50];
            List<String> answer = new ArrayList<>();
            for (int row = 0; row < 50; row++) {
                for (int col = 0; col < 50; col++) {
                    table[row][col] = new Cell(row, col);
                }
            }
            for (String command : commands) {
                String[] splittedCommand = command.split(" ");
                int row1, col1, row2, col2;
                switch (splittedCommand[0]) {
                    case "UPDATE":
                        if (splittedCommand.length == 4) {
                            row1 = Integer.parseInt(splittedCommand[1]) - 1;
                            col1 = Integer.parseInt(splittedCommand[2]) - 1;
                            table[row1][col1].findRoot().value = splittedCommand[3];
                        } else {
                            for (Cell[] cells : table) {
                                for (Cell cell : cells) {
                                    if (splittedCommand[1].equals(cell.value)) {
                                        cell.value = splittedCommand[2];
                                    }
                                }
                            }
                        }
                        break;
                    case "MERGE":
                        row1 = Integer.parseInt(splittedCommand[1]) - 1;
                        col1 = Integer.parseInt(splittedCommand[2]) - 1;
                        row2 = Integer.parseInt(splittedCommand[3]) - 1;
                        col2 = Integer.parseInt(splittedCommand[4]) - 1;
                        if (row1 != row2 || col1 != col2) {
                            table[row1][col1].union(table[row2][col2]);
                        }
                        break;
                    case "UNMERGE":
                        row1 = Integer.parseInt(splittedCommand[1]) - 1;
                        col1 = Integer.parseInt(splittedCommand[2]) - 1;
                        Cell root = table[row1][col1].findRoot();
                        String tempValue = root.value;
                        List<Cell> targetCells = new ArrayList<>();
                        for (Cell[] row : table) {
                            for (Cell cell : row) {
                                if (cell.findRoot().equals(root)) {
                                    targetCells.add(cell);
                                }
                            }
                        }
                        for (Cell cell : targetCells) {
                            cell.parent = null;
                            cell.value = null;
                        }
                        table[row1][col1].value = tempValue;
                        break;
                    case "PRINT":
                        row1 = Integer.parseInt(splittedCommand[1]) - 1;
                        col1 = Integer.parseInt(splittedCommand[2]) - 1;
                        String value = table[row1][col1].findRoot().value;
                        answer.add(value == null ? "EMPTY" : value);
                        break;
                }
            }
            return answer.toArray(new String[0]);
        }

        private static class Cell {

            int row;
            int col;
            Cell parent = null;
            String value = null;

            public Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }

            public void union(Cell cell) {
                Cell root1 = this.findRoot();
                Cell root2 = cell.findRoot();
                if (root1.equals(root2)) {
                    return;
                }
                String newValue = null;
                if (root1.value != null) {
                    newValue = root1.value;
                } else if (root2.value != null) {
                    newValue = root2.value;
                }
                this.value = null;
                cell.value = null;
                root2.parent = root1;
                root2.value = null;
                root1.value = newValue;
            }

            public Cell findRoot() {
                if (parent == null) {
                    return this;
                }
                this.parent = parent.findRoot();
                return this.parent;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (!(o instanceof Cell)) {
                    return false;
                }
                Cell other = (Cell) o;
                return this.row == other.row && this.col == other.col;
            }

            @Override
            public int hashCode() {
                return Objects.hash(row, col);
            }

        }

    }

}
