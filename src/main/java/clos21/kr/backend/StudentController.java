package clos21.kr.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("id/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
    @GetMapping("/search")
    public Student getStudentByUsernameAndSchoolCode(@RequestParam String username, @RequestParam String school_code) {
        return studentService.getStudenttByUsernameAndSchoolCode(username, school_code);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student);
    }
    @PutMapping("username/{username}")
    public Student updateStudent(@PathVariable String username, @RequestBody Student student) {
        return studentService.updateStudentByUsername(username, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
