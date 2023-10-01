package com.dukan.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    String gender;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<FavoriteEntity> favorites;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<OrderEntity> orders;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<CommentEntity> comments;
}
