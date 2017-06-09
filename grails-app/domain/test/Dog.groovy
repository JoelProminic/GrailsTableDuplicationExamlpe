package test

class Dog extends Mammal {

    String breed
    String name

    static constraints = {
    }

    static mapping = {
        datasource "dogs"
    }
}
