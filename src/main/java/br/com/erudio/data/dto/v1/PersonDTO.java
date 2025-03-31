package br.com.erudio.data.dto.v1;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.erudio.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//Alterar a serialização do JSON.
//@JsonPropertyOrder({"id", "address", "first_name", "lastName", "gender"})
@JsonFilter("PersonFilter")
public class PersonDTO implements Serializable {

    private static final long serialVersion = 1L;

    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

//    @JsonProperty("first_name")
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String lastName;
    private String address;

//    @JsonIgnore
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    private String sensitiveData;

    public PersonDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSensitiveData() {
        return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return getId() == personDTO.getId() && Objects.equals(getBirthDay(), personDTO.getBirthDay()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getPhoneNumber(), personDTO.getPhoneNumber()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getSensitiveData(), personDTO.getSensitiveData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBirthDay(), getFirstName(), getPhoneNumber(), getLastName(), getAddress(), getGender(), getSensitiveData());
    }
}
