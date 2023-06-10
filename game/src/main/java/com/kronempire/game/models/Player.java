package com.kronempire.game.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Integer id_player;

    @Column(name="email_player", nullable = false)
    private String email;

    @Column(name="password_player", nullable = false)
    private String password_player;

    @Column(name="date_player", nullable = false)
    private LocalDate date_player;

    @Column(name="pseudo_player", nullable = false)
    private String pseudo_player;

    @Column(name="last_connection_player", nullable = false)
    private LocalDateTime lastConnection_player;

    @Column(name="status_player", nullable = false)
    private Integer status_player;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private Set<PlayerStat> stats;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private Set<Message> messages;

    private String role = "ROLE_USER";

    public Player(String email, String password_player, String pseudo_player) {
        this.email = email;
        this.password_player = password_player;
        this.pseudo_player = pseudo_player;
        this.date_player = LocalDate.now();
        this.lastConnection_player = LocalDateTime.now();
        this.status_player = 1;
    }

    public Player() {

    }

    public void setId_player(Integer idPlayer) {
        this.id_player = idPlayer;
    }

    public Integer getId_player() {
        return id_player;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_player) {
        this.email = email_player;
    }

    public String getPassword_player() {
        return password_player;
    }

    public void setPassword_player(String password_player) {
        this.password_player = password_player;
    }

    public LocalDate getDate_player() {
        return date_player;
    }

    public void setDate_player(LocalDate date_player) {
        this.date_player = date_player;
    }

    public String getPseudo_player() {
        return pseudo_player;
    }

    public void setPseudo_player(String pseudo_player) {
        this.pseudo_player = pseudo_player;
    }

    public LocalDateTime getLastConnection_player() {
        return lastConnection_player;
    }

    public void setLastConnection_player(LocalDateTime lastConnection_player) {
        this.lastConnection_player = lastConnection_player;
    }

    public Integer getStatus_player() {
        return status_player;
    }

    public void setStatus_player(Integer status_player) {
        this.status_player = status_player;
    }

    public Set<PlayerStat> getStats() {
        return stats;
    }

    public void setStats(Set<PlayerStat> stats) {
        this.stats = stats;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id_player=" + id_player +
                ", email_player='" + email + '\'' +
                ", password_player='" + password_player + '\'' +
                ", date_player=" + date_player +
                ", pseudo_player='" + pseudo_player + '\'' +
                ", lastConnection_player=" + lastConnection_player +
                ", status_player='" + status_player + '\'' +
                '}';
    }
}
