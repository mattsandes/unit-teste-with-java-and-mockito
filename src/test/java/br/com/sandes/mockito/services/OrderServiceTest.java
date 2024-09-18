package br.com.sandes.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("6ed19183-f741-435b-956a-8139075bd558");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2024, 9, 18, 8, 14);

    @DisplayName("Test Should Include Random Order Id When No Order Id Exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists(){
        //Given (Arrange)
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            //When (Act)
            Order result = service.createOrder(
                    "Test Product",
                    10L,
                    null);

            //Then (Assert)
            assertEquals(defaultUuid.toString(), result.getId());
        }
    }

    @DisplayName("Test Should Include Current Time When Create A NewOrder")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder(){
        //Given (Arrange)
        try(MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            //When (Act)
            Order result = service.createOrder(
                    "Test Product",
                    10L,
                    null);

            //Then (Assert)
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }

}