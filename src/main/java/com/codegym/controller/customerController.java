package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerFrom;
import com.codegym.service.Customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private ICustomerService customerService;
    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping("")
    public ModelAndView showAll(){
        Iterable<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer",new CustomerFrom());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView addCustomer(@ModelAttribute CustomerFrom customerFrom){
        MultipartFile multipartFile = customerFrom.getImage();
        String fileName=multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(customerFrom.getImage().getBytes(),new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Customer customer = new Customer(customerFrom.getId(),customerFrom.getFirstName(),customerFrom.getFirstName(),fileName);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("mess","create SuccSet");
        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return new ModelAndView("customer/404");
        }else {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView editCustomer(@ModelAttribute CustomerFrom customerFrom){
        MultipartFile multipartFile = customerFrom.getImage();
        String fileName=multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(customerFrom.getImage().getBytes(),new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Customer customer = new Customer(customerFrom.getId(),customerFrom.getFirstName(),customerFrom.getLastName(),fileName);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer",customer);
        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return new ModelAndView("customer/404");
        }else {
            ModelAndView modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public ModelAndView deleteCustomer(@ModelAttribute CustomerFrom customerFrom){
        customerService.deleteById(customerFrom.getId());
        return new ModelAndView("redirect:/customer");
    }

}
