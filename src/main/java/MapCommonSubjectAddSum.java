import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapCommonSubjectAddSum {
    public static void main(String[] args) {
        MapCommonSubjectAddSum myObj = new MapCommonSubjectAddSum();
        Map<String, Integer> scores1 = Map.of("maths", 100,
                "science", 90,
                "english", 80,
                "history", 70);
        Map<String, Integer> scores2 = Map.of("maths", 90,
                "science", 80,
                "english", 70,
                "physics", 60,
                "chemistry", 50);
        System.out.println(myObj.sumScoresOfCommonSubject(scores1, scores2));
        System.out.println(myObj.sumScoresOfAllSubjects(scores1, scores2));
        System.out.println(myObj.sumScoresOfAllSubjects2(scores1, scores2));
    }

    private Map<String, Integer> sumScoresOfAllSubjects2(Map<String, Integer> scores1, Map<String, Integer> scores2) {
        return Stream.concat(scores1.keySet().stream(), scores2.keySet().stream())
                .distinct()
                .collect(Collectors.toMap(
                        key -> key,
                        key -> scores1.getOrDefault(key, 0) + scores2.getOrDefault(key, 0)
                ));
    }

    private Map<String, Integer> sumScoresOfAllSubjects(Map<String, Integer> scores1, Map<String, Integer> scores2) {
        Map<String, Integer> sumScoresOfAllSubjects = new HashMap<>();
        sumScoresOfAllSubjects.putAll(scores1);
        scores2.forEach((key, value) -> sumScoresOfAllSubjects.merge(key, value, Integer::sum));
        return sumScoresOfAllSubjects;
    }

    public Map<String, Integer> sumScoresOfCommonSubject(Map<String, Integer> scores1, Map<String, Integer> scores2) {
        Map<String, Integer> sumScoresOfSubject = new HashMap<>();
        sumScoresOfSubject = scores1.entrySet().stream()
                .filter(entry -> scores2.containsKey(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() + scores2.get(entry.getKey())
                ));


        return sumScoresOfSubject;
    }
}
