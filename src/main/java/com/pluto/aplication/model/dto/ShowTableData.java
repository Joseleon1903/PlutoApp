package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jose eduardo on 3/29/2020.
 */
@Component
@Data
public class ShowTableData {

    private int showItem;

    private int showEntry;

    private int totalElement;

    private List<Integer> pageTotal;

}
