import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order {
    private String orderId;
    private String sandwichType;

    public Order(){}

    @XmlElement
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @XmlElement
    public String getSandwichType() {
        return sandwichType;
    }

    public void setSandwichType(String sandwichType) {
        this.sandwichType = sandwichType;
    }
}