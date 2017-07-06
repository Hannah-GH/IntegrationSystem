
package gpms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publishGroupPurchaseItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="publishGroupPurchaseItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SecretKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="introduction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publishGroupPurchaseItem2", propOrder = {
    "secretKey",
    "productName",
    "introduction",
    "price",
    "limit"
})
public class PublishGroupPurchaseItem {

    @XmlElement(name = "SecretKey")
    protected String secretKey;
    protected String productName;
    protected String introduction;
    protected double price;
    protected int limit;

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
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the introduction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the value of the introduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntroduction(String value) {
        this.introduction = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(int value) {
        this.limit = value;
    }

}
