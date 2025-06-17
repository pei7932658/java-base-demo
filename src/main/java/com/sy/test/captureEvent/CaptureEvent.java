package com.sy.test.captureEvent;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2024/8/22 10:33
 * @Modified By:
 * @Version: 1.0
 */
@Data
public class CaptureEvent {
    private String personId;
    private String cameraId;
    private LocalDateTime captureTime;

    public CaptureEvent(String personId, String cameraId, LocalDateTime captureTime) {
        this.personId = personId;
        this.cameraId = cameraId;
        this.captureTime = captureTime;
    }
}
