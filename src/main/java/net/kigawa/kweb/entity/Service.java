package net.kigawa.kweb.entity;

import javax.persistence.*;

@Entity
public class Service
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String strId;
    @Column
    private String topUrl;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStrId()
    {
        return strId;
    }

    public void setStrId(String strId)
    {
        this.strId = strId;
    }

    public String getTopUrl()
    {
        return topUrl;
    }

    public void setTopUrl(String topUrl)
    {
        this.topUrl = topUrl;
    }
}
