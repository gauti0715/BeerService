package com.akash.microservice.BeerService.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {

  private UUID id;
  private Integer version;
  private OffsetDateTime lastModifiedDate;
  private String beerName;
  private BeerStyleEnum beerStyle;
  private Long upc;
  private BigDecimal price;
}
