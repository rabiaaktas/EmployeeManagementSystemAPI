package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Departments;
import com.employee.management.EmployeeManagement.repository.DepartmentsRepository;
import com.employee.management.EmployeeManagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Departments> allDepartments(){
        return departmentsRepository.findAll();
    }

    @Transactional
    public ResponseEntity addDepartment(Departments departments){
        boolean exist = departmentsRepository.existsBydepartmentName(departments.getDepartmentName());
        if (!exist && managerRepository.existsByemployeeId(departments.getManagerId())){
            Departments newDepartment = new Departments();
            newDepartment.setDepartmentName(departments.getDepartmentName());
            newDepartment.setManagerId(departments.getManagerId());
            newDepartment.setLocationId(departments.getLocationId());
            departmentsRepository.save(newDepartment);
        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @Transactional
    public List<Departments> getDepartmentsByLocation(String city, String streetAddress, String countryName){
        Query location = entityManager.createNativeQuery("SELECT d.* " +
                "FROM departments d, locations l, countries c " +
                "WHERE d.locationId = l.locationID AND l.countryId = c.countryID AND " +
                "(l.city LIKE ?1 OR l.street_address LIKE ?2 OR c.countryName LIKE ?3)")
                .setParameter(1, "%" + city + "%")
                .setParameter(2, "%" + streetAddress + "%")
                .setParameter(3, "%"+ countryName + "%");
        return location.getResultList();
    }

    @Transactional
    public ResponseEntity deleteDepartment(int id){
        Departments departments = departmentsRepository.findBydepartmentId(id);
        departmentsRepository.delete(departments);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity updateDepartment(Departments departments){
        return new ResponseEntity(HttpStatus.OK);
    }
}
