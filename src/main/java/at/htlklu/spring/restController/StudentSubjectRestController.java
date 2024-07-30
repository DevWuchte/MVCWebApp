package at.htlklu.spring.restController;

import at.htlklu.spring.api.LogUtils;
import at.htlklu.spring.model.SchoolClass;
import at.htlklu.spring.model.StudentSubject;
import at.htlklu.spring.model.Subject;
import at.htlklu.spring.model.Teacher;
import at.htlklu.spring.repository.StudentSubjectRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/studentSubjects")
public class StudentSubjectRestController
{
    //region Properties
    private static final Logger logger = LogManager.getLogger(StudentSubjectRestController.class);
    private static final String className = "StudentSubjectRestController";
    //endregion


    @Autowired
    StudentSubjectRepository studentSubjectRepository;



    // http://localhost:8082/studentSubject/1
    @GetMapping(value = "{studentSubjectId}")
    public ResponseEntity<?> getByIdPV(@PathVariable Integer studentSubjectId) {
        logger.info(LogUtils.info(className, "getByIdPV", String.format("(%d)", studentSubjectId)));

        ResponseEntity<?> result;
        Optional<StudentSubject> optionalStudentSubject = studentSubjectRepository.findById(studentSubjectId);
        if (optionalStudentSubject.isPresent()) {
            StudentSubject studentSubject = optionalStudentSubject.get();
            result = new ResponseEntity<StudentSubject>(studentSubject, HttpStatus.OK);
        } else {
            result = new ResponseEntity<>(String.format("StudentSubject mit der Id = %d nicht vorhanden", studentSubjectId),
                    HttpStatus.NO_CONTENT);
        }
        return result;


    }

  /*  // http://localhost:8082/studentSubjects/1/subjects
    @GetMapping(value = "{studentSubjectId}/subjects")
    public ResponseEntity<?> getSchoolClassByIdPV(@PathVariable Integer studentSubjectId) {
        logger.info(LogUtils.info(className, "getSubjectsByIdPV", String.format("(%d)", studentSubjectId)));

        ResponseEntity<?> result;
        Optional<StudentSubject> optionalStudentSubject = studentSubjectRepository.findById(studentSubjectId);
        if (optionalStudentSubject.isPresent()) {
            StudentSubject studentSubject = optionalStudentSubject.get();
            List<Subject> subjects = studentSubject.getSubject().
            result = new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
        } else {
            result = new ResponseEntity<>(String.format("StudentSubject mit der Id = %d nicht vorhanden", studentSubjectId),
                    HttpStatus.NO_CONTENT);
        }
        return result;
        TEST

    }*/



}
