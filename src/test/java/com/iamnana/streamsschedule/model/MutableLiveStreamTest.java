package com.iamnana.streamsschedule.model;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MutableLiveStreamTest {
    @Test
    void create_new_mutable_live_stream(){
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(1);
        stream.setTitle("Workshop for APIs");
        stream.setDescription("""
    Tomorrow our workshop will be starting and all should do well to register
    """);
        stream.setUrl("https://www.squidtv.net/");
        stream.setStartDate(LocalDateTime.of(2023,12,30,9,10));
        stream.setEndDate(LocalDateTime.of(2023,12,30,12,20));


        assertNotNull(stream);
        assertEquals("Workshop for APIs", stream.getTitle());
    }

    @Test
    void create_new_immutable_live_stream(){
        ImmutableLiveStream stream = new ImmutableLiveStream(
                1,
                "Drum workshop Tutorial",
                "This is to empower all people especially people who love music",
                "https://www.squidtv.net/",
                LocalDateTime.of(2023,12,30,9,10), LocalDateTime.of(2023,12,30,12,10)
        );

        assertNotNull(stream);
        assertEquals("Drum workshop Tutorial", stream.getTitle());
    }

    @Test
    void create_new_live_stream(){
        LiveStream stream = new LiveStream(
                1,
                "Drum workshop Tutorial",
                "This is to empower all people especially people who love music",
                "https://www.squidtv.net/",
                LocalDateTime.of(2023,12,30,9,10),
                LocalDateTime.of(2023,12,30,12,10)
        );

        assertNotNull(stream);
        assertEquals("Drum workshop Tutorial", stream.title());
    }
}



