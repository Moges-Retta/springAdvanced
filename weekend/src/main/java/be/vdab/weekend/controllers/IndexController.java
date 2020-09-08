package be.vdab.weekend.controllers;

import be.vdab.weekend.services.WeekendService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    private WeekendService service;

    public IndexController(WeekendService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index","message", service.isDitWeekend()); }
}
