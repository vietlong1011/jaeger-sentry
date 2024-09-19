package cicd;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Getter
@Setter
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "nameUser", nullable = false)
    private String nameUser;

    @Column(name = "country")
    private String country;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @NotBlank
    @Email
    @Size(min = 4, max = 50)
    @Column(name = "email")
    private String email;

    @Column(name = "money", nullable = false)
    private Double money;


}

