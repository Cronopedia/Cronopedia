package br.com.cronopedia.paginasapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
public class APIController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("doc/index");
        return MV;
    }

}
