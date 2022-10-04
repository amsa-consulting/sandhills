package com.sandhills.sandhills.model;

import lombok.Data;

@Data
public class Enrollment {
   private String courseid;
   private String userid;
   private String roleid;
   private int timestart;
   private int timeend;
}
