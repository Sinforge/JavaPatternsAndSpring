package sinforge.practice14.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sinforge.practice14.Entities.Departure;
import sinforge.practice14.Entities.PostOffice;

import java.util.ArrayList;

@Controller
@RequestMapping("/postoffice")
public class PostOfficeController {
    private ArrayList<PostOffice> postOffices = new ArrayList<>();


    //Тут должен быть пост но мне лень юзать postman или делать формочки
    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String name, @RequestParam String city) {
        postOffices.add(new PostOffice(name, city));
        return "successful added"  ;
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String name, @RequestParam String city) {


        return postOffices.removeIf((d) -> d.getName().equals(name) && d.getCityName().equals(city))
                ?"successful delete"
                : "record not found";

    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Post Offices");
        model.addAttribute("Data", postOffices);
        model.addAttribute("DataColums", new String[]{"Name", "City"});
        return "data";

    }
}
