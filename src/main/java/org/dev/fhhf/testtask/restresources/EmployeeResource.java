package org.dev.fhhf.testtask.restresources;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dev.fhhf.testtask.model.Department;
import org.dev.fhhf.testtask.model.Employee;
import org.dev.fhhf.testtask.service.DepartmentService;
import org.dev.fhhf.testtask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empName}")
    @ApiOperation(value = "Find name starts like given string",
            notes = "Provide a string to look up names which start with it",
            response = Employee.class)
    public List<Employee> findAllEmployeesNameStartsWith(@ApiParam(value = "String value for name starts with", required = true)
                                                         @PathVariable("empName") String empName){
        return employeeService.getAllEmpNameStartsWith(empName);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){

        employeeService.createEmployee(employee);

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee employee){

        employeeService.updateEmployee(employee);

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable("empId") int empId){
        Employee delEmp = new Employee(empId);
        employeeService.deleteEmployee( delEmp );
    }
}
