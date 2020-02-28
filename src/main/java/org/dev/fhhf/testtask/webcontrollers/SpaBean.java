package org.dev.fhhf.testtask.webcontrollers;

import org.dev.fhhf.testtask.model.Department;
import org.dev.fhhf.testtask.model.Employee;
import org.dev.fhhf.testtask.service.DepartmentService;
import org.dev.fhhf.testtask.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpaBean {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public String home(Model model){
        Employee employee = new Employee();
        model.addAttribute("searchName", employee);
        return "home";
    }

    @GetMapping("/home")
    public String fillTable(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "table :: empList";
    }

    @GetMapping("/home/details/{empId}")
    public String viewEmployeeDetails(@PathVariable("empId") int empId, Model model){
        Employee empDetails = employeeService.getEmployeeById(empId);
        model.addAttribute("empDetails", empDetails);
        return "empDetails :: details";
    }

    @GetMapping("/home/edit/{empId}")
    public String initEditForm(@PathVariable("empId") int empId, Model model){
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("empEdit", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "editForm :: form";
    }

    @PostMapping("/home/update/{empId}")
    public String updateEmployee(@PathVariable("empId") int empId, Employee employee, Model model){
        int dpId = Integer.valueOf( employee.getDepartment().getDpName() );
        Department department = departmentService.getDepartmentById(dpId);
        employee.setDepartment(department);
        employeeService.updateEmployee(employee);
        //model.addAttribute("employees", employeeService.getAllEmployees());
        //return "table :: empList";
        return "redirect:/";
    }

    @GetMapping("/home/cancel")
    public String cancelEditForm(){
        return "resetForm :: form";
    }

    @GetMapping("/home/delete/{empId}")
    public String deleteEmployee(@PathVariable("empId") int empId, Model model){
        Employee delEmployee = new Employee(empId);
        employeeService.deleteEmployee(delEmployee);
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "table :: empList";
    }

    @GetMapping("/home/search/{name}")
    public String searchNameStartsWith(@PathVariable("name") String name, Model model){
        System.out.println("El nombre empieza por : " + name);
        model.addAttribute("employees", employeeService.getAllEmpNameStartsWith(name));
        return "table :: empList";
    }
}
