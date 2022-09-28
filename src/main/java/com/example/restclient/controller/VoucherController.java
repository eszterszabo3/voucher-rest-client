package com.example.restclient.controller;

import com.example.restclient.model.Voucher;
import com.example.restclient.service.VoucherService;
import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoucherController {

    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("/vouchers-rest-client/{id}")
    @Timed(value = "rest.client.one.voucher", description = "GET REST Client - one voucher")
    public Voucher getOneVoucher(@PathVariable int id) {
        return voucherService.retrieveOneVouchers(id);
    }
}
