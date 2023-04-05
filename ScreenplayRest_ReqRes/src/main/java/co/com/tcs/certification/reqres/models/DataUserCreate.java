package co.com.tcs.certification.reqres.models;

public class DataUserCreate {
    private String name;
    private String job;

    public DataUserCreate(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "DataUserCreate{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
