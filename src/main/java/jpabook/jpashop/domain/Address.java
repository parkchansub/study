package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
@Getter
public class Address {

    private String city;
    private String zipcode;
    private String street;

    public Address() {
    }

    public Address(String city, String zipcode, String street) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
