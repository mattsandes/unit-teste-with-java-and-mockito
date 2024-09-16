package br.com.sandes.mockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchers(){
        //given
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        //when
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99, 105));
        assertThat(scores, everyItem(greaterThan(98)));
        assertThat(scores, everyItem(lessThan(106)));

        //checando strings

        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));

        //usando matchers com arrays
        Integer[] myArray = {1, 2, 3};
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1, 2, 3));
        assertThat(myArray, arrayContainingInAnyOrder(1, 2, 3));
    }
}
