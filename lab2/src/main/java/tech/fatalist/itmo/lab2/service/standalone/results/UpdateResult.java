package tech.fatalist.itmo.lab2.service.standalone.results;

public record UpdateResult(String status) {
    public UpdateResult() {
        this("unknown");
    }
}
