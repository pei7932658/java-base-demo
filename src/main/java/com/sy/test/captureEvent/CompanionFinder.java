package com.sy.test.captureEvent;

import org.springframework.util.StopWatch;

import java.time.Duration;
import java.util.*;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2024/8/22 10:37
 * @Modified By:
 * @Version: 1.0
 */
public class CompanionFinder {
    // 用于存储每个人在同一设备下同行的人的统计结果
    static class CompanionStat {
        private String personId;
        private String cameraId;
        private Set<String> companions = new HashSet<>();

        public CompanionStat(String personId, String cameraId) {
            this.personId = personId;
            this.cameraId = cameraId;
        }

        public void addCompanion(String companionId) {
            companions.add(companionId);
        }

        @Override
        public String toString() {
            return "Person ID: " + personId + ", Camera ID: " + cameraId + ", Companions: " + companions;
        }
    }

    public static Map<String, List<CompanionStat>> findCompanions(List<CaptureEvent> events) {
        //根据设备聚类
        Map<String, List<CaptureEvent>> eventsByCamera = new TreeMap<>();
        for (CaptureEvent event : events) {
            eventsByCamera.computeIfAbsent(event.getCameraId(), k -> new ArrayList<>()).add(event);
        }

        Map<String, List<CompanionStat>> result = new HashMap<>();

        for (Map.Entry<String, List<CaptureEvent>> entry : eventsByCamera.entrySet()) {
            List<CaptureEvent> sortedEvents = entry.getValue();
            Collections.sort(sortedEvents, Comparator.comparing(CaptureEvent::getCaptureTime));

            String cameraId = entry.getKey();
            CaptureEvent prevEvent = null;

            for (CaptureEvent event : sortedEvents) {
                if (prevEvent != null &&
                        //前后2s出现的人
                        Duration.between(prevEvent.getCaptureTime(), event.getCaptureTime()).getSeconds() <= 2) {
                    String personId = event.getPersonId();
                    String companionId = prevEvent.getPersonId();

                    // 使用 Java 8 的 Optional.isPresent()
                    List<CompanionStat> personStats = result.getOrDefault(personId, new ArrayList<>());
                    boolean found = false;
                    for (CompanionStat stat : personStats) {
                        if (stat.cameraId.equals(cameraId)) {
                            stat.addCompanion(companionId);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        CompanionStat companionStat = new CompanionStat(personId, cameraId);
                        companionStat.addCompanion(companionId);
                        personStats.add(companionStat);
                    }
                    result.put(personId, personStats);

                    // 对称地添加（如果需要）
                    List<CompanionStat> companionStats = result.getOrDefault(companionId, new ArrayList<>());
                    boolean companionFound = false;
                    for (CompanionStat stat : companionStats) {
                        if (stat.cameraId.equals(cameraId)) {
                            stat.addCompanion(personId);
                            companionFound = true;
                            break;
                        }
                    }
                    if (!companionFound) {
                        CompanionStat companionStat = new CompanionStat(companionId, cameraId);
                        companionStat.addCompanion(personId);
                        companionStats.add(companionStat);
                    }
                    result.put(companionId, companionStats);
                }
                prevEvent = event;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        List<CaptureEvent> captureEventList = generator.generateData();

        StopWatch stopWatch = new StopWatch("计算同行");
        stopWatch.start();
        Map<String, List<CompanionStat>> result = findCompanions(captureEventList);

        result.forEach((personId, stats) -> {
            System.out.println("Person ID: " + personId);
            for (CompanionStat stat : stats) {
                System.out.println(stat);
            }
            System.out.println("--------------------");
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
