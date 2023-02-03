package org.example;

import lombok.*;

@Builder
@With
@Value
public class User implements Comparable<User> {

    private String name;
    private String surname;
    private String email;

    @Override
    public int compareTo(User o) {
        return o.email.compareTo(this.email);
    }
}


