package com.example.numberconsumer;

import com.example.consumingwebservice.wsdl.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

@SpringBootApplication
public class NumberConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumberConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(NumberClient numberClient) {
        return args -> {
            BigInteger number = BigInteger.valueOf(1200);

            NumberToWordsResponse response = numberClient.numberToWord(number);
            System.err.println(response.getNumberToWordsResult());
        };
    }

}
