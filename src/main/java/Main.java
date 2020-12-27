import dao.ClimberDao;

import dao.GroupDao;
import dao.MountainDao;
import jpa.Climber;
import jpa.Group;
import jpa.Mountain;
import repository.ClimberRepository;
import repository.GroupRepository;
import repository.MountainRepository;
import specification.ClimberByAge;
import specification.GroupByNameOfMountain;
import specification.GroupByOpenClose;
import specification.MountainByCountry;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;



public class Main {
    public static void main(String[] args) {

        Climber climberOleg = new Climber("Oleg", "St.Petersburg", 30);
        Climber climberMaksim = new Climber("Maksim", "Moscow", 31);
        Climber climberEgor = new Climber("Egor", "Pskov", 32);
        Climber climberVladimir = new Climber("Vladimir", "Novosibirsk", 33);
        Climber climberAlex = new Climber("Alex", "Tomsk", 34);

        Mountain everest = new Mountain("Everest", "Himalayas", 8848);
        Mountain annapurna = new Mountain("Annapurna", "Nepal", 8586);
        Mountain elbrus = new Mountain("Elbrus", "Caucasus", 5642);

        Group groupOnEverest = new Group(everest, Group.OPEN, LocalDate.of(2020,Month.DECEMBER,20), LocalTime.of(18,00));
        Group groupOnEverestAllInclusive = new Group(everest, Group.OPEN, LocalDate.of(2020,Month.DECEMBER,21), LocalTime.of(18,00));
        Group groupOnAnnapurna = new Group(annapurna, Group.OPEN, LocalDate.of(2020,Month.DECEMBER,22), LocalTime.of(15,00));
        Group groupOnElbrus = new Group(elbrus, Group.OPEN, LocalDate.of(2020,Month.DECEMBER,23), LocalTime.of(10,00));

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager manager = managerFactory.createEntityManager();

        ClimberDao climberDao = new ClimberDao(manager);
        MountainDao mountainDao = new MountainDao(manager);
        GroupDao groupDao = new GroupDao(manager);

        groupOnEverest.addClimber(climberAlex);
        groupOnEverestAllInclusive.addClimber(climberEgor);
        groupOnEverestAllInclusive.addClimber(climberMaksim);
        groupOnAnnapurna.addClimber(climberOleg);
        groupOnElbrus.addClimber(climberVladimir);

        groupOnEverest.setStatus(Group.OPEN);
        groupOnEverestAllInclusive.setStatus(Group.OPEN);
        groupOnAnnapurna.setStatus(Group.OPEN);
        groupOnElbrus.setStatus(Group.CLOSE);


        manager.getTransaction().begin();

        climberDao.add(climberOleg);
        climberDao.add(climberEgor);
        climberDao.add(climberMaksim);
        climberDao.add(climberAlex);

        mountainDao.add(everest);
        mountainDao.add(annapurna);
        mountainDao.add(elbrus);

        groupDao.add(groupOnEverest);
        groupDao.add(groupOnEverestAllInclusive);
        groupDao.add(groupOnAnnapurna);
        groupDao.add(groupOnElbrus);

        manager.getTransaction().commit();


        System.out.println("From TO -----------------------------------");
        System.out.println(new ClimberRepository(manager).getBySpecification(new ClimberByAge(30, 33)));

        System.out.println("Group by name of Mountain -----------------");
        System.out.println(new GroupRepository(manager).getBySpecification(new GroupByNameOfMountain(everest)));

        System.out.println("Mountain by name of Country ---------------");
        System.out.println(new MountainRepository(manager).getBySpecification(new MountainByCountry("Nepal")));

        System.out.println("Group by open or close --------------------");
        System.out.println(new GroupRepository(manager).getBySpecification(new GroupByOpenClose(Group.CLOSE)));
    }
}
