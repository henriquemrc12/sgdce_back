package com.nowsystems.sgdce.controllers;

import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.models.RoleModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.servicies.RoleService;
import com.nowsystems.sgdce.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RoleModel dto) {
        RoleModel r = roleService.create(dto);
        return ResponseEntity.ok(r);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<RoleModel> r = roleService.findAll();
        return ResponseEntity.ok(r);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        RoleModel r = roleService.findById(id);
        return ResponseEntity.ok(r);
    }
}


