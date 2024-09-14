package br.com.sandes.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    List<?> list;
    int integer = 0;

    @BeforeEach
    void setUp(){
        list = mock(List.class);
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10(){
        //test padrão

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.size()).thenReturn(10);

        //Then (Assert)
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        //Given (Arrange)
        given(list.size()).willReturn(integer);

        //When (Act)
        when(list.size())
                .thenReturn(10)
                .thenReturn(20)
                .thenReturn(20);

        //Then (Assert)
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnSandes(){

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.get(0)).thenReturn("Sandes");

        //Then (Assert)
        assertThat(list.get(0), is("Sandes"));
        assertNull(list.get(1));

        //Essa assertion falha por conta que esse comportamento não foi
        //mockada
    }

    @Test
    void testMockingList_When_SizeIsCalledWithArgumentMatcher_ShouldReturnSandes(){

        //Given (Arrange)
        var list = mock(List.class);

        //When (Act)
        when(list.get(anyInt())).thenReturn("Sandes"); //não vai retornar nullo, independente do que for passado aqui;

        //Then (Assert)
        assertEquals("Sandes", list.get(anyInt())); //mesma coias aqui
    }

    //teste para mockar exceptions com Mockito;
    @Test
    void testMockingList_When_ThrowsAnException(){

        //Given (Arrange)
        given(list.get(anyInt())).willThrow(new RuntimeException());

        //Then (Assert)
        assertThrows(RuntimeException.class,
                () -> list.get(anyInt()),
                () -> "Should have throw an RuntimeException");
    }
}
