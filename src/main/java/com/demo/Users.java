package com.demo;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
public class Users {

    @Id
    private String username;
    private String password;

    private boolean enabled;



    @ManyToOne(cascade = CascadeType.MERGE)
    private Authorities authority;

}
