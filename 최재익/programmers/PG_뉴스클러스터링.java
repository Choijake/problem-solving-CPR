import java.util.*;

class PG_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        // 소문자로 변환하여 대소문자 무시
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 다중집합 생성
        List<String> list1 = makeMultiSet(str1);
        List<String> list2 = makeMultiSet(str2);

        // 두 집합이 모두 공집합인 경우
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        // 교집합과 합집합 계산
        double intersectionSize = getIntersectionSize(list1, list2);
        double unionSize = getUnionSize(list1, list2);

        // 자카드 유사도 계산 및 65536 곱한 후 정수형으로 변환
        double jaccard = intersectionSize / unionSize;
        return (int) (jaccard * 65536);
    }

    // 두 글자씩 끊어 다중집합을 만드는 메서드
    private List<String> makeMultiSet(String str) {
        List<String> multiSet = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            // 두 글자가 모두 영문자인지 확인
            if (isAlphabet(sub.charAt(0)) && isAlphabet(sub.charAt(1))) {
                multiSet.add(sub);
            }
        }
        return multiSet;
    }

    // 문자가 영문자인지 확인하는 헬퍼 메서드
    private boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z');
    }

    // 다중집합의 교집합 크기 계산
    private int getIntersectionSize(List<String> list1, List<String> list2) {
        int count = 0;
        List<String> temp2 = new ArrayList<>(list2); // list2를 복사하여 사용

        for (String element1 : list1) {
            // list2에 해당 원소가 있는지 확인하고, 있으면 교집합에 포함
            if (temp2.remove(element1)) {
                count++;
            }
        }
        return count;
    }

    // 다중집합의 합집합 크기 계산
    private int getUnionSize(List<String> list1, List<String> list2) {
        return list1.size() + list2.size() - getIntersectionSize(list1, list2);
    }
}