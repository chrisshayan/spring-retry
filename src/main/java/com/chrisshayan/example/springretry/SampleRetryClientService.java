package com.chrisshayan.example.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleRetryClientService {

    @Autowired
    private SampleRetryService sampleRetryService;


    public void callRetryService() throws TypeOneException, TypeTwoException {
        sampleRetryService.retryWhenException();
    }
}
