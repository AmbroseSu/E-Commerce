package com.ambrose.ecommerce.dto.response;

import com.ambrose.ecommerce.dto.MeatadataDTO;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDTO {
  private Object content;
  private String message;
  private List<String> details;
  private int statusCode;
  private MeatadataDTO meatadataDTO;
}
