import java.util.*;

public class PG_20250619_모의고사 {
    
    class Solution {
        
        public int[] solution(int[] answers) {
            Student[] students = {
                new Student(new int[] {
                    1, 2, 3, 4, 5
                }),
                new Student(new int[] {
                    2, 1, 2, 3, 2, 4, 2, 5
                }),
                new Student(new int[] {
                    3, 3, 1, 1, 2, 2, 4, 4, 5, 5
                })
            };
            for (int i = 0; i < answers.length; i++) {
                for (Student student : students) {
                    if (answers[i] == student.getGuessedAnswer(i)) {
                        student.increaseCorrectCnt();
                    }
                }
            }
            int maxCorrectCnt = 0;
            for (Student student : students) {
                int correctCnt = student.getCorrectCnt();
                if (maxCorrectCnt < correctCnt) {
                    maxCorrectCnt = correctCnt;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < students.length; i++) {
                if (maxCorrectCnt == students[i].getCorrectCnt()) {
                    result.add(i + 1);
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
        
        static class Student {
            
            private int[] guessedAnswers;
            private int correctCnt = 0;
            
            public Student(int[] guessedAnswers) {
                this.guessedAnswers = guessedAnswers;
            }
            
            public int getGuessedAnswer(int idx) {
                return guessedAnswers[idx % guessedAnswers.length];
            }
            
            public void increaseCorrectCnt() {
                this.correctCnt++;
            }
            
            public int getCorrectCnt() {
                return this.correctCnt;
            }
            
        }
        
    }
    
}
