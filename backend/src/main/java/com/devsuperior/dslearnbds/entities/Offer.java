package com.devsuperior.dslearnbds.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tb_offer")
public class Offer  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String edition;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;



    @OneToMany(mappedBy = "offer")
    private List<Resource> resources = new ArrayList<>();

    public Offer() {
    }

    public Offer(Long id, String edition, Instant startMoment, Instant endMoment) {
        this.id = id;
        this.edition = edition;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Instant getStartMoment() {
        return startMoment;
    }

    public void setStartMoment(Instant startMoment) {
        this.startMoment = startMoment;
    }

    public Instant getEndMoment() {
        return endMoment;
    }

    public void setEndMoment(Instant endMoment) {
        this.endMoment = endMoment;
    }

    public Course getCourse() {
        return course;
    }

    public List<Resource> getResources() {
        return resources;
    }

}
