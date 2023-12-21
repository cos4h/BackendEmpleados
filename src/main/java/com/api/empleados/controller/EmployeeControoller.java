package com.api.empleados.controller;

import com.api.empleados.model.Employee;
import com.api.empleados.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = """
        https://cos4h.github.io, 191.95.147.217, 2606:50c0:8002::153,
                  2606:50c0:8000::153,
                  2606:50c0:8001::153,
                  2606:50c0:8003::153,
                  185.199.109.153,
                  185.199.108.153,
                  185.199.111.153,
                  185.199.110.153""")
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
