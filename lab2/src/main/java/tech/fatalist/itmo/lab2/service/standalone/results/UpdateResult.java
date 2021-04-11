package tech.fatalist.itmo.lab2.service.standalone.results;

import java.util.Objects;

public final class UpdateResult {
    private String status;

    public UpdateResult() {
        this("unknown");
    }

    public UpdateResult(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UpdateResult) obj;
        return Objects.equals(this.status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return "UpdateResult[" +
                "status=" + status + ']';
    }

}
