package sinforge.practice21.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sinforge.practice21.Services.DepartureService;

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
    public String delete(@RequestParam Integer id) {

        departureService.delete(id);
        return "successful delete";

    }

    @GetMapping(value="/all")
    public String all(Model model) {

        model.addAttribute("DataType", "Departures");
        model.addAttribute("Data", departureService.getAll());
        model.addAttribute("DataColumns", new String[]{"Type", "DepartureDate"});
        return "dataDepartures";

    }
    @GetMapping(value="/all/{sort_field}")
    public String sortedAll(Model model, @PathVariable String sort_field) {
        if(sort_field.equals("type")) {
            model.addAttribute("Data", departureService.sortByType());
        }
        else if  (sort_field.equals("date")) {
            model.addAttribute("Data", departureService.sortByDate());

        }
        else {
            model.addAttribute("Data", departureService.getAll());

        }
        return "dataDepartures";




    }





}
