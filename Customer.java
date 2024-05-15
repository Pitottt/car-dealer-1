package IS202_EL_00000099782_Raiyan_week6;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private java.util.LinkedList<String> inquiries;

    public Customer(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.inquiries = new java.util.LinkedList<>();
    }

    public void sendInquiry(String message) {
        inquiries.add(message);
        System.out.println(name + " sent an inquiry: " + message);
    }
    
    public void respondToOffer(Dealer dealer, Car car, Car alternative) {
        if (car.getQuantity() > 0) {
            System.out.println(name + " told " + dealer.getName() + " that they will take the " + car.getMake() + " " + car.getModel() + " and asked to ship it to " + address);
        } else {
            System.out.println(name + " told " + dealer.getName() + " that they are interested in the " + alternative.getMake() + " " + alternative.getModel() + " and asked to ship it to " + address);
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public java.util.LinkedList<String> getInquiries() {
        return inquiries;
    }
}