package com.aziz.voyages.RESTControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.voyages.entities.Type;
import com.aziz.voyages.repos.TypeRepository;



@RestController
@RequestMapping("/api/Type")
@CrossOrigin("*")
public class TypeRESTController {

    @Autowired
    TypeRepository typeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> Types = typeRepository.findAll();
        return new ResponseEntity<>(Types, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Type> getTypeById(@PathVariable("id") Long id) {
        Optional<Type> Type = typeRepository.findById(id);
        return Type.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Type> createType(@RequestBody Type Type) {
        Type createdType = typeRepository.save(Type);
        return new ResponseEntity<>(createdType, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteType(@PathVariable("id") Long id) {
        if (typeRepository.existsById(id)) {
            typeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Type> updateType(@PathVariable("id") Long id, @RequestBody Type Type) {
//        if (typeRepository.existsById(id)) {
//            Type.setIdType(id);  // Ensure the ID is set correctly
//            Type updatedType = TypeRepository.save(Type);
//            return new ResponseEntity<>(updatedType, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
