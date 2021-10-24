package com.devsuperior.dslearnbds.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*

abstract = n pode ser instanciada  , ou vai dar o new Content() ou new Task()
@Inheritance = Quando implementamos uma herança no banco de dados relacional
temos que decidir se vamos implementar os tipos diferentes em uma tabela só,ou seja,
se eu tiver um tipo e não tiver outro , vai ser setado nulo no valor do outro

strategy JOINED = Cria as 3 tabelas

OBS :

Se for muitos campo , vai valer mais a pena gerar uma tabela pra cada


 */

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(name = "tb_lessons_done", joinColumns = @JoinColumn(name = "lesson_id")
            , inverseJoinColumns = {
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "offer_id")
    })
    private Set<Enrollment> enrollmentsDone = new HashSet<>();

    public Lesson() {

    }

    public Lesson(Long id, String title, String position) {
        this.id = id;
        this.title = title;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Section getSection() {
        return section;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
