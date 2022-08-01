package net.kigawa.kweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AdminUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;

    public AdminUser()
    {
    }

    public AdminUser(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "AdminUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminUser adminUser = (AdminUser) o;
        return Objects.equals(id, adminUser.id) && Objects.equals(userName, adminUser.userName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, userName);
    }
}
