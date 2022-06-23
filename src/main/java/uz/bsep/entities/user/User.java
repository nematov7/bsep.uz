package uz.bsep.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;
import uz.bsep.entities.base.Auditable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PackagePrivate
public class User extends Auditable {

    String fullName;

    String password;

    String username;

    String email;

    @Enumerated(EnumType.STRING)
    Role role;
}
