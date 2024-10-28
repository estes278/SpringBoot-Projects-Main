package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail
{
    // annotate the class as an entity

    // define the fields and assign them to columns in the DB

    // generate constructors / getters / setters / toString()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    // reference to Instructor to form bi-directional relationship
    // refers to instructorDetail property in instructor class
    // that is what "mappedBy" means
    // By specifying a list of Cascade types inside braces, we are able to
    // keep Cascading changes of all types except Remove, which means that the
    // original Instructor will stay intact if his InstructorDetail is removed
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail()
    {
    }

    public InstructorDetail(String youtubeChannel, String hobby)
    {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getYoutubeChannel()
    {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel)
    {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    @Override
    public String toString()
    {
        return "InstructorDetail: " +
                "\nid: " + id +
                "\nyoutubeChannel: " + youtubeChannel +
                "\nhobby: " + hobby;
    }
}
