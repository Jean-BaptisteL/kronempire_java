package models;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Integer id_player;

    @Column(name="email_player", nullable = false)
    private String email_player;

    @Column(name="password_player", nullable = false)
    private String password_player;

    @Column(name="date_player", nullable = false)
    private Date date_player;

    @Column(name="pseudo_player", nullable = false)
    private String pseudo_player;

    @Column(name="lastConnection_player", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnection_player;

    @Column(name="status_player", nullable = false)
    private TinyIntJdbcType status_player;

    @OneToOne(mappedBy = "id_player_stat")
    private Player_Stat playerStats;

    public void setId_player(Integer idPlayer) {
        this.id_player = idPlayer;
    }

    public Integer getId_player() {
        return id_player;
    }

    public String getEmail_player() {
        return email_player;
    }

    public void setEmail_player(String email_player) {
        this.email_player = email_player;
    }

    public String getPassword_player() {
        return password_player;
    }

    public void setPassword_player(String password_player) {
        this.password_player = password_player;
    }

    public Date getDate_player() {
        return date_player;
    }

    public void setDate_player(Date date_player) {
        this.date_player = date_player;
    }

    public String getPseudo_player() {
        return pseudo_player;
    }

    public void setPseudo_player(String pseudo_player) {
        this.pseudo_player = pseudo_player;
    }

    public Date getLastConnection_player() {
        return lastConnection_player;
    }

    public void setLastConnection_player(Date lastConnection_player) {
        this.lastConnection_player = lastConnection_player;
    }

    public TinyIntJdbcType getStatus_player() {
        return status_player;
    }

    public void setStatus_player(TinyIntJdbcType status_player) {
        this.status_player = status_player;
    }

    public Player_Stat getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(Player_Stat playerStats) {
        this.playerStats = playerStats;
    }
}
