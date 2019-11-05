package com.ykf.suanfa.gamecentertest;

import lombok.Data;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-08-07 16:54
 */
@Data
public class ParamInfo {
    private String clientDevice;
    private Integer elapsedTime;
    private String gameId;
    private String gameOverTime;
    private String platform;
    private Integer score;
    private Integer scoreTimeMix;
    private Integer stars;
    private Integer steps;
    private String userId;
    private String pos;
}