package com.chrisshayan.example.springretry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringRetryApplicationTests {

    @Autowired
    private SampleRetryService sampleRetryService;

    @Autowired
    private SampleRetryClientService client;

	@Test
	public void contextLoads() {
	}

	@Test
    public void sampleRetryService() {
        try {
            client.callRetryService();
        } catch (TypeOneException | TypeTwoException e) {
            e.printStackTrace();
        }
    }

}
