package com.anhbq.sketch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SketchUpdateSizeRequest {
    private Long id;
    private Integer width;
    private Integer height;
}
