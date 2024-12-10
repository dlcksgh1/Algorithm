import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 1. 장르별 총 재생 횟수 저장
        HashMap<String, Integer> genreMap = new HashMap<>(); // 장르별 총 재생 횟수
        HashMap<String, List<Song>> songMap = new HashMap<>(); // 장르별 Song 객체 저장

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 갱신
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);

            // 장르별 Song 객체 추가
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }
            songMap.get(genre).add(new Song(i, play));
        }

        // 2. 장르를 총 재생 횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        Collections.sort(sortedGenres, new Comparator<String>() {
            @Override
            public int compare(String g1, String g2) {
                return genreMap.get(g2) - genreMap.get(g1); // 내림차순
            }
        });

        // 3. 각 장르별로 상위 2곡 선택
        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = songMap.get(genre);

            // Song 클래스의 compareTo 메서드를 기반으로 정렬
            Collections.sort(songs);

            // 상위 2곡 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }

        // 4. 결과를 배열로 변환
        int[] result = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++) {
            result[i] = bestAlbum.get(i);
        }
        return result;
    }

    // Song 클래스 - Comparable 구현
    private static class Song implements Comparable<Song> {
        int id;   // 고유 번호
        int play; // 재생 횟수

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }

        // Comparable 인터페이스 구현
        @Override
        public int compareTo(Song other) {
            if (this.play != other.play) {
                return other.play - this.play; // 재생 횟수 내림차순
            } else {
                return this.id - other.id; // 고유 번호 오름차순
            }
        }
    }
}