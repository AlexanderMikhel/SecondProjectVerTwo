package net.model;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLASS_UNIT")
public class ClassUnit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classUnit")
    private Set<Student> students;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Mark> marks;


    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    public ClassUnit(){

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String toString(){
        return new String("Number:"+getId()+", class master: "+getTeacher().getFirstName()+" "+getTeacher().getLastName())+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassUnit classUnit = (ClassUnit) o;

        return id == classUnit.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
