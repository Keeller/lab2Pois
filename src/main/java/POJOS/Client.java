package POJOS;

public class Client {
    private String name;
    private Integer incomming;
    private Integer countSuccses;
    private Boolean badClient;

    public Client(String name, Integer incomming, Integer countSuccses, Boolean badClient) {
        this.name = name;
        this.incomming = incomming;
        this.countSuccses = countSuccses;
        this.badClient = badClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIncomming() {
        return incomming;
    }

    public void setIncomming(Integer incomming) {
        this.incomming = incomming;
    }

    public Integer getCountSuccses() {
        return countSuccses;
    }

    public void setCountSuccses(Integer countSuccses) {
        this.countSuccses = countSuccses;
    }

    public Boolean getBadClient() {
        return badClient;
    }

    public void setBadClient(Boolean badClient) {
        this.badClient = badClient;
    }
}
