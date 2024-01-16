package com.nttdata.escuela.libro.apimodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrategyBean {

    @Value("${strategy.service}")
    private String strategyService;

}
