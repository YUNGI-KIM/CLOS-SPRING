package clos21.kr.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudentByUsername(String username, Student updatedStudent) {
        Student existingStudent = studentRepository.findByUsername(username);

        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setPassword(updatedStudent.getPassword());
            existingStudent.setEmail(updatedStudent.getEmail());
            // 여기에 다른 필드들도 필요에 따라 추가하세요.

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    public Student getStudentByUsernameAndSchoolCode(String username, int schoolCode) {
        return studentRepository.findByUsernameAndSchoolCode(username, schoolCode);
    }

}
