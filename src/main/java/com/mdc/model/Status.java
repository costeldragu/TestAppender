package com.mdc.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Status {
    private String name;
    private String version;
    private String releaseDate;
}
