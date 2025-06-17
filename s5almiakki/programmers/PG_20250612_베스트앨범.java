import java.util.*;

public class PG_20250612_베스트앨범 {

    class Solution {

        public int[] solution(String[] genres, int[] plays) {
            Map<String, Statistics> genreStatisticses = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (genreStatisticses.get(genres[i]) == null) {
                    genreStatisticses.put(genres[i], new Statistics());
                }
                genreStatisticses.get(genres[i]).addMusicRecord(new MusicRecord(i, plays[i]));
            }
            return genreStatisticses.entrySet().stream()
                    .sorted((entry1, entry2) ->
                            entry2.getValue().getTotalPlayCnt() - entry1.getValue().getTotalPlayCnt())
                    .flatMapToInt(entry ->
                    		entry.getValue().getMusicRecords().stream()
                                    .sorted((musicRecord1, musicRecord2) ->
                                    		musicRecord2.getPlayCnt() - musicRecord1.getPlayCnt())
                                    .limit(2)
                                    .mapToInt(MusicRecord::getId))
                    .toArray();
        }

        private class Statistics {

            private int totalPlayCnt = 0;
            private List<MusicRecord> musicRecords = new ArrayList<>();

            public void addMusicRecord(MusicRecord musicRecord) {
                totalPlayCnt += musicRecord.getPlayCnt();
                musicRecords.add(musicRecord);
            }

            public int getTotalPlayCnt() {
                return this.totalPlayCnt;
            }

            public List<MusicRecord> getMusicRecords() {
                return this.musicRecords;
            }

        }

        private class MusicRecord {

            private int id;
            private int playCnt;

            public MusicRecord(int id, int playCnt) {
                this.id = id;
                this.playCnt = playCnt;
            }

            public int getId() {
                return this.id;
            }

            public int getPlayCnt() {
                return this.playCnt;
            }

        }

    }

}
