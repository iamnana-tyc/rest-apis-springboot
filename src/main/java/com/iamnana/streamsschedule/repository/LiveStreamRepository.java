package com.iamnana.streamsschedule.repository;

import com.iamnana.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository(){
       streams.add(new LiveStream(
               1,
               "Drum workshop Tutorial",
               "This is to empower all people especially people who love music",
               "https://www.squidtv.net/",
               LocalDateTime.of(2023,12,30,9,10),
               LocalDateTime.of(2023,12,30,12,10)
       ));
    }
    public List<LiveStream> findAll(){
        return streams;
    }

    public LiveStream findById(Integer id){
        return streams.stream().filter(s -> s.id().equals(id)).findFirst().get();
    }

    public LiveStream create(LiveStream stream){
        streams.add(stream);
        return stream;
    }
    public void delete(Integer id){
        streams.removeIf(s->s.id().equals(id));
    }

    public void update(LiveStream stream, Integer id){
        LiveStream existing = streams.stream().filter(s->s.id().equals(id))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i,stream);
    }
}
