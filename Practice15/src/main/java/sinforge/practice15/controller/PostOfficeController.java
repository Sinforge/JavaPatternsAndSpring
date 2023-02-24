package sinforge.practice15.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sinforge.practice15.Entities.Departure;
import sinforge.practice15.Entities.PostOffice;
import sinforge.practice15.Services.PostOfficeService;

import java.util.ArrayList;

@Controller
@RequestMapping("/postoffice")
public class PostOfficeController {

    private PostOfficeService postOfficeService;
    public PostOfficeController(PostOfficeService postOfficeService) {
        this.postOfficeService = postOfficeService;
    }
    //Тут должен быть пост но мне лень юзать postman или делать формочки
    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String name, @RequestParam String city) {
        postOfficeService.add(name, city);
        return "successful added"  ;
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String name, @RequestParam String city) {
        postOfficeService.delete(name, city);
        return "successful deleted";


    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Post Offices");
        model.addAttribute("Data", postOfficeService.getAll());
        model.addAttribute("DataColumns", new String[]{"Name", "City"});
        return "data";

    }
}
