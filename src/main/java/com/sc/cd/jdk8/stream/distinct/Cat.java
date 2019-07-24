package com.sc.cd.jdk8.stream.distinct;


import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String name;
    private String code;
    private Double limit;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat cat = (Cat) o;
        if (Objects.equals(name, cat.name) && Objects.equals(code, cat.code) && Objects.equals(limit, cat.limit)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, limit);
    }
}
