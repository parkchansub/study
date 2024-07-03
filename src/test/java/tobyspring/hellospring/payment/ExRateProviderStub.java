package tobyspring.hellospring.payment;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;

@Getter
@Setter
public class ExRateProviderStub implements ExRateProvider{

    private BigDecimal exRate;


    public ExRateProviderStub(BigDecimal exRate) {
        this.exRate = exRate;
    }

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        return exRate;
    }
}
