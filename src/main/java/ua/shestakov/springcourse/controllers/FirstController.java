package ua.shestakov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

      //  System.out.println("Hello, "+name + " " + surname) ;
        model.addAttribute("message","Hello, "+name + " " + surname);
            return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) Integer a,
                                 @RequestParam(value = "b", required = false) Integer b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model){

        if(action == null){
            model.addAttribute("answer", "Please set your params! ");
        }
        else if(action.equals("addition")) {
            int res = a + b;
            model.addAttribute("answer", "Answer is: " + res);
        }
        else if(action.equals("multiplication")) {
            int res = a * b;
            model.addAttribute("answer", "Answer is: " + res);
        }
        else if(action.equals("subtraction")) {
            int res = a - b;
            model.addAttribute("answer", "Answer is: " + res);
        }
        else if(action.equals("divison")) {
            double res = (double) (a) / (double) (b);
            model.addAttribute("answer", "Answer is: " + res);
        }
        else{
            model.addAttribute("answer", "Illigal arichmetical operation .... ");
        }
        return "first/calculator";
    }


    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

}
