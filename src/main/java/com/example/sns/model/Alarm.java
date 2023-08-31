package com.example.sns.model;

import com.example.sns.model.entity.AlarmEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class Alarm {
    private Integer id;
    private AlarmType alarmType;
    private AlarmArgs args;
    private Timestamp registerAt;
    private Timestamp updateAt;
    private Timestamp deletedAt;

    public static Alarm fromEntity(AlarmEntity entity){
        return new Alarm(
                entity.getId(),
                entity.getAlarmType(),
                entity.getArgs(),
                entity.getRegisterAt(),
                entity.getUpdateAt(),
                entity.getDeletedAt()
        );
    }

}
