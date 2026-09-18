package dev.felipeazsantos.book_service.dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ExchangeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private BigDecimal convertedValue;

    private String environment;

    public ExchangeDto(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    public ExchangeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeDto exchangeDTO = (ExchangeDto) o;
        return Objects.equals(id, exchangeDTO.id) && Objects.equals(from, exchangeDTO.from) && Objects.equals(to, exchangeDTO.to) && Objects.equals(conversionFactor, exchangeDTO.conversionFactor) && Objects.equals(convertedValue, exchangeDTO.convertedValue) && Objects.equals(environment, exchangeDTO.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, convertedValue, environment);
    }
}
