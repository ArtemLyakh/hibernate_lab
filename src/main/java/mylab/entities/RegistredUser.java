package mylab.entities;

import java.util.Date;
import javax.persistence.*;


@Entity
public class RegistredUser extends User {
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegister;
    
    public Date getDateRegister() {
        return dateRegister;
    }
    
    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }
}
