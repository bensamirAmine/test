package tn.esprit.spring.Payload.response;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Role;

import java.sql.Timestamp;
import java.util.Set;

public class UserResponse {
    private Long id;
    private String userName;
    private String name;
    private String lastName;
    //National ID
    private String nid;
    private String email;
    private String password;
    private boolean isBlocked;
    private Timestamp birthDate;
    private String cellPhoneNumber;
    private String homePhoneNumber;
    private byte[] profilePicture;
    private String verificationCode ;
    private Set<Role> roles;
    private Departement departement;

    public UserResponse(Long id, String userName, String name, String lastName, String nid, String email, String password, boolean isBlocked, Timestamp birthDate, String cellPhoneNumber, String homePhoneNumber, byte[] profilePicture, String verificationCode, Set<Role> roles, Departement departement) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.nid = nid;
        this.email = email;
        this.password = password;
        this.isBlocked = isBlocked;
        this.birthDate = birthDate;
        this.cellPhoneNumber = cellPhoneNumber;
        this.homePhoneNumber = homePhoneNumber;
        this.profilePicture = profilePicture;
        this.verificationCode = verificationCode;
        this.roles = roles;
        this.departement = departement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
