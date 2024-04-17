package com.example.online_toy_store.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class FilePathsUserReportProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("testdata/orderIncorrectQuantityOfProduct.json"),
                Arguments.of("testdata/orderInvalidProductId.json"),
                Arguments.of("testdata/orderInvalidPromoDate.json"),
                Arguments.of("testdata/orderInvalidUserId.json")
        );
    }
}
