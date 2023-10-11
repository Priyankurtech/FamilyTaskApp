package com.family.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class AddTaskEvent {
	
    String taskname;
    String taskdes;
    String tstatus;
    LocalDateTime startdate;
    LocalDateTime enddate;
}
