package by.bsuir.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacancy")
public class JobVacancy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="date")
    private Date date;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private String status;

    @Column(name="address")
    private String address;

    public JobVacancy() {
    }

    /**
     * Gets a job vacancy id
     * @return job vacancy id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a job vacancy id
     * @param id job vacancy id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a job vacancy name
     * @return job vacancy name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a job vacancy name
     * @param name job vacancy name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets a date of the job vacancy update
     * @return date of the job vacancy update
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets a date of the job vacancy update
     * @param date date of the job vacancy update
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets a job vacancy description
     * @return job vacancy description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a job vacancy description
     * @param description job vacancy description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets a job vacancy status
     * @return job vacancy status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets a job vacancy status
     * @param status job vacancy status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets a address of possible job
     * @return address of possible job
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a address of possible job
     * @param address address of possible job
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
