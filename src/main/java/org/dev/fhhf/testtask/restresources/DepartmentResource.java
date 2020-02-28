package org.dev.fhhf.testtask.restresources;

import org.dev.fhhf.testtask.model.Department;
import org.dev.fhhf.testtask.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dep")
public class DepartmentResource {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        //If should process then check unique dpName
        departmentService.createDepartment(department);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/{dpId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("dpId") int dpId, @RequestBody Department department){
        //Process necessary fields if required
        departmentService.updateDepartment(department);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/{dpId}")
    public void deleteDepartment(@PathVariable("dpId") int dpId){
        Department department = new Department(dpId);
        departmentService.deleteDepartment(department);
    }

}
