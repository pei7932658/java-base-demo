package com.sy.test.captureEvent;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2024/8/22 10:34
 * @Modified By:
 * @Version: 1.0
 */
@Data
public class DataGenerator {
    private static final Random random = new Random();

    // 生成模拟数据
    public static List<CaptureEvent> generateData() {
        List<CaptureEvent> events = new ArrayList<>();

        // 假设有10个人
        String[] personIds = new String[10];
        for (int i = 0; i < 10; i++) {
            personIds[i] = "Person" + (i + 1);
        }

        // 假设有5个摄像头
        List<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera("Camera1", "Office 1"));
        cameras.add(new Camera("Camera2", "Office 2"));
        cameras.add(new Camera("Camera3", "Office 3"));
        cameras.add(new Camera("Camera4", "Office 4"));
        cameras.add(new Camera("Camera5", "Office 5"));
//        cameras.add(new Camera("Camera6", "Office 6"));
//        cameras.add(new Camera("Camera7", "Office 7"));
//        cameras.add(new Camera("Camera8", "Office 8"));
//        cameras.add(new Camera("Camera9", "Office 9"));
//        cameras.add(new Camera("Camera10", "Office 10"));

        // 生成抓拍事件
        for (int i = 0; i < 100; i++) { // 假设生成100个抓拍事件
        //for (int i = 0; i < 100000; i++) { // 假设生成100个抓拍事件
            String personId = personIds[random.nextInt(personIds.length)];
            Camera camera = cameras.get(random.nextInt(cameras.size()));
            //LocalDateTime captureTime = LocalDateTime.now().minusMinutes(random.nextInt(1000 * 24 * 60)); // 假设是最近100天内的抓拍
            LocalDateTime captureTime = LocalDateTime.now().minusMinutes(random.nextInt(20)); // 最近20分钟内的抓拍

            events.add(new CaptureEvent(personId, camera.getId(), captureTime));
        }

        return events;
    }

    public static void main(String[] args) {
        List<CaptureEvent> events = generateData();
        for (CaptureEvent event : events) {
            System.out.println("Person ID: " + event.getPersonId() +
                    ", Camera ID: " + event.getCameraId() +
                    ", Capture Time: " + event.getCaptureTime());
        }
        System.out.println("capture data size:"+events.size());
    }
}
