package by.academy.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TilesController {
    @RequestMapping(
            value = { "/home.html"},
            method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(
            value = { "/welcome.html"},
            method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "welcome";
    }

}
