package org.dev.fhhf.testtask.webcontrollers;

import org.dev.fhhf.testtask.model.Department;
import org.dev.fhhf.testtask.model.Employee;
import org.dev.fhhf.testtask.service.DepartmentService;
import org.dev.fhhf.testtask.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpaBean {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    private int size = 10, page = 1;

    @GetMapping("/")
    public String home(Model model){

        Employee employee = new Employee();
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "home";
    }

    @GetMapping("/home/page/{page}/{size}")
    public String fillTable(@PathVariable("page") int page,
                            @PathVariable("size") int size, Model model){
        this.page = page;
        this.size = size;
        List<Long> pages = new ArrayList<>();
        double sizeD = size;
        double countPages = Math.ceil( employeeService.getTotalEntries() / sizeD );
        for(long i = 1; i <= countPages; i++){
            pages.add(i);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("employees", employeeService.getAllPaginated(this.page, this.size));

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

        employee.setEmpId(empId);
        int dpId = Integer.valueOf( employee.getDepartment().getDpName() );
        Department department = departmentService.getDepartmentById(dpId);
        employee.setDepartment(department);

        if(employee.getEmpName().equals("")){
            model.addAttribute("empNameError", true);
            model.addAttribute("empEdit", employee);
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "editForm :: form";
        }

        model.addAttribute("empNameError", false);
        employeeService.updateEmployee(employee);

        return "redirect:/home/page/" + page + "/" + size;
    }

    @GetMapping("/home/delete/{empId}")
    public String deleteEmployee(@PathVariable("empId") int empId, Model model){

        Employee delEmployee = new Employee(empId);
        employeeService.deleteEmployee(delEmployee);
        model.addAttribute("employees", employeeService.getAllEmployees());

        return "redirect:/home/page/" + page + "/" + size;
    }

    @GetMapping("/home/search/{name}")
    public String searchNameStartsWith(@PathVariable("name") String name, Model model){

        System.out.println("El nombre empieza por : " + name);
        model.addAttribute("employees", employeeService.getAllEmpNameStartsWith(name));

        return "table :: empList";
    }
}
