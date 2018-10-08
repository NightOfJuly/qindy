package com.qindy.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/9/27
 */

@Data
public class KafkaMessage {

    private Long id;
    private String msg;
    private Date sendTime;

}
