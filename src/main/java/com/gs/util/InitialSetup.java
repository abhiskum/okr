package com.gs.util;

import com.gs.model.Department;
import com.gs.model.KeyResult;
import com.gs.model.Objective;
import com.gs.model.ObjectiveType;
import com.gs.model.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by degandhi on 7/6/20.
 */
@Singleton
public class InitialSetup {

    @Transactional
    public void setup(@Observes StartupEvent startupEvent) {
        Department department = new Department();
        department.setName("dummy department");
        Department.persist(department);

        Department department2 = new Department();
        department2.setName("department2");
        department2.setParent(department);
        Department.persist(department2);

        User owner = new User();
        owner.setFirstName("first name");
        owner.setLastName("last name");
        Collection<Department> departments = new HashSet<>();
        departments.add(department);
        owner.setDepartments(departments);
        User.persist(owner);

        ObjectiveType objectiveType = new ObjectiveType();
        objectiveType.setLabel("Company");
        objectiveType.setType("Company");
        ObjectiveType.persist(objectiveType);

        Objective objective = new Objective();
        objective.setTitle("test");
        objective.setDescription("test description");
        objective.setDepartment(department);
        objective.setOwner(owner);
        objective.setType(objectiveType);
        objective.setStartDate(LocalDate.now());
        objective.setEndDate(LocalDate.now());
        objective.setStatus("In progress");
        Objective.persist(objective);

        Objective objective1 = new Objective();
        objective1.setTitle("test1");
        objective1.setDescription("test description1");
        objective1.setDepartment(department);
        objective1.setOwner(owner);
        objective1.setType(objectiveType);
        objective1.setStartDate(LocalDate.now());
        objective1.setEndDate(LocalDate.now());
        objective1.setStatus("Closed");
        objective1.setParent(objective);
        Objective.persist(objective1);

        KeyResult keyResult1 = new KeyResult();
        keyResult1.setTitle("title");
        keyResult1.setDescription("test description");
        keyResult1.setCurrentState(100D);
        keyResult1.setObjective(objective1);
        keyResult1.setOwner(owner);
        keyResult1.setCompletion(keyResult1.getCurrentState()/100);
        KeyResult.persist(keyResult1);
    }
}
