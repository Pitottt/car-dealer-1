package IS202_EL_00000099782_Raiyan_week6;

public class Car extends Vehicle {
    private int quantity;
    public static CarLinkedList inventory = new CarLinkedList();

    public Car(String make, String model, int year, double price, int quantity) {
        super(make, model, year, price);
        this.quantity = quantity;
        inventory.addCar(this);
    }

    @Override
    public void displayVehicleDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Price: " + price);
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class CarLinkedList {
        private Node head;
        private Node tail;

        private class Node {
            Car car;
            Node prev;
            Node next;

            Node(Car car) {
                this.car = car;
            }
        }

        public void addCar(Car car) {
            Node node = new Node(car);
            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public void removeCar(Car car) {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.car.equals(car)) {
                    if (temp.prev != null) {
                        temp.prev.next = temp.next;
                    }
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                    if (temp == head) {
                        head = temp.next;
                    }
                    if (temp == tail) {
                        tail = temp.prev;
                    }
                }
            }
        }

        public Iterator iterator() {
            return new Iterator(head);
        }

        public class Iterator {
            private Node current;

            public Iterator(Node node) {
                current = node;
            }

            public boolean hasNext() {
                return current != null;
            }

            public Car next() {
                Car car = current.car;
                current = current.next;
                return car;
            }

            public void remove() {
                CarLinkedList.this.removeCar(current.car);
            }
        }
    }
}