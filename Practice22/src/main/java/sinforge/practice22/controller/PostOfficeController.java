package sinforge.practice22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinforge.practice22.Services.PostOfficeService;

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
    public String delete(@RequestParam Integer id) {
        postOfficeService.delete(id);
        return "successful deleted";


    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Post Offices");
        model.addAttribute("Data", postOfficeService.getAll());
        model.addAttribute("DataColumns", new String[]{"Name", "City"});
        return "dataOffices";

    }

    @GetMapping(value="/all/{sort_field}")
    public String sortedAll(Model model, @PathVariable String sort_field) {
        model.addAttribute("DataType", "Post Offices");
        model.addAttribute("DataColumns", new String[]{"Name", "City"});
        if(sort_field.equals("name")) {
            model.addAttribute("Data", postOfficeService.sortByName());
        }
        else if  (sort_field.equals("city")) {
            model.addAttribute("Data", postOfficeService.sortByCity());

        }
        else {
            model.addAttribute("Data", postOfficeService.getAll());

        }
        return "dataOffices";




    }
}
