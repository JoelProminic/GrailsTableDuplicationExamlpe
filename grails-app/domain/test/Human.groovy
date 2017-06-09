package test

class Human extends Mammal {
    String name

    static constraints = {
    }

    static mapping = {
        datasource "humans"
    }
}
