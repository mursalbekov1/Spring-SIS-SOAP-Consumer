package com.example.numberconsumer;

import com.example.consumingwebservice.wsdl.NumberToWords;
import com.example.consumingwebservice.wsdl.NumberToWordsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigInteger;

public class NumberClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(NumberClient.class);

    public NumberToWordsResponse numberToWord(BigInteger number) {

        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);

        log.info("Requesting number for " + number);

        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/convert", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/NumberToWords"));

        return response;
    }
}
