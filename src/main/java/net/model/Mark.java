package net.model;




import javax.persistence.*;
import java.sql.Date;
@Entity
public class Mark{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    @Column
    private int value;
    @Column()
    private Date date;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Subject subject;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Teacher teacher;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Student student;

    public Mark(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    @Override
    public String toString(){
        return new String("MarkID:"+getId()+", date: "+date.toString()+", value: "+getValue()+" by subject: "
                +getSubject().getName()+"\nto student: "+getStudent().toString())+"from teacher: "+getTeacher().getFirstName()+" "+getTeacher().getLastName();
    }
    public String valueString(){
        if (value == 0)
            return null;
        return "value"+value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark = (Mark) o;

        if (id != mark.id) return false;
        if (value != mark.value) return false;
        if (date != null ? !date.equals(mark.date) : mark.date != null) return false;
        if (subject != null ? !subject.equals(mark.subject) : mark.subject != null) return false;
        if (teacher != null ? !teacher.equals(mark.teacher) : mark.teacher != null) return false;
        return student != null ? student.equals(mark.student) : mark.student == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + value;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }
}
