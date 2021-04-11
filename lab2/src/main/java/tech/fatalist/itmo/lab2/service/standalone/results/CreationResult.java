package tech.fatalist.itmo.lab2.service.standalone.results;

import java.util.Objects;

public final class CreationResult {
    private int id;

    public CreationResult() {
    }

    public CreationResult(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreationResult) obj;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CreationResult[" +
                "id=" + id + ']';
    }

}
