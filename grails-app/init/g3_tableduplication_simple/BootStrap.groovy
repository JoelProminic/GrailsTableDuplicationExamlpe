package g3_tableduplication_simple

import test.*
import org.springframework.context.ApplicationContext
import grails.util.Holders



class BootStrap {

    def init = { servletContext ->
        ApplicationContext ctx = Holders.applicationContext
        def dataSourceNames = ctx.beanDefinitionNames.findAll{ String curName ->
            // Each dataSource will have beans: dataSource*, dataSourceUnproxied*, dataSourceLazy*
            // Only select the base bean for each datasource
            curName =~ /^dataSource($|_)/
        }
        dataSourceNames.each {
            println it
        }
        
        Dog dog = new Dog()
        dog.scientificName = 'canis familiaris'
        dog.name = 'Fido'
        dog.breed = 'Golden Retriever'
        dog.save(flush:true, failOnError:true)
        
        Human human = new Human()
        human.scientificName = 'homo sapien'
        human.name = 'John Doe'
        human.save(flush:true, failOnError:true)


        // Verification of the lookup behavior

        assert Dog.findByName('Fido') == dog
        assert Dog.findByScientificName('canis familiaris') == dog
        assert Dog.dogs.findByName('Fido') == dog
        assert Dog.dogs.findByScientificName('canis familiaris') == dog
        assert Mammal.dogs.findByScientificName('canis familiaris') == dog
        assert !Mammal.humans.findByScientificName('canis familiaris')


        assert Human.findByName('John Doe') == human
        assert Human.findByScientificName('homo sapien') == human
        assert Human.humans.findByName('John Doe') == human
        assert Human.humans.findByScientificName('homo sapien') == human
        assert Mammal.humans.findByScientificName('homo sapien') == human
        assert !Mammal.dogs.findByScientificName('homo sapien')


        // These calls return a MissingPropertyException for the datasource name
        //assert !Dog.humans.findByName('Fido')
        //assert !Dog.humans.findByScientificName('canis familiaris')
        //assert !Human.dogs.findByName('John Doe')
        //assert !Human.dogs.findByScientificName('homo sapien')



    }
    def destroy = {
    }
}
