package com.example.ingressacademytask.domains;

import ch.qos.logback.core.model.NamedModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long studentId;
    @Column(name = "STUDENT_NAME")
    String name;
    @Column(name = "STUDENT_EMAIL")
    String email;
    @Column(name = "STUDENT_PASSWORD")
    String password;
    @Column(name = "STUDENT_AGE")
    int age;
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "student_reading",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonIgnore
    private List<Books> currentlyReadingBooks;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "student_subscriptions",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonIgnore
    private List<Author> subscriptions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
