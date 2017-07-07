
package gpms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for confirmPurchase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="confirmPurchase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SecretKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmPurchase", propOrder = {
    "secretKey",
    "confirm"
})
public class ConfirmPurchase {

    @XmlElement(name = "SecretKey")
    protected String secretKey;
    protected String confirm;

    /**
     * Gets the value of the secretKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Sets the value of the secretKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretKey(String value) {
        this.secretKey = value;
    }

    /**
     * Gets the value of the confirm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * Sets the value of the confirm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirm(String value) {
        this.confirm = value;
    }

}
