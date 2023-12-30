package com.example.questionreponse.web.ControllerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.questionreponse.entity.Role;
import com.example.questionreponse.utils.Constants;


@RequestMapping(Constants.APP_ROOT)
public interface RoleCotrollerApi {

    @PostMapping(Constants.createRole)
    public ResponseEntity<?> create(@RequestBody Role role);
    

    @DeleteMapping(Constants.deleteRole)
    public ResponseEntity<?> deleteRole(@PathVariable Long id);
}
