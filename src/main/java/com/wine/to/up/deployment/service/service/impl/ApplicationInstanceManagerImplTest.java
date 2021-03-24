package com.wine.to.up.deployment.service.service.impl;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Service;
import com.github.dockerjava.api.model.ServiceModeConfig;
import com.github.dockerjava.api.model.ServiceReplicatedModeOptions;
import com.github.dockerjava.api.model.ServiceSpec;
import com.wine.to.up.deployment.service.enums.ApplicationInstanceStatus;
import com.wine.to.up.deployment.service.service.DockerClientFactory;
import com.wine.to.up.deployment.service.vo.ApplicationInstanceVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.ServiceUnavailableException;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationInstanceManagerImplTest {

    ApplicationInstanceVO template;

    @Mock
    DockerClientFactory dockerClientFactory;

    @InjectMocks
    ApplicationInstanceManagerImpl applicationInstanceManager;

    @Test
    void startApplication() {
        ApplicationInstanceVO template = ApplicationInstanceVO.builder()
                .appId("testAppId")
                .createdBy("tester")
                .id(1L)
                .alias("testApp")
                .dateCreated(1L)
                .templateId(1L)
                .version("testAppVersion")
                .status(ApplicationInstanceStatus.STARTING)
                .build();

        Assert.assertNotNull(template);
        Assert.assertNotNull(template.getAppId());
        Assert.assertEquals(template.getAppId(), "testAppId");
        Assert.assertEquals(template.getStatus(), ApplicationInstanceStatus.STARTING);
    }

    @Test
    void stopApplication() {
        ApplicationInstanceVO template = ApplicationInstanceVO.builder()
                .appId("test")
                .createdBy("Tester")
                .id(1L)
                .alias("test")
                .dateCreated(1L)
                .templateId(1L)
                .version("test")
                .status(ApplicationInstanceStatus.STOPPED)
                .build();

        Assert.assertEquals(template.getStatus(), ApplicationInstanceStatus.STOPPED);
    }

}