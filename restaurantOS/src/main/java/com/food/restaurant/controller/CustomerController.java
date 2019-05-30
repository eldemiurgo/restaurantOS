package com.food.restaurant.controller;

import com.food.restaurant.model.Customer;
import com.food.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping({"/","/login"})
    public String login(Model model){
        model.addAttribute("customer",new Customer());
        return "login";
    }

    @PostMapping ({"/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/customers")
    public String getCustomerlist(Model model){
        model.addAttribute("customers",customerService.getAll());
        return "customer";
    }

    @GetMapping("/customers/add")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-add";
    }


    @PostMapping("/customers/valida")
    public String validaCustomer(Customer customer, Model model){
        Customer currentcustomer;
            try {
                currentcustomer =  customerService.validaCustomer(customer.getUser(), customer.getPassword());
            }catch (Exception e){
                model.addAttribute("message", "Wrong user");
                return "login";
            }
        model.addAttribute("customer", currentcustomer);
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("message", "correct");
        return "index";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(Customer customer, Model model){

        customerService.saveCustomer(customer);

        model.addAttribute("customers", customerService.getAll());

        return "customer";
    }

    @GetMapping("/customers/edit/{id}")
    public String getProductForEdit(@PathVariable Integer id,
                                    Model model){
        model.addAttribute("customer",
                customerService.findById(id));
        return "customer-edit";
    }

    @PostMapping("/customers/update/{id}")
    public String updateCustomer(@PathVariable Integer id,
                                Customer customer,
                                Model model){
        customerService.updateCustomer(id, customer);
        model.addAttribute("customers",
                customerService.getAll());
        return "customer";
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id,
                                Model model){
        customerService.deleteCustomer(id);
        model.addAttribute("customers",
                customerService.getAll());
        return "customer";
    }




}                   
