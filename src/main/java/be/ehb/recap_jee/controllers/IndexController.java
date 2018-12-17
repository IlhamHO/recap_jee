package be.ehb.recap_jee.controllers;

import be.ehb.recap_jee.model.Product;
import be.ehb.recap_jee.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute("all")
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }
}
