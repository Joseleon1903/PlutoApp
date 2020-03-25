package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Component
@Data
public class SummaryDetailData {

    private String summaryCode;

    private String summaryPercent;

    private String buildNumber;
}
