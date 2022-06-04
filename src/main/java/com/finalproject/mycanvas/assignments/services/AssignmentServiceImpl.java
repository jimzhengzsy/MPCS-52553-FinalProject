package com.finalproject.mycanvas.assignments.services;

import com.finalproject.mycanvas.assignments.entity.AssignmentEntity;
import com.finalproject.mycanvas.assignments.model.Assignment;
import com.finalproject.mycanvas.assignments.repository.AssignmentRepository;
import com.finalproject.mycanvas.users.entity.UserEntity;
import com.finalproject.mycanvas.users.model.User;
import org.hibernate.tool.schema.internal.exec.AbstractScriptSourceInput;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImpl implements AssignmentService{

    private AssignmentRepository assignmentRepository;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public Assignment getAssignmentById(Long id) {
        AssignmentEntity assignmentEntity = assignmentRepository.findById(id).get();
        Assignment assignment = new Assignment();
        BeanUtils.copyProperties(assignmentEntity,assignment);
        return assignment;
    }

    @Override
    public Assignment addAssignmentWithUser(Long userId, Long assignmentId) {
        return null;
    }

    @Override
    public Assignment addAssignmentWithUsers(List<User> users, Long assignmentId) {
        return null;
    }

    @Override
    public Assignment getAssignmentWithUsers(Long assignmentId) {
        return null;
    }

    @Override
    public Assignment studentSaveAssignment(Long assignmentId) {
        return null;
    }

    @Override
    public Assignment teacherPostAssignment(Assignment assignment) {
        return null;
    }

    @Override
    public List<User> getUsersWithAssignmentId(Long assignmentId) {
        AssignmentEntity assignmentEntity = assignmentRepository.findById(assignmentId).get();
        List<UserEntity> userEntities = assignmentEntity.getUserEntities();

        List<User> users = userEntities
                .stream()
                .map(user -> new User(user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUserId(),
                        user.getEmail(),
                        user.getRole(),
                        user.getStatus(),
                        user.getPassword(),
                        user.getLoginQuestion1(),
                        user.getLoginQuestion2(),
                        user.getLoginQuestion3(),
                        user.getLoginAnswer1(),
                        user.getLoginAnswer2(),
                        user.getLoginAnswer3()))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<Assignment> getAllAssignments() {
        List<AssignmentEntity> assignmentEntities = assignmentRepository.findAll();
        List<Assignment> assignments = assignmentEntities
                .stream()
                .map(assignment -> new Assignment(assignment.getId(),
                        assignment.getPoint(),
                        assignment.getGrade(),
                        assignment.getTeacherId(),
                        assignment.getCourseId(),
                        assignment.getAssignmentName(),
                        assignment.getDue_date(),
                        assignment.getDescription(),
                        assignment.getAnswer()))
                .collect(Collectors.toList());
        return assignments;
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) {
        AssignmentEntity assignmentEntity = assignmentRepository.findById(id).get();
        BeanUtils.copyProperties(assignment,assignmentEntity);
        assignmentRepository.save(assignmentEntity);

        return assignment;
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        BeanUtils.copyProperties(assignment,assignmentEntity);
        assignmentRepository.save(assignmentEntity);

        return assignment;

    }
}
