package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
@RequestMapping("/time")
public class WorldLockController {
    @GetMapping("")
    public ModelAndView showForm(){
        ModelAndView modelAndView=new ModelAndView("time");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView getTime(@RequestParam String city){
        ModelAndView modelAndView=new ModelAndView("time");
        // Get current time at local
        Date date = new Date();
// Get timezone by the local
        TimeZone local = TimeZone.getDefault();
// Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
// Reset the date by locale_time
        date.setTime(locale_time);
        modelAndView.addObject("city",city);
        modelAndView.addObject("date",date);
        return modelAndView;
    }
}
