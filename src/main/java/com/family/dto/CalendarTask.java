package com.family.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class CalendarTask {
    private String taskname;
    private String taskdes;
    private String startdate;
    private String enddate;
}
