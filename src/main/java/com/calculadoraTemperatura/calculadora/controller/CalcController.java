package com.calculadoraTemperatura.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @GetMapping("/") // getmapping significa que o metodo aceitara req http do tipo GET
                     // objetivo: obter dados
    public ModelAndView calculadora() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculator1");
        return modelAndView;
    }

    @PostMapping("/calculate") // postmapping significa que o metodo aceitara req http do tipo POST
                                // objetivo: criar algum recurso
    public String calculate(@RequestParam("campo1") double campo1,
            @RequestParam("campo2") double campo2,
            @RequestParam("operator1") String operator1,
            @RequestParam("operator2") String operator2,
            Model model) {

                double result = 0;

                switch (operator1) {
                    case "Celsius":
                        switch (operator2) {
                            case "Fahrenheit":
                                result = (campo1 * 1.8) + 32;
                                break;
                            case "Kelvin":
                                result = campo1 + 273.15;
                                break;
                            default:
                                break;
                        }
                        break;
                
                    default:
                        break;
                }
                model.addAttribute("result", result);
                return calculadora;
    }

}
