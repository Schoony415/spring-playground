package com.sqlPG.Controller;

import com.sqlPG.DAO.*;
import com.sqlPG.Model.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonRepository repository;

    public LessonController(LessonRepository repository) {
        this.repository = repository;
    }
/*
CRUD(L)	Verb	Path	Name	Purpose
Create	POST	/employees	"create" route	Creates an employee
Read	GET	/employees/{id}	"show" route	Returns a single employee
Update	PATCH	/employees/{id}	"update" route	Updates attributes of the employee
Delete	DELETE	/employees/{id}	"delete" route	Deletes the employee
List	GET	/employees	"index" or "list" route	Returns a list of employees
 */
/*
CRUD(L)	Verb	Path	JPA
Create	POST	/employees	.save
Read	GET	/employees/{id}	.findById
Update	PATCH	/employees/{id}	.save
Delete	DELETE	/employees/{id}	.deleteById
List	GET	/employees	.findAll
 */
    @GetMapping("/")
    public String home(){
        return "You made it";
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> getOne(@PathVariable long id){
        return this.repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        Optional<Lesson> temp = this.repository.findById(id);
        if(!temp.isEmpty())
            this.repository.delete(temp.get());
        return "goodbye"+id;
    }



}//end of file
