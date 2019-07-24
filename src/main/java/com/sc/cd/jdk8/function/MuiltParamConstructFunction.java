package com.sc.cd.jdk8.function;

@FunctionalInterface
public interface MuiltParamConstructFunction<T,U,V,P, R> {

    R apply(T t,U u,V v,P p);
}
