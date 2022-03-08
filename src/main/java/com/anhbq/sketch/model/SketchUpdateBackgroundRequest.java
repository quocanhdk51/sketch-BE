package com.anhbq.sketch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SketchUpdateBackgroundRequest {
    private Long id;
    private String background;
}
