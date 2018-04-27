package by.bsuir.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="resume")
public class Resume {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="date")
    private Timestamp date;

    @Column(name="career_objective")
    private String careerObjective;

    @Column(name="business_trip")
    private int businessTrip;

    @Column(name="relocation")
    private int relocation;

    @Column(name="skills")
    private String skills;

    @Column(name="salary")
    private Double salary;

    @Column(name="number_of_view")
    private int numberOfView;

    @Column(name="user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
    }

    public int getBusinessTrip() {
        return businessTrip;
    }

    public void setBusinessTrip(int businessTrip) {
        this.businessTrip = businessTrip;
    }

    public int getRelocation() {
        return relocation;
    }

    public void setRelocation(int relocation) {
        this.relocation = relocation;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getNumberOfView() {
        return numberOfView;
    }

    public void setNumberOfView(int numberOfView) {
        this.numberOfView = numberOfView;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
