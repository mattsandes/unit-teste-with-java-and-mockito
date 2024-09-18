package br.com.sandes.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @DisplayName("Test name/Test class name")
    @Test
    void TestABCD_When_XYZ_Should(){
        //Given (Arrange)
        List<String> mockArrayList = spy(ArrayList.class);

        //When (Act)
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.add("Foo-Bar");

        assertEquals(5, mockArrayList.size());
        //Then (Assert)
    }

    @DisplayName("Test name/Test class name")
    @Test
    void testV2(){
        //Given (Arrange)
        List<String> mockArrayList = spy(ArrayList.class);

        //When (Act)
        assertEquals(0, mockArrayList.size());

        mockArrayList.add("Foo-Bar");
        assertEquals(1, mockArrayList.size());

        mockArrayList.remove("Foo-Bar");
        assertEquals(0, mockArrayList.size());
        //Then (Assert)
    }

    @DisplayName("Test name/Test class name")
    @Test
    void testV3(){
        List<String> mockArrayList = spy(ArrayList.class);

        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);

        mockArrayList.add("Foo-Bar");
        assertEquals(5, mockArrayList.size());
    }

    @DisplayName("Test name/Test class name")
    @Test
    void testV4(){
        List<String> mockArrayList = spy(ArrayList.class);

        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);

        mockArrayList.add("Foo-Bar");
        assertEquals(5, mockArrayList.size());
    }
}
