package com.nowsystems.sgdce.controllers;


import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.models.RoleModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.models.logErrorsModel;
import com.nowsystems.sgdce.servicies.LogErrorsService;
import com.nowsystems.sgdce.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserModelDTO dto) {
        UserModel r = userService.create(dto);
        return ResponseEntity.ok(r);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UserModelDTO dto) {
        UserModel r = userService.create(dto);
        return ResponseEntity.ok(r);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<UserModel> r = userService.findAll();
        return ResponseEntity.ok(r);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        UserModel r = userService.findById(id);
        return ResponseEntity.ok(r);
    }

    @PatchMapping(value = "/active/{id}")
    public ResponseEntity<?> active(@PathVariable Long id) {
        Boolean r = userService.turnActive(id);
        return ResponseEntity.ok(r);
    }
}
