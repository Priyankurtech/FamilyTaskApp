package com.family.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Calendar {
    String taskname;
    String taskdes;
    LocalDateTime startdate;
    LocalDateTime enddate;
}
