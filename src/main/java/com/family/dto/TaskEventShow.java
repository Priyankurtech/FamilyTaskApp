package com.family.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class TaskEventShow {
	int taskid;
	String taskname;
    String taskdes;
    String tstatus;
    Date startdate;
    Date enddate;
}
