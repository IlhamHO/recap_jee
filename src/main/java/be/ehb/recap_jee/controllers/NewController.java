package be.ehb.recap_jee.controllers;

import be.ehb.recap_jee.model.Product;
import be.ehb.recap_jee.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class NewController {
    @Autowired
    private ProductRepository productRepository;
    @ModelAttribute("all")
    public  Iterable<Product>findAll(){

        return  productRepository.findAll();
    }
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String showNew() {
        return "new";
    }
    @RequestMapping(value ={"/new"},method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("nProduct")  @Valid Product nProduct, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  "new";
        }
        productRepository.save(nProduct);
        return  "redirect:/index";
    }

    @ModelAttribute("nProduct")
    public Product ProductTosave(){
        return new Product();
    }
}

