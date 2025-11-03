import java.util.*;

public class PG_20251101_3차_방금그곡 {

    class Solution1 {

        private static final List<String> STRING_NOTES = List.of(
                "C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B", "B#"
        );
        private static final Map<String, Integer> NOTE_TO_INT_MAP = new HashMap<>();

        static {
            for (int i = 0; i < STRING_NOTES.size(); i++) {
                NOTE_TO_INT_MAP.put(STRING_NOTES.get(i), i);
            }
        }

        public String solution(String m, String[] musicinfos) {
            List<Integer> memorizedNotes = toIntegerNotes(m);
            int maxDuration = 0;
            String answer = "(None)";
            for (String musicInfo : musicinfos) {
                String[] splitted = musicInfo.split(",");
                int startTime = toIntTime(splitted[0]);
                int endTime = toIntTime(splitted[1]);
                int duration = endTime - startTime;
                if (duration < memorizedNotes.size() || duration <= maxDuration) {
                    continue;
                }
                List<Integer> playedNotes = toIntegerNotes(splitted[3]);
                while (playedNotes.size() < duration) {
                    playedNotes.addAll(playedNotes);
                }
                playedNotes = playedNotes.subList(0, duration);
                if (contains(playedNotes, memorizedNotes)) {
                    answer = splitted[2];
                    maxDuration = duration;
                }
            }
            return answer;
        }

        private int toIntTime(String h, String m) {
            return Integer.parseInt(h) * 60 + Integer.parseInt(m);
        }

        private int toIntTime(String[] hm) {
            return toIntTime(hm[0], hm[1]);
        }

        private int toIntTime(String hm) {
            return toIntTime(hm.split(":"));
        }

        private List<Integer> toIntegerNotes(String notes) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < notes.length() - 1; i++) {
                if (notes.charAt(i + 1) != '#') {
                    result.add(NOTE_TO_INT_MAP.get(notes.substring(i, i + 1)));
                    continue;
                }
                result.add(NOTE_TO_INT_MAP.get(notes.substring(i, i + 2)));
                i++;
            }
            String last = notes.substring(notes.length() - 1);
            if (!last.equals("#")) {
                result.add(NOTE_TO_INT_MAP.get(last));
            }
            return result;
        }

        private boolean contains(List<Integer> playedNotes, List<Integer> memorizedNotes) {
            int baseLimit = playedNotes.size() - memorizedNotes.size();
            if (baseLimit < 0) {
                return false;
            }
            for (int base = 0; base <= baseLimit; base++) {
                boolean equals = true;
                for (int offset = 0; offset < memorizedNotes.size(); offset++) {
                    Integer playedNote = playedNotes.get(base + offset);
                    Integer memorizedNote = memorizedNotes.get(offset);
                    if (!playedNote.equals(memorizedNote)) {
                        equals = false;
                        break;
                    }
                }
                if (equals) {
                    return true;
                }
            }
            return false;
        }

    }

    class Solution2 {

        private static final List<String> STRING_NOTES = List.of(
                "C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B", "B#"
        );
        private static final Map<String, Character> NOTE_TO_CHAR_MAP = new HashMap<>();

        static {
            for (int i = 0; i < STRING_NOTES.size(); i++) {
                NOTE_TO_CHAR_MAP.put(STRING_NOTES.get(i), (char) ('A' + i));
            }
        }

        public String solution(String m, String[] musicinfos) {
            String memorizedNotes = convertNotes(m);
            int maxDuration = 0;
            String answer = "(None)";
            for (String musicInfo : musicinfos) {
                String[] splitted = musicInfo.split(",");
                int startTime = toIntTime(splitted[0]);
                int endTime = toIntTime(splitted[1]);
                int duration = endTime - startTime;
                if (duration < memorizedNotes.length() || duration <= maxDuration) {
                    continue;
                }
                StringBuilder playedNotes = new StringBuilder(convertNotes(splitted[3]));
                while (playedNotes.length() < duration) {
                    playedNotes.append(playedNotes);
                }
                playedNotes = playedNotes.delete(duration, playedNotes.length());
                if (playedNotes.toString().contains(memorizedNotes)) {
                    answer = splitted[2];
                    maxDuration = duration;
                }
            }
            return answer;
        }

        private int toIntTime(String h, String m) {
            return Integer.parseInt(h) * 60 + Integer.parseInt(m);
        }

        private int toIntTime(String[] hm) {
            return toIntTime(hm[0], hm[1]);
        }

        private int toIntTime(String hm) {
            return toIntTime(hm.split(":"));
        }

        private String convertNotes(String notes) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < notes.length() - 1; i++) {
                if (notes.charAt(i + 1) != '#') {
                    result.append(NOTE_TO_CHAR_MAP.get(notes.substring(i, i + 1)));
                    continue;
                }
                result.append(NOTE_TO_CHAR_MAP.get(notes.substring(i, i + 2)));
                i++;
            }
            String last = notes.substring(notes.length() - 1);
            if (!last.equals("#")) {
                result.append(NOTE_TO_CHAR_MAP.get(last));
            }
            return result.toString();
        }

    }

}
