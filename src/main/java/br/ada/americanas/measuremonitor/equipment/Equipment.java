package br.ada.americanas.measuremonitor.equipment;

import jakarta.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mac;
    private Integer volume;
    private Integer emptycm;
    private Integer fullcm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getEmptycm() {
        return emptycm;
    }

    public void setEmptycm(Integer emptycm) {
        this.emptycm = emptycm;
    }

    public Integer getFullcm() {
        return fullcm;
    }

    public void setFullcm(Integer fullcm) {
        this.fullcm = fullcm;
    }
}
