package com.sqlPG.DAO;

import com.sqlPG.Model.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

}
