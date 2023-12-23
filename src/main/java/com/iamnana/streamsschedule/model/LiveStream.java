package com.iamnana.streamsschedule.model;

import java.time.LocalDateTime;

public record LiveStream(Integer id, String title,String
        description,String url,LocalDateTime startDate,LocalDateTime endDate){

}
