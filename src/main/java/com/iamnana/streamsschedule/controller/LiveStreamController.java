package com.iamnana.streamsschedule.controller;

import com.iamnana.streamsschedule.model.LiveStream;
import com.iamnana.streamsschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository liveStreamRepository;

    public LiveStreamController(LiveStreamRepository liveStreamRepository) {
        this.liveStreamRepository = liveStreamRepository;
    }


    // GET http://localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll(){
        return liveStreamRepository.findAll();
    }

    // GET http://localhost:8080/streams/{id}
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable("id") Integer id){
        return liveStreamRepository.findById(id);
    }
    //POST  http://localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@RequestBody LiveStream stream){
        return liveStreamRepository.create(stream);
    }

    //DELETE  http://localhost:8080/streams/id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
         liveStreamRepository.delete(id);
    }

    //PUT  http://localhost:8080/streams/id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable Integer id){
        liveStreamRepository.update(stream,id);
    }
}
