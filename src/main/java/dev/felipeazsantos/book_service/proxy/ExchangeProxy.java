package dev.felipeazsantos.book_service.proxy;

import dev.felipeazsantos.book_service.dto.ExchangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "exchange-service", url = "localhost:8000")
public interface ExchangeProxy {

    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    ExchangeDto getExchange(@PathVariable("amount") BigDecimal amount,
                                                   @PathVariable("from") String from,
                                                   @PathVariable("to") String to);
}
