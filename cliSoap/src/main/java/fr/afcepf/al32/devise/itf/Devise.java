
package fr.afcepf.al32.devise.itf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour devise complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="devise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="monnaie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "devise", propOrder = {
    "change",
    "monnaie"
})
public class Devise {

    protected Double change;
    protected String monnaie;

    /**
     * Obtient la valeur de la propri�t� change.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getChange() {
        return change;
    }

    /**
     * D�finit la valeur de la propri�t� change.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setChange(Double value) {
        this.change = value;
    }

    /**
     * Obtient la valeur de la propri�t� monnaie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaie() {
        return monnaie;
    }

    /**
     * D�finit la valeur de la propri�t� monnaie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaie(String value) {
        this.monnaie = value;
    }

}
