package tech.fatalist.itmo.lab3.service.standalone.results;

import java.util.Objects;

public final class DeletionResult {
    private String status;

    public DeletionResult() {
        this("unknown");
    }

    public DeletionResult(String status) {
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
        var that = (DeletionResult) obj;
        return Objects.equals(this.status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return "DeletionResult[" +
                "status=" + status + ']';
    }

}
