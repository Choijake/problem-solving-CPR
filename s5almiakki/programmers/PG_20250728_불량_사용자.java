import java.util.*;

public class PG_20250728_불량_사용자 {

    class Solution {

        private String[] userIds;
        private boolean[] selected;
        private String[] bannedIds;
        private Set<Set<String>> occasions = new HashSet<>();

        private void init(String[] userIds, String[] bannedIds) {
            this.userIds = userIds;
            this.selected = new boolean[userIds.length];
            this.bannedIds = bannedIds;
        }

        public int solution(String[] user_id, String[] banned_id) {
            init(user_id, banned_id);
            Set<String> occasion = new HashSet<>();
            dfs(occasion, 0);
            return occasions.size();
        }

        private void dfs(Set<String> occasion, int bannedIdIdx) {
            if (occasion.size() == bannedIds.length) {
                occasions.add(Set.copyOf(occasion));
                return;
            }
            for (int i = 0; i < userIds.length; i++) {
                if (selected[i] || !matches(userIds[i], bannedIds[bannedIdIdx])) {
                    continue;
                }
                occasion.add(userIds[i]);
                selected[i] = true;
                dfs(occasion, bannedIdIdx + 1);
                occasion.remove(userIds[i]);
                selected[i] = false;
            }
        }

        private boolean matches(String userId, String bannedId) {
            int bannedIdLength = bannedId.length();
            if (userId.length() != bannedId.length()) {
                return false;
            }
            for (int i = 0; i < bannedIdLength; i++) {
                char bannedLetter = bannedId.charAt(i);
                if (bannedLetter == '*') {
                    continue;
                }
                if (bannedLetter != userId.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

    }

}
