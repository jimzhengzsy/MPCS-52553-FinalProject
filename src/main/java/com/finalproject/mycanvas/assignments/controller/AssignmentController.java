package com.finalproject.mycanvas.assignments.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.assignments.services.AssignmentService;
import com.finalproject.mycanvas.users.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService =assignmentService;
    }

    @GetMapping("/assignments/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.getAssignmentById(id);
        return assignment;
    }

    @GetMapping("/assignments/{id}/users")
    public List<User> getUsersByAssignmentId(@PathVariable Long id) {
        List<User> users = assignmentService.getUsersWithAssignmentId(id);
        return users;
    }

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        return assignments;
    }

    @PostMapping("/assignments")
    public Assignment createAssignment( @RequestBody Assignment assignment){

        assignmentService.createAssignment(assignment);
        return assignment;
    }

    @PutMapping("/assignments/{id}")
    public Assignment updateAssignment(@PathVariable Long id,
                                        @RequestBody Assignment assignment){

        assignment = assignmentService.updateAssignment(id,assignment);
        return assignment;
    }

}
