package com.cephintegration.controller;

import com.ceph_integration.api.AdminApi;
import com.ceph_integration.model.StorageCluster;
import com.ceph_integration.model.StorageClusterSpec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageClusterController implements AdminApi {

    @Override
    public ResponseEntity<StorageCluster> createStorageCluster(StorageClusterSpec storageClusterSpec) {
        return AdminApi.super.createStorageCluster(storageClusterSpec);
    }
}
