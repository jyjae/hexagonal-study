package com.example.membersipservice.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberShipJpaEntity {

    @Id
    @GeneratedValue
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isCorp;

    private boolean isValid;

    public MemberShipJpaEntity(String name, String address, String email, boolean isCorp, boolean isValid) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isCorp = isCorp;
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "MemberShipJpaEntity{" +
                "membershipId=" + membershipId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", isCorp=" + isCorp +
                ", isValid=" + isValid +
                '}';
    }
}
