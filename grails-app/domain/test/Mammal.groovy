package test

class Mammal {

    String scientificName

    static constraints = {
    }

    static mapping = {
        tablePerHierarchy false
        datasources(['dogs', 'humans'])
    }
}
