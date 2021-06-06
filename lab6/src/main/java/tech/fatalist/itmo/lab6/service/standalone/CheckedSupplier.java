package tech.fatalist.itmo.lab6.service.standalone;

@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws Exception;
}
