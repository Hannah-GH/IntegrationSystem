
package bank;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the retail.bank package. 
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

    private final static QName _ListHistoryResponse_QNAME = new QName("http://banksystem/", "listHistoryResponse");
    private final static QName _Transfer_QNAME = new QName("http://banksystem/", "transfer");
    private final static QName _TransferResponse_QNAME = new QName("http://banksystem/", "transferResponse");
    private final static QName _ListHistory_QNAME = new QName("http://banksystem/", "listHistory");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: retail.bank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link ListHistory }
     * 
     */
    public ListHistory createListHistory() {
        return new ListHistory();
    }

    /**
     * Create an instance of {@link ListHistoryResponse }
     * 
     */
    public ListHistoryResponse createListHistoryResponse() {
        return new ListHistoryResponse();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banksystem/", name = "listHistoryResponse")
    public JAXBElement<ListHistoryResponse> createListHistoryResponse(ListHistoryResponse value) {
        return new JAXBElement<ListHistoryResponse>(_ListHistoryResponse_QNAME, ListHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banksystem/", name = "transfer")
    public JAXBElement<Transfer> createTransfer(Transfer value) {
        return new JAXBElement<Transfer>(_Transfer_QNAME, Transfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banksystem/", name = "transferResponse")
    public JAXBElement<TransferResponse> createTransferResponse(TransferResponse value) {
        return new JAXBElement<TransferResponse>(_TransferResponse_QNAME, TransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://banksystem/", name = "listHistory")
    public JAXBElement<ListHistory> createListHistory(ListHistory value) {
        return new JAXBElement<ListHistory>(_ListHistory_QNAME, ListHistory.class, null, value);
    }

}
