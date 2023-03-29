package com.poc.dictionary.core.spi;

import org.springframework.lang.NonNull;

import java.util.function.BinaryOperator;

@SuppressWarnings("unused")
public interface InternalBinaryOperator {

    @NonNull
    static <T> BinaryOperator<T> first() {
        return (first, second) -> first;
    }

    @NonNull
    static <T> BinaryOperator<T> second() {
        return (first, second) -> second;
    }

}
