package com.example.restclient.service;

import com.example.restclient.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VoucherService {

    @Value("${voucher.server.url}")
    private String voucherServerBaseUrl;

    private static final String VOUCHER_ENDPOINT = "/vouchers";

    private final RestTemplate restTemplate;

    @Autowired
    public VoucherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Voucher retrieveOneVouchers(int id) {

        List<Voucher> allVouchers = restTemplate.exchange(voucherServerBaseUrl + VOUCHER_ENDPOINT,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Voucher>>(){}).getBody();

        Voucher voucher = null;

        for(Voucher v : allVouchers){
            if(v.getId() == id)
                voucher = v;
        }
        return voucher;
    }
}
