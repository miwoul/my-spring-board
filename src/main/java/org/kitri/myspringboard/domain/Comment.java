package org.kitri.myspringboard.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    private Long id;
    private String content;
    private String username;
    private Long boardId;
    private LocalDateTime createdAt;
}
