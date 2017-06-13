package test

class Address {
    String city
    String country

    static constraints = {
    }

    static mapping = {
        datasource 'humans'
    }
}
