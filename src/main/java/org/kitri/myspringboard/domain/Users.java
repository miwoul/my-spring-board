package org.kitri.myspringboard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private boolean enabled;
}
