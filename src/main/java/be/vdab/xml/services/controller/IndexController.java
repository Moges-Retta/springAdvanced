package be.vdab.xml.services.controller;

import be.vdab.xml.services.KwadraatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
    private final KwadraatService kwadraatService;
    IndexController(KwadraatService kwadraatService) {
        this.kwadraatService = kwadraatService; }
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "kwadraat", kwadraatService.kwadraat(4));
    }
}
