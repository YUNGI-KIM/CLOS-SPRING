package clos21.kr.backend;

import javax.persistence.*;
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int login_count = 0;

    @Column(nullable = true)
    private String email;
    @Column(nullable = true)
    private String phone;
    @Column(nullable = false)
    private int school_code = 0;

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getLoginCount() {
        return login_count;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginCount(int login_count) {
        this.login_count = login_count;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}