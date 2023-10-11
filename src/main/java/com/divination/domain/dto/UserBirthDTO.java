package com.divination.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBirthDTO {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    /**
     * 性别 1男 2女
     */
    private Integer gender;

}
