class PG_스킬트리 {
    static String skill;
    static String[] skill_trees;
    public int solution(String skill, String[] skill_trees) {
        this.skill = skill;
        this.skill_trees = skill_trees;

        int count = 0;
        for(String tree : skill_trees){
            if(check(tree))count++;
        }

        return count;
    }

    public boolean check(String tree){
        boolean[] visited = new boolean[skill.length()];

        char[] tArr = tree.toCharArray();

        tree_loop:
        for (char c : tArr) {
            char[] sArr = skill.toCharArray();
            for (int j = 0; j < sArr.length; j++) {
                if (c == sArr[j]) {
                    visited[j] = true;
                    for (int k = j; k >= 0; k--) {
                        if (!visited[k]) {
                            return false;
                        }
                    }
                    continue tree_loop;
                }
            }
        }
        return true;
    }
}