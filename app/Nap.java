import java.util.Date;

public class Nap {
    private long startTime;
    private long endTime;
    private long elapsedTime;
    private Date date;

    public Nap(long startTime, long endTime, long elapsedTime, Date date) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.elapsedTime = elapsedTime;
        this.date = date;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public Date getDate() {
        return date;
    }
}