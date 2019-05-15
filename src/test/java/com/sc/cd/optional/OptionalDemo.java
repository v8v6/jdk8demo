package com.sc.cd.optional;

import java.util.Optional;

import org.junit.Test;

import com.sc.cd.specification.optional.model.UserDO;

/**
 * 描述:
 * OptionalDemo
 *
 * @author junxi.chen
 * @create 2018-11-30 18:03
 */

public class OptionalDemo {

    @Test
    public void whenCreateEmptyOptional_thenNull() {
        Optional<UserDO> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        //Optional<UserDO> opt = Optional.of(user);
    }
}
