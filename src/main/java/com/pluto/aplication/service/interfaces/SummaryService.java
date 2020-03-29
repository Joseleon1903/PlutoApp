package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.dto.SummaryData;

import java.util.List;

/**
 * Created by jose eduardo on 3/24/2020.
 */
public interface SummaryService {

    List<SummaryData> searchResumenByParam(String projectName, String iterationName,int showPageindex,int showEntry);


}
