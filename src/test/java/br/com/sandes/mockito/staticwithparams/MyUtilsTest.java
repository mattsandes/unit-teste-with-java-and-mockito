package br.com.sandes.mockito.staticwithparams;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

class MyUtilsTest {

    @Test
    void shouldMockStaticMethodWithParams() {
        try(MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)){
            mockedStatic.when(
                    () -> MyUtils.getWelcomeMessage(
                            eq("Mateus"),
                            anyBoolean()))
                    .thenReturn("Howdy Mateus!");

            String result = MyUtils.getWelcomeMessage(
                    "Mateus",
                    false);

            assertEquals("Howdy Mateus!", result);
        }
    }
}