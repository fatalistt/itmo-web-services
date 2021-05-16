package tech.fatalist.itmo.lab6.contracts.response;

import tech.fatalist.itmo.lab6.contracts.Person;

public record GetAllResponse(Iterable<Person> persons) {
}
