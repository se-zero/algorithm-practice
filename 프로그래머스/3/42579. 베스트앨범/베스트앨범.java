import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // 노래 정보 객체
    static class Song {
        int id;
        int plays;

        public Song(int id, int plays){
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수
        Map<String, Integer> genreTotalMap = new HashMap<>();
        // 장르별 어떤 노래가 있는지 담는 맵
        Map<String, List<Song>> genreSongsMap = new HashMap<>();

        // 맵에 데이터 채우기
        for (int i = 0; i < genres.length; i++) {
            if(!genreTotalMap.containsKey(genres[i])) {
                genreTotalMap.put(genres[i],plays[i]);

                List<Song> list = new ArrayList<>();
                list.add(new Song(i, plays[i]));
                genreSongsMap.put(genres[i], list);
            } else {
                int count = genreTotalMap.get(genres[i]) + plays[i];
                genreTotalMap.put(genres[i], count);

                genreSongsMap.get(genres[i]).add(new Song(i,plays[i]));
            }
        }

        // 가장 많이 재생된 장르 순으로 정렬
        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        genreList.sort((g1, g2) -> genreTotalMap.get(g2) - genreTotalMap.get(g1));

        List<Integer> answer = new ArrayList<>();
        
        // 장르별 노래 정렬, 상위 2곡씩 뽑기
        for (String genre : genreList){
            List<Song> songs = genreSongsMap.get(genre);

            songs.sort((s1,s2) -> {
                if(s1.plays == s2.plays) {
                    return s1.id - s2.id;
                } else {
                    return s2.plays - s1.plays;
                }
            });
            
            answer.add(songs.get(0).id);

            if (songs.size() > 1) {
                answer.add(songs.get(1).id);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;

    }
}