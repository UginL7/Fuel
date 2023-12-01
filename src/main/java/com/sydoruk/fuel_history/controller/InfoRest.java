package com.sydoruk.fuel_history.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sydoruk.fuel_history.model.PaymentReceipt;


@RestController
@RequestMapping("/")
public class InfoRest {

    private final PaymentReceiptRepo paymentRepo; 

    public InfoRest(PaymentReceiptRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    @GetMapping("history")
    public Iterable<PaymentReceipt> getAll(){
        return paymentRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<PaymentReceipt> getPaymentReceiptById(@PathVariable String id){
        return paymentRepo.findById(id);
    }

    @PostMapping("{id}")
    public PaymentReceipt addOne (@RequestBody PaymentReceipt newReceipt){
        return paymentRepo.save(newReceipt);
    }

    @DeleteMapping("{id}")
    void deleteReceipt(@PathVariable String id){
        paymentRepo.deleteById(id);
    }

    @PutMapping("{id}")
    ResponseEntity<PaymentReceipt> updPaymentReceipt(@PathVariable String id, @RequestBody PaymentReceipt updReceipt){
        return (paymentRepo.existsById(id)) ?
            new ResponseEntity<>(paymentRepo.save(updReceipt), HttpStatus.OK):
            new ResponseEntity<>(paymentRepo.save(updReceipt), HttpStatus.CREATED);
    }
}