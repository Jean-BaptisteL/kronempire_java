package models;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_message;

    @Column(name = "object_message", nullable = false)
    private String object_message;

    @Column(name = "content_message", nullable = false, length = 500)
    private String content_message;

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getObject_message() {
        return object_message;
    }

    public void setObject_message(String object_message) {
        this.object_message = object_message;
    }

    public String getContent_message() {
        return content_message;
    }

    public void setContent_message(String content_message) {
        this.content_message = content_message;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
