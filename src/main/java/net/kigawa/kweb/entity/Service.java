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
    private String topImg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    private String title;

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

    public String getTopImg()
    {
        return topImg;
    }

    public void setTopImg(String topUrl)
    {
        this.topImg = topUrl;
    }
}
