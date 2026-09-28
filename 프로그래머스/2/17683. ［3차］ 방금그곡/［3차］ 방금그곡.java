class Solution {
    public String solution(String m, String[] musicinfos) {

        // # 치환
        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");

        int maxPlayTime =  -1;
        String musicName = "(None)";

        for (String music : musicinfos){
            // 콤마 기준 정보 4등분
            String[] info = music.split(",");

            // 재생 시간 계산
            String[] start = info[0].split(":");
            int startHH = Integer.parseInt(start[0]);
            int startMM = Integer.parseInt(start[1]);

            String[] finish = info[1].split(":");
            int finishHH = Integer.parseInt(finish[0]);
            int finishMM = Integer.parseInt(finish[1]);

            int duration = (finishHH - startHH) * 60 + (finishMM - startMM);

            // # 치환
            info[3] = info[3].replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");

            // 실제 방송된 멜로디 생성
            StringBuilder playMusic = new StringBuilder();
            int musicLength = info[3].length();
            for (int i = 0; i < duration; i++) {
                playMusic.append(info[3].charAt(i%musicLength));
            }

            // 방송된 멜로디에 기억하는 멜로디 포함 여부
            if(playMusic.toString().contains(m)) {
                if(maxPlayTime < duration){
                    maxPlayTime = duration;
                    musicName = info[2];
                }
            }
        }

        return musicName;
    }
}