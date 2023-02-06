package co2103.hw1.controller;

import java.util.ArrayList;
import java.util.List;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Cafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
    public class CafeController {

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new CafeValidator());
    }

        @GetMapping("/cafes")
        public String getCafes(Model model)
        {
            List<Cafe> cafeList  = Hw1Application.cafesList;
            model.addAttribute("cafes", cafeList);
            return "cafes/list";
        }

        @RequestMapping(value="/newCafe")
        public String newCafe(Model model)
        {
            model.addAttribute("cafe",new Cafe());
            return "cafes/form";
        }

    @RequestMapping(value = "/addCafe", method = RequestMethod.POST)
    public String addCafe(@ModelAttribute Cafe cafe, BindingResult results) {
        if(results.hasErrors()){
            return "cafes/form";
        }

        Hw1Application.cafesList.add(cafe);
        return "redirect:/cafes";

//        Exercise exercise = new Exercise();
//        exercise.setActivity(exerciseDesc);
//        List<Exercise> list = new ArrayList<Exercise>();
//        list.add(exercise);
//        goal.setExercises(list);
//
//        Hw1Application.cafesList.add(cafe);

    }
    }

