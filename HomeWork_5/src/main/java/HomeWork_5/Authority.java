package HomeWork_5;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "id_auth")
    private Long id_auth;

    @Column(name = "username")
    private String username;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "authority")
    private List<User> users;

    @Column(name = "authority", nullable = false)
    private String authority;

    public Authority() {
    }

    public List <User> getUsers() {
        return users;
    }

    public void setUsers(List <User> users) {
        this.users = users;
    }

    public Long getId_auth() {
        return id_auth;
    }

    public void setId_auth(Long id_auth) {
        this.id_auth = id_auth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
