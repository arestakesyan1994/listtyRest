package com.example.restlisty.restController;

import com.example.restlisty.model.Listty;
import com.example.restlisty.model.Region;
import com.example.restlisty.repository.ListtyRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/listy")
public class ListtyController {

    @Autowired
    private ListtyRepository listtyRepository;

    @ApiOperation(value = "all users", notes = "get all users")
    @GetMapping
    public List<Listty> listties() {
        return listtyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getListtyById(@PathVariable(name = "id") String id) {
        Optional<Listty> one = listtyRepository.findById(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with " + id + " id no found");
        }
        return ResponseEntity.ok(one);
    }

    @PostMapping()
    public ResponseEntity saveList(@RequestBody Listty listty) {
            listtyRepository.save(listty);
            return ResponseEntity.ok("created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteListtyById(@PathVariable(name = "id") String id) {
        Optional<Listty> optionalListty = listtyRepository.findById(id);
        if (optionalListty.isPresent()) {
            listtyRepository.deleteById(id);
            return ResponseEntity.ok("Delete");
        }
        else {
            return ResponseEntity.badRequest().body("user with " + id + "does not exist");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity  updateListty( @PathVariable String id,
                                   @Valid @RequestBody Listty listty) {
        Optional<Listty> optionalListty = listtyRepository.findById(id);
        Listty listty1 = optionalListty.get();
        listty1.setTitle(listty.getTitle());
        listty1.setCategory(listty.getCategory());
        listty1.setDescription(listty.getDescription());
        listty1.setTogs(listty.getTogs());
        listty1.setRegion(listty.getRegion());
        listty1.setUser(listty.getUser());
        listty1.setWebsite(listty.getWebsite());
        listty1.setVideoUrl(listty.getVideoUrl());
        listty1.setMs(listty.getMs());
        listtyRepository.save(listty1);
        return ResponseEntity.ok("update");
    }
}

