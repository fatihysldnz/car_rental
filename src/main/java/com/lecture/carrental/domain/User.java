package com.lecture.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15) // size kullanicinin girecegi degeri ve bu degere sinirlamalari belirlemek icin kullanilan anotation
    @NotNull (message = "Please enter your first name")
    @Column(nullable = false, length = 15) // Column anotationinda kullanilan length degeri ise database deki uzunluk icin sinir belirlemektedir.
    private String firstName;

    @Size(max = 15)
    @NotNull (message = "Please enter your last name")
    @Column(nullable = false, length = 15)
    private String lastName;

    @Size(min = 3 ,max = 20, message = "Plaese enter min 3 characters")
    @NotNull (message = "Please enter your user name")
    @Column(nullable = false, length = 20, unique = true, updatable = false)
    private String userName;

    @Size(min = 4, max = 60, message = "Plaese enter min 4 characters")
    @NotNull(message = "Please enter your password")
    @Column(nullable = false, length = 120)
    private String password;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @Size (min = 14, max = 14, message = "Phone number should be exact 10 chars")
    @NotNull (message = "Please enter your phone number")
    @Column(nullable = false, length = 14)
    private String phoneNumber;

    @Email
    @Size (min = 5, max = 150)
    @NotNull(message = "Please enter your email")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Size(max = 250)
    @NotNull(message = "Please enter your adress")
    @Column(nullable = false, length = 250)
    private String adress;

    @Size(max = 15)
    @NotNull(message = "Please enter your city")
    @Column(nullable = false, length = 15)
    private String city;

    @Size(max = 8)
    @NotNull(message = "Please enter your zip code")
    @Column(nullable = false, length = 8)
    private String zipCode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String firstName, String lastName, String userName, String password, String phoneNumber, String email, String adress, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.zipCode = zipCode;
    }
}
