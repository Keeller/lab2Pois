package POJOS;

public class Credit {

    private Integer summ;
    private Integer percent;

    public Credit(Integer summ, Integer percent) {
        this.summ = summ;
        this.percent = percent;
    }

    public Integer getSumm() {
        return summ;
    }

    public void setSumm(Integer summ) {
        this.summ = summ;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
}
