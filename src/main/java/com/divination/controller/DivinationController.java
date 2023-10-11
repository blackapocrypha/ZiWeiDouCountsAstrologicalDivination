package com.divination.controller;


import com.divination.service.StarService;
import com.nlf.calendar.Lunar;
import com.divination.domain.dto.FiveElementsBureauDTO;
import com.divination.domain.dto.UserBirthDTO;
import com.divination.util.FiveElementsBureauUtil;
import com.divination.util.FourDestinyStarshineUtil;
import com.divination.util.JsonResult;
import com.divination.util.StarBureaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class DivinationController {

    @Autowired
    private StarService starService;
    /**
     * 获取八字
     * @param userBirthDTO
     * @return
     */
    @GetMapping("/getEight")
    public JsonResult getEight(@ModelAttribute UserBirthDTO userBirthDTO){
        JsonResult jsonResult = new JsonResult();
        if(Objects.isNull(userBirthDTO.getBirth())){
            return jsonResult.buildFalse("birthday can't be null");
        }
        Map<String, List<String>> map = new HashMap();
        List<String> ganList = new ArrayList<>();
        List<String> zhiList = new ArrayList<>();

        Lunar lunar = new Lunar(userBirthDTO.getBirth());
        ganList.add(lunar.getYearGan());
        ganList.add(lunar.getMonthGan());
        ganList.add(lunar.getDayGan());
        ganList.add(lunar.getTimeGan());
        zhiList.add(lunar.getYearZhi());
        zhiList.add(lunar.getMonthZhi());
        zhiList.add(lunar.getDayZhi());
        zhiList.add(lunar.getTimeZhi());
        map.put("gan",ganList);
        map.put("zhi",zhiList);

        jsonResult.buildTrue();
        jsonResult.setData(map);
        return jsonResult;
    }


    /**
     * 斗数排盘
     * @param userBirthDTO  生辰信息
     * @return JsonResult
     */
    @PostMapping("/starDivination")
    public JsonResult starDivination(@ModelAttribute UserBirthDTO userBirthDTO){
        JsonResult jsonResult = new JsonResult();
        if(Objects.isNull(userBirthDTO.getBirth())){
            return jsonResult.buildFalse("birthday can't be null");
        }

        // 取八字
        Lunar lunar = new Lunar(userBirthDTO.getBirth());
        // 取命宫
        Integer destinyPalace = StarBureaUtil.getDestinyPalace(lunar.getMonth(), lunar.getTimeZhi());
        // 取命局
        FiveElementsBureauDTO bureauDTO = FiveElementsBureauUtil.getBureau(lunar.getYearGan(), destinyPalace);
        // 取身宫
        Integer lifePalace = StarBureaUtil.getLifePalace(lunar.getMonth(), lunar.getTimeZhi());
        // 取紫微星落宫
        Integer ziweiStar = StarBureaUtil.getZiweiStarByTable(bureauDTO.getIntSet(), lunar.getDay());
        // 取命四化
        List<String> fourStarList = FourDestinyStarshineUtil.getFourStarList(lunar.getYearGan());

        jsonResult.buildTrue();
        jsonResult.setData(starService.getZodiacWithStar(destinyPalace,ziweiStar,fourStarList,lunar,lifePalace,bureauDTO.getIntSet(),userBirthDTO.getGender()));

        return jsonResult;
    }



    /**
     * 表单提交 Date类型数据绑定
     * <功能详细描述>
     *
     * @param binder 网页数据绑定
     * @see [类、类#方法、类#成员]
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
