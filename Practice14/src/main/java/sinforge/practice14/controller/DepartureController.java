package sinforge.practice14.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sinforge.practice14.Entities.Departure;

import java.util.ArrayList;

@Controller
@RequestMapping("/departure")
public class DepartureController {
    private ArrayList<Departure> departures = new ArrayList<>();


    //Тут должен быть пост но мне лень юзать postman или делать формочки
    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String type, @RequestParam String date) {
        departures.add(new Departure(type, date));
        return "successful added";
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String type, @RequestParam String date) {


        return departures.removeIf((d) -> d.getDepartureDate().equals(date) && d.getType().equals(type))
                ?"successful delete"
                : "record not found";

    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Departures");
        model.addAttribute("Data", departures);
        model.addAttribute("DataColums", new String[]{"Type", "DepartureDate"});
        return "data";

    }





}
