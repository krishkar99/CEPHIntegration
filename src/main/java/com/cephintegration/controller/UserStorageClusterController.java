package com.cephintegration.controller;

import com.ceph_integration.api.UserApi;
import com.ceph_integration.model.TemporaryCredential;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStorageClusterController implements UserApi {
    @Override
    public ResponseEntity<TemporaryCredential> createTemporaryCredentials() {
        return UserApi.super.createTemporaryCredentials();
    }
}
