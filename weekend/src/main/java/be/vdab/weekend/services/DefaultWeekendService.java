package be.vdab.weekend.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class DefaultWeekendService implements WeekendService{

    @Override
    public boolean isDitWeekend() {
        var message = false;
        DayOfWeek dagVanDeWeek =  LocalDate.now().getDayOfWeek();
        if(dagVanDeWeek == DayOfWeek.SATURDAY | dagVanDeWeek ==  DayOfWeek.SUNDAY){
            message = true;
        }
        return message;
    }
}
