package com.sy.guava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@ToString
public class Token {

    private String token;

    private Long ttl;
}
