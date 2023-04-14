package com.aqoo.controller;

import com.aqoo.common.R;
import com.aqoo.entity.Area;
import com.aqoo.service.AreaService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AreaController
 * @Description
 * @Date
 * @Version 1.0
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/setLuminance")
    public R<String> setLuminance(@RequestBody Area area) {

        LambdaQueryWrapper<Area> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Area::getLocation, area.getLocation());
        areaService.update(area, wrapper);
        return R.success("修改成功");
    }
}
