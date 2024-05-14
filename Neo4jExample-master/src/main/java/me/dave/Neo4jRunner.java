package me.dave;

import me.dave.account.Account;
import me.dave.account.AccountRepository;
import me.dave.account.Role;
import me.dave.account.RoleRepository;
import me.dave.model.Movie;
import me.dave.model.User;
import me.dave.model.UserRepository;
import me.dave.person.Person;
import me.dave.person.PersonRepository;
import me.dave.person.Role2;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        accountRepository.deleteAll();
        roleRepository.deleteAll();
        personRepository.deleteAll();
        userRepository.deleteAll();

        //1.SessionFactory를 통해 neo4j를 사용.
        Account account1 = new Account();
        account1.setUsername("Dave");
        account1.setEmail("dave@gmail.com");

        Role role1 = new Role();
        role1.setRoleName("admin");
        account1.getRoles().add(role1);

        Session session = sessionFactory.openSession();
        session.save(account1);
        sessionFactory.close();

        //2.Repository를 통해 neo4j를 사용.
        Account account2 = new Account();
        account2.setUsername("Camel");
        account2.setEmail("camel@naver.com");

        Role role2 = new Role();
        role2.setRoleName("user");
        account2.getRoles().add(role2);

        accountRepository.save(account2);

        System.out.println("Process was finished");
//--------------------------------------------------------------------------
        //1.SessionFactory를 통해 neo4j를 사용.
        Person person1 = new Person();
        person1.setName("데이브");
        person1.setAge(28);

        Role2 role11 = new Role2();
        role11.setRoleName("admin");
        person1.getRoles().add(role11);

        Session session2 = sessionFactory.openSession();
        session2.save(person1);
        sessionFactory.close();

        //2.Repository를 통해 neo4j를 사용.
        Person person2 = new Person();
        person2.setName("홍길동");
        person2.setAge(30);

        Role2 role22 = new Role2();
        role22.setRoleName("user");
        person2.getRoles().add(role22);

        personRepository.save(person2);

        System.out.println("Person 입력");
        //--------------------------------------------------------------------------
        User user1 = new User();
        user1.setName("강하늘");
        user1.setAge(31);

        Movie movie1 = new Movie();
        movie1.setDirector("이준익");
        movie1.setTitle("하늘하늘");

        user1.getMovies().add(movie1);
        userRepository.save(user1);
        System.out.println("User 입력");

    }
}
