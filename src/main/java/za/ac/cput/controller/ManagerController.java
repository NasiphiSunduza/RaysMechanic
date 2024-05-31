package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.ManagerService;
import za.ac.cput.domain.Manager;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class ManagerController {

   @Autowired
    private ManagerService managerService;

   @PostMapping("/create")
    public Manager create(@RequestBody Manager manager){
       System.out.println("Entered create");
        return managerService.create(manager);
    }

    @GetMapping("/read/{employeeID}")
    public Manager read(@PathVariable long employeeID){
        return  managerService.read(employeeID);
    }

    @PostMapping("/update")
    public  Manager update(@RequestBody Manager manager){
        return  managerService.update(manager);
    }

    @GetMapping("/getAll")
    public List<Manager> getAll(){
        return  managerService.getAll();
    }
}
