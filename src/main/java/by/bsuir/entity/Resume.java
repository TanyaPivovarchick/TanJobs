package by.bsuir.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="resume")
public class Resume {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @Column(name="aspirant_id")
    private int aspirantId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getIsBusinessTripPossible() {
        return businessTrip == 1;
    }

    public void setIsBusinessTripPossible(boolean isBusinessTripPossible) {
        if (isBusinessTripPossible) {
            businessTrip = 1;
        } else {
            businessTrip = 0;
        }
    }

    public boolean getIsRelocationPossible() {
        return relocation == 1;
    }

    public void setIsRelocationPossible(boolean isRelocationPossible) {
        if (isRelocationPossible) {
            relocation = 1;
        } else {
            relocation = 0;
        }
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

    public int getAspirantId() {
        return aspirantId;
    }

    public void setAspirantId(int aspirantId) {
        this.aspirantId = aspirantId;
    }
}
