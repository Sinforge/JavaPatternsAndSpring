package sinforge.practice15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sinforge.practice15.Entities.Departure;
import sinforge.practice15.Services.DepartureService;

import java.util.ArrayList;

@Controller
@RequestMapping("/departure")
public class DepartureController {
    private DepartureService departureService;

    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    //Тут должен быть пост но мне лень юзать postman или делать формочки
    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String type, @RequestParam String date) {

        departureService.add(type, date);
        return "successful add";
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String type, @RequestParam String date) {

        departureService.delete(type, date);
        return "successful delete";

    }

    @GetMapping(value="/all")
    public String all(Model model) {

        model.addAttribute("DataType", "Departures");
        model.addAttribute("Data", departureService.getAll());
        model.addAttribute("DataColumns", new String[]{"Type", "DepartureDate"});
        return "data";

    }





}
