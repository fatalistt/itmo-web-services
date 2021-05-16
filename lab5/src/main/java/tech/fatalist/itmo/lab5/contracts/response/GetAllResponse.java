package tech.fatalist.itmo.lab5.contracts.response;

import tech.fatalist.itmo.lab5.contracts.Person;

public record GetAllResponse(Iterable<Person> persons) {
}
