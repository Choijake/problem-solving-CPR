public class PG_20250628_모음사전 {

    class Solution {

        private char[] vowels = new char[] { 'A', 'E', 'I', 'O', 'U' };
        private StringBuilder word = new StringBuilder();
        private int result = 0;
        private boolean answerFound = false;
        private String targetWord;

        public int solution(String word) {
            this.targetWord = word;
            this.dfs();
            return this.result;
        }

        private void dfs() {
            if (this.word.toString().equals(this.targetWord)) {
                this.answerFound = true;
                return;
            }
            if (this.word.length() == 5) {
                return;
            }
            for (char vowel : this.vowels) {
                if (this.answerFound) {
                    break;
                }
                this.result++;
                this.word.append(vowel);
                this.dfs();
                this.word.deleteCharAt(word.length() - 1);
            }
        }

    }

}
