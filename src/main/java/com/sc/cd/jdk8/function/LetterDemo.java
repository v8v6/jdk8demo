package com.sc.cd.jdk8.function;

import java.util.function.Function;

public class LetterDemo {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;

        // first 流水线
        Function<String, String> transformationPipeline
                = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        // second 流水线
        transformationPipeline = addHeader.andThen(Letter::addFooter);
    }
}
