package com.api.empleados.controller;

import com.api.empleados.model.Employee;
import com.api.empleados.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "https://cos4h.github.io/EmpleadosFrontend")
@RestController
@RequestMapping("/api/employees")
public class EmployeeControoller {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(employeeService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.saveEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String id,
                                                   @RequestBody Employee employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable(value = "id") String id) {
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

}
