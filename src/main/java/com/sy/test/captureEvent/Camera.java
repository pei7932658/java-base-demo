package com.sy.test.captureEvent;

import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2024/8/22 10:33
 * @Modified By:
 * @Version: 1.0
 */
@Data
public class Camera {
    private String id;
    private String location;

    public Camera(String id, String location) {
        this.id = id;
        this.location = location;
    }
}
