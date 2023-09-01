package com.sydoruk.fuel_history.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sydoruk.fuel_history.model.paymentReceipt;
import com.sydoruk.fuel_history.util.generatePaymentReceipt;

@RestController
@RequestMapping("/")
public class info {

    private List<paymentReceipt> receipts = new ArrayList<>();

    public info(){
        Random random = new Random();
        int rnd = random.nextInt(1, 21);
        for(int i = 0; i < rnd; i++){
            receipts.add(generatePaymentReceipt.newInstance());
        }
    }

    @GetMapping("history")
    public Iterable<paymentReceipt> getAll(){
        return receipts;
    }

    @GetMapping("{id}")

    public Optional<paymentReceipt> getPaymentReceiptById(@PathVariable String id){
        for (paymentReceipt receipt : receipts) {
            if(receipt.getId().equals(id)){
                return Optional.of(receipt);
            }
        }
        return Optional.empty();
    }

    @PostMapping("add")
    public paymentReceipt addOne (@RequestBody paymentReceipt newReceipt){
        receipts.add(newReceipt);
        return newReceipt;
    }

    @PutMapping("{id}")
    ResponseEntity<paymentReceipt> updPaymentReceipt(@PathVariable String id, @RequestBody paymentReceipt updReceipt){
        int index = -1;
        for(paymentReceipt receipt:receipts){
            if(receipt.getId().equals(id)){
                index = receipts.indexOf(receipt);
                receipts.set(index, updReceipt);
                break;
            }
        }
        return (index == -1) ? 
            new ResponseEntity<>(addOne(updReceipt), HttpStatus.CREATED) : 
            new ResponseEntity<>(updReceipt, HttpStatus.OK);
    }

    @DeleteMapping("del/{id}")
    void deleteReceipt(@PathVariable String id){
        receipts.removeIf( r -> r.getId().equals(id));
    }

}