package sinforge.practice17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinforge.practice17.Services.DepartureService;

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
    public String add(@RequestParam String type, @RequestParam String date, @RequestParam int officeId) {

        departureService.add(type, date, officeId);
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
        return "dataDepartures";

    }
    @GetMapping(value="/all/{sort_field}/{value}")
    public String sortedAll(Model model, @PathVariable String sort_field, @PathVariable String value) {
        if(sort_field.equals("type")) {
            model.addAttribute("Data", departureService.filterByType(value));
        }
        else if  (sort_field.equals("date")) {
            model.addAttribute("Data", departureService.filterByDate(value));

        }
        else {
            model.addAttribute("Data", departureService.getAll());

        }
        return "dataDepartures";




    }





}
