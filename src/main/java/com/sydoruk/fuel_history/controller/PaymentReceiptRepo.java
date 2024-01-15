package com.sydoruk.fuel_history.controller;

import org.springframework.data.repository.CrudRepository;

import com.sydoruk.fuel_history.model.PaymentReceipt;

public interface PaymentReceiptRepo extends CrudRepository<PaymentReceipt, Long>{}
