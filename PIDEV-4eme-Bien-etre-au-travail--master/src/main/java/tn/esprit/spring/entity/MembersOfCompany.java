package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MembersOfCompany implements Serializable {
    @Id
    private String nid;
    private String nameAndLastName;

    public MembersOfCompany(String nid, String nameAndLastName) {
        this.nid = nid;
        this.nameAndLastName = nameAndLastName;
    }

    public MembersOfCompany() {
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}
