package com.hengo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Hengo.
 * @since 2018/6/2 19:12
 */
@Getter
@Setter
@ToString
public class SearchLogDto {

    private Integer type; // LogType

    private String beforeSeg;

    private String afterSeg;

    private String operator;

    private Date fromTime;//yyyy-MM-dd HH:mm:ss

    private Date toTime; //yyyy-MM-dd HH:mm:ss

}
