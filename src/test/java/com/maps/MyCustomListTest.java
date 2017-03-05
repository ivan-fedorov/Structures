package com.maps;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Log
class MyCustomListTest {
    @Test
    void testKey() {
        MyCustomList list = new MyCustomList(1000);
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        assertThat(list.getKey(44444), is(444));
        assertThat(list.getValue(2212), is(Collections.emptyList()));

    }

}