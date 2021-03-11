/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

/**
 *
 * @author ufukcelik
 */
@Entity
@Table(name = "URUN", catalog = "", schema = "UFUK")
@NamedQueries({
    @NamedQuery(name = "Urun.findAll", query = "SELECT u FROM Urun u")
    , @NamedQuery(name = "Urun.findById", query = "SELECT u FROM Urun u WHERE u.id = :id")
    , @NamedQuery(name = "Urun.findByAd", query = "SELECT u FROM Urun u WHERE u.ad = :ad")
    , @NamedQuery(name = "Urun.findByTanim", query = "SELECT u FROM Urun u WHERE u.tanim = :tanim")
    , @NamedQuery(name = "Urun.findByResimad", query = "SELECT u FROM Urun u WHERE u.resimad = :resimad")})
public class Urun implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AD")
    private String ad;
    @Column(name = "TANIM")
    private String tanim;
    @Column(name = "RESIMAD")
    private String resimad;
    @Lob
    @Column(name = "RESIM")
    private byte[] resim;

    public ImageIcon getUrunResim() {
        return new ImageIcon(new ImageIcon(resim).getImage().getScaledInstance(
                100, 100, java.awt.Image.SCALE_SMOOTH));
    }
    
    public Urun() {
    }

    public Urun(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        String oldAd = this.ad;
        this.ad = ad;
        changeSupport.firePropertyChange("ad", oldAd, ad);
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        String oldTanim = this.tanim;
        this.tanim = tanim;
        changeSupport.firePropertyChange("tanim", oldTanim, tanim);
    }

    public String getResimad() {
        return resimad;
    }

    public void setResimad(String resimad) {
        String oldResimad = this.resimad;
        this.resimad = resimad;
        changeSupport.firePropertyChange("resimad", oldResimad, resimad);
    }

    public byte[] getResim() {
        return resim;
    }

    public void setResim(byte[] resim) {
        byte[] oldResim = this.resim;
        this.resim = resim;
        changeSupport.firePropertyChange("resim", oldResim, resim);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urun)) {
            return false;
        }
        Urun other = (Urun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sirket.Urun[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
