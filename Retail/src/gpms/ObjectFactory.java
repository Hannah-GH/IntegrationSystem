
package gpms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the retail.gpms package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConfirmPurchaseResponse_QNAME = new QName("http://gpms.ws/", "confirmPurchaseResponse");
    private final static QName _PublishGroupPurchaseItem_QNAME = new QName("http://gpms.ws/", "publishGroupPurchaseItem");
    private final static QName _ConfirmPurchase_QNAME = new QName("http://gpms.ws/", "confirmPurchase");
    private final static QName _PublishGroupPurchaseItemResponse_QNAME = new QName("http://gpms.ws/", "publishGroupPurchaseItemResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: retail.gpms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmPurchaseResponse }
     * 
     */
    public ConfirmPurchaseResponse createConfirmPurchaseResponse() {
        return new ConfirmPurchaseResponse();
    }

    /**
     * Create an instance of {@link PublishGroupPurchaseItemResponse }
     * 
     */
    public PublishGroupPurchaseItemResponse createPublishGroupPurchaseItemResponse() {
        return new PublishGroupPurchaseItemResponse();
    }

    /**
     * Create an instance of {@link ConfirmPurchase }
     * 
     */
    public ConfirmPurchase createConfirmPurchase() {
        return new ConfirmPurchase();
    }

    /**
     * Create an instance of {@link PublishGroupPurchaseItem }
     * 
     */
    public PublishGroupPurchaseItem createPublishGroupPurchaseItem() {
        return new PublishGroupPurchaseItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPurchaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gpms.ws/", name = "confirmPurchaseResponse")
    public JAXBElement<ConfirmPurchaseResponse> createConfirmPurchaseResponse(ConfirmPurchaseResponse value) {
        return new JAXBElement<ConfirmPurchaseResponse>(_ConfirmPurchaseResponse_QNAME, ConfirmPurchaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishGroupPurchaseItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gpms.ws/", name = "publishGroupPurchaseItem")
    public JAXBElement<PublishGroupPurchaseItem> createPublishGroupPurchaseItem(PublishGroupPurchaseItem value) {
        return new JAXBElement<PublishGroupPurchaseItem>(_PublishGroupPurchaseItem_QNAME, PublishGroupPurchaseItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPurchase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gpms.ws/", name = "confirmPurchase")
    public JAXBElement<ConfirmPurchase> createConfirmPurchase(ConfirmPurchase value) {
        return new JAXBElement<ConfirmPurchase>(_ConfirmPurchase_QNAME, ConfirmPurchase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishGroupPurchaseItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gpms.ws/", name = "publishGroupPurchaseItemResponse")
    public JAXBElement<PublishGroupPurchaseItemResponse> createPublishGroupPurchaseItemResponse(PublishGroupPurchaseItemResponse value) {
        return new JAXBElement<PublishGroupPurchaseItemResponse>(_PublishGroupPurchaseItemResponse_QNAME, PublishGroupPurchaseItemResponse.class, null, value);
    }

}
