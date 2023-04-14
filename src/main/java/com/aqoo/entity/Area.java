package com.aqoo.entity;

import lombok.Data;

/**
 * @ClassName Area
 * @Description
 * @Date 2023/4/11 14:17
 * @Version 1.0
 */
@Data
public class Area {
    private Long id;
    //分割区域进行编号
    private Integer location;
    //区域总亮度，从1-100表示
    private Integer areaLuminance;
}
