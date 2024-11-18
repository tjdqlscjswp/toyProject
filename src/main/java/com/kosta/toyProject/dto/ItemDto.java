package com.kosta.toyProject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private Long count;



    @Builder
    public ItemDto(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
