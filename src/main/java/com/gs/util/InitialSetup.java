package com.gs.util;

import com.gs.model.Department;
import com.gs.model.KeyResult;
import com.gs.model.Objective;
import com.gs.model.ObjectiveType;
import com.gs.model.ResultType;
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

        ResultType resultType = new ResultType();
        resultType.setLabel("Binary");
        resultType.setType("Binary");
        ResultType.persist(resultType);

        KeyResult keyResult = new KeyResult();
        keyResult.setTitle("title");
        keyResult.setDescription("test description");
        keyResult.setType(resultType);
        keyResult.setObjective(objective);
        keyResult.setDepartment(department);
        keyResult.setOwner(owner);
        KeyResult.persist(keyResult);
    }
}
