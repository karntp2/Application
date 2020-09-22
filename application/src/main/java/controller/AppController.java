package controller;

import Dao.Fruits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public ResponseEntity<?> getList() {
        List<Fruits> fruitsList = new ArrayList<>();
        fruitsList.add(new Fruits(1, "mango"));
        return new ResponseEntity(fruitsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<Fruits> create(@RequestBody Fruits fruit) {
        if(fruit.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new Fruits(1, "mango"), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathParam("id") Integer id) {
        return new ResponseEntity<>(new Fruits(1, "mango"), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Fruits fruit) {
        return new ResponseEntity(fruit, HttpStatus.OK);
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathParam("id") Integer id) {
        return new ResponseEntity(HttpStatus.OK);
    }



}
