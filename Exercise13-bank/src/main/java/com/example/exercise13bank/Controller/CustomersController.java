package com.example.exercise13bank.Controller;

import com.example.exercise13bank.ApiResponse.ApiResponse;
import com.example.exercise13bank.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomersController {

    ArrayList<Customers> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){

        return customers;
    }

    @PostMapping("/add")
    public ApiResponse addCustomers(@RequestBody Customers customers){
        this.customers.add(customers);

        return new ApiResponse("customer added",200);

    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomers(@PathVariable int index,@RequestBody Customers customers){

        this.customers.set(index,customers);

        return new ApiResponse("customer updated",200);

    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomers(@PathVariable int index){
        this.customers.remove(index);

        return new ApiResponse("customer deleted",200);

    }
    @PutMapping("/deposit/{index}/{amount}")
    public ApiResponse deposit(@PathVariable int index , @PathVariable double amount){

        this.customers.get(index).setBalance(this.customers.get(index).getBalance()+amount);

        return new ApiResponse("deposit completed",200);

    }
    @PutMapping("/withdraw/{index}/{amount}")
    public ApiResponse withDraw(@PathVariable int index , @PathVariable double amount){
        if(this.customers.get(index).getBalance()>=amount) {
            this.customers.get(index).setBalance(this.customers.get(index).getBalance()-amount);


            return new ApiResponse("withDraw completed", 200);
        }
        else return new ApiResponse("the amount is not enough ",400);

    }
}
