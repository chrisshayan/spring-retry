package com.chrisshayan.example.springretry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class SampleRetryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRetryService.class);

    private static int COUNTER = 0;

    @Retryable(
            value = {TypeOneException.class, TypeTwoException.class},
            maxAttempts = 4, backoff = @Backoff(2000))
    public String retryWhenException() throws TypeOneException, TypeTwoException {
        COUNTER++;
        LOGGER.info("COUNTER = " + COUNTER);

        if(COUNTER == 1)
            throw new TypeOneException();
        else if(COUNTER == 2)
            throw new TypeTwoException();
        else
            throw new RuntimeException();
    }

    @Recover
    public String recover(Throwable t) {
        LOGGER.info("SampleRetryService.recover");
        return "Error Class :: " + t.getClass().getName();
    }
}
