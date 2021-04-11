package tech.fatalist.itmo.lab2.service.standalone.results;

public record DeletionResult(String status) {
    public DeletionResult() {
        this("unknown");
    }
}
