package br.com.sandes.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10(){
        //test padrão

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.size()).thenReturn(10);

        //Then (Assert)
        assertEquals(10, list.size());

        //realizando um retorno diferente para cada chamada;

    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        //test padrão

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.size())
                .thenReturn(10)
                .thenReturn(20)
                .thenReturn(20);

        //Then (Assert)
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnSandes(){

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.get(0)).thenReturn("Sandes");

        //Then (Assert)
        assertEquals("Sandes", list.get(0));

        //Essa assertion falha por conta que esse comportamento não foi
        //mockada
        //assertEquals("Sandes", list.get(15));
    }

    @Test
    void testMockingList_When_SizeIsCalledWithArgumentMatcher_ShouldReturnSandes(){

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.get(anyInt())).thenReturn("Sandes"); //não vai retornar nullo, independente do que for passado aqui;

        //Then (Assert)
        assertEquals("Sandes", list.get(anyInt())); //mesma coias aqui

        //Essa assertion falha por conta que esse comportamento não foi
        //mockada
        //assertEquals("Sandes", list.get(15));
    }

    //teste para mockar exceptions com Mockito;
    @Test
    void testMockingList_When_ThrowsAnException(){

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.get(anyInt()))
                .thenThrow(new RuntimeException("Foo Bar")); //não vai retornar nullo, independente do que for passado aqui;

        //Then (Assert)
        assertThrows(RuntimeException.class,
                () -> list.get(anyInt()),
                () -> "Should have throw an RuntimeException");
    }
}
