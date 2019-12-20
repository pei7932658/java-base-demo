package com.sy.eventBus.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/12/20 13:39
 * @Modified By:
 */
@Data
@AllArgsConstructor(staticName = "of")
public class CustomEvent {

    private int age;

}
