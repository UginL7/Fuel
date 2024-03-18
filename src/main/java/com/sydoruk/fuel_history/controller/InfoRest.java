package com.sydoruk.fuel_history.controller;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sydoruk.fuel_history.model.PaymentReceipt;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
//@RestController
//@RequestMapping("/")
public class InfoRest {

    private final PaymentReceiptRepo paymentRepo; 

    public InfoRest(PaymentReceiptRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    @GetMapping("/hello/{name}")
    public String getIndexSlash(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "/hello";
    }

    @GetMapping("/history")
    public String getAll(Model model){
        model.addAttribute("paymentReceipt", paymentRepo.findAll());
        return "history";
    }

    @GetMapping("/id/{id}")
    public String getPaymentReceiptById(@PathVariable Long id, Model model){
        Optional<PaymentReceipt> opr = paymentRepo.findById(id);
        if(opr.isPresent()){
            opr.ifPresent(pr->model.addAttribute("pr", pr));
        }
        else{
            model.addAttribute("pr", "NotExist");
        }
//        paymentRepo.findById(id).ifPresent(pr->model.addAttribute("pr", pr));
        return "id";
    }

    /*
    @GetMapping("/addgas")
    public ModelAndView addGas(ModelAndView modelAndView){
        modelAndView.addObject("newReceipt", new PaymentReceipt());
        modelAndView.setViewName("addgas");
        return modelAndView;
    }

    @PostMapping(path="/addgas",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView addGas(@ModelAttribute PaymentReceipt newReceipt, ModelAndView modelAndView){
        modelAndView.addObject("newReceipt", newReceipt);
        modelAndView.setViewName("/id/"+newReceipt.getId().toString());
        return modelAndView;
    }
    */

    @GetMapping("/addgas")
    public String addGas(Model model) {
        PaymentReceipt newReceipt = new PaymentReceipt();
        model.addAttribute("newReceipt", newReceipt);
        return "/addgas";
    }

//    @PostMapping(path="/addgas",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @RequestMapping(method = RequestMethod.POST, path = "/addgas")
    public String addGas (@RequestBody PaymentReceipt newReceipt) {
        newReceipt.setTimeStamp(new Timestamp(System.currentTimeMillis()).toString());
        paymentRepo.save(newReceipt);
        return "redirect:/id/"+newReceipt.getId().toString();
    }
/*
    @PostMapping(path="/addgas")
    public ModelAndView addGas(@ModelAttribute PaymentReceipt newReceipt){
        paymentRepo.save(newReceipt);
        ModelAndView modelAndView = new ModelAndView("redirect:/id/"+newReceipt.getId().toString());
        newReceipt.setTimeStamp(new Timestamp(System.currentTimeMillis()).toString());
        modelAndView.addObject("newReceipt", newReceipt);
        return modelAndView;
    }
*/
    @DeleteMapping("/id/{id}")
    void deleteReceipt(@PathVariable Long id){
        paymentRepo.deleteById(id);
    }

    @PutMapping("/id/{id}")
    ResponseEntity<PaymentReceipt> updPaymentReceipt(@PathVariable Long id, @RequestBody PaymentReceipt updReceipt){
        return (paymentRepo.existsById(id)) ?
            new ResponseEntity<>(paymentRepo.save(updReceipt), HttpStatus.OK):
            new ResponseEntity<>(paymentRepo.save(updReceipt), HttpStatus.CREATED);
    }
}