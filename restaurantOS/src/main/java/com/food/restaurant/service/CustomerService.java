package com.food.restaurant.service;

import com.food.restaurant.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomerService {

    AtomicInteger id = new AtomicInteger();

    List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                    new Customer(id.getAndIncrement(),"Ronny", "Cabana","Jr. Eleodoro zeballos 147","948682821","admin","1234"),
                    new Customer(id.getAndIncrement(),"Carmen", "Cabana","Jr. Eleodoro zeballos 147","985858545","user","1234")

            )

    );



    public List<Customer> getAll(){
        return customers;
    }

    public void saveCustomer(Customer customer){
        customer.setId(id.incrementAndGet());
        customers.add(customer);
    }



    public Customer validaCustomer(String user, String password){
        Customer customer = customers.stream()
                .filter(p -> p.getUser().equals(user)&& p.getPassword().equals(password))
                .findFirst()
                .orElseGet(null);
        return customer;

    }
    public Customer findById(Integer id){
        Customer customer = customers.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseGet(null);
        return customer;

    }

    public void updateCustomer(Integer id, Customer customer){
        Customer currentCustomer = findById(id);
        int index = customers.indexOf(currentCustomer);
        customer.setId(currentCustomer.getId());
        customers.set(index, customer);
    }


    public void deleteCustomer(Integer id){
        Customer currentCustomer = findById(id);
        customers.remove(currentCustomer);
    }
}
