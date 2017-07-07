package net.model;


import javax.persistence.*;
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinTable(name = "STUD_CLASS",
            joinColumns = @JoinColumn(name = "ID_STUDENT"),
    inverseJoinColumns = @JoinColumn(name = "ID_CLASS"))
    private ClassUnit classUnit;

    public Student(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public ClassUnit getClassUnit() {
        return classUnit;
    }
    public void setClassUnit(ClassUnit classUnit) {
        this.classUnit = classUnit;
    }

    @Override
    public String toString(){
        return new String("StudentID:"+getId()+", "+getFirstName()
                +" "+getLastName()+", class: "+getClassUnit().getId())+"\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        return classUnit != null ? classUnit.equals(student.classUnit) : student.classUnit == null;
    }
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (classUnit != null ? classUnit.hashCode() : 0);
        return result;
    }
}
