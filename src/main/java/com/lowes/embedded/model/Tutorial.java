package com.lowes.embedded.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {
  @Id
  private String id;
  private String title;
  private String description;
  private boolean published;

}
