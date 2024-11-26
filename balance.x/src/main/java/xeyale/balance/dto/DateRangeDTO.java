package xeyale.balance.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class DateRangeDTO {
    private LocalDate startDate;
    private LocalDate endDate;
}