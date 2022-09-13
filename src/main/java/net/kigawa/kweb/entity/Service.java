package net.kigawa.kweb.entity;

import javax.persistence.*;

@Entity
public class Service
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "strId", nullable = false, unique = true)
    private String strId;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
