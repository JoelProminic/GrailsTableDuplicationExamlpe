package test

class Human extends Mammal {
    String name

    Address address

    static constraints = {
    }

    static mapping = {
        datasource "humans"
    }
}
