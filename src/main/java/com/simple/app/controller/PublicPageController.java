package com.simple.app.controller;

import com.simple.app.ServiceLocator;
import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.RemoteException;

@Controller
public class PublicPageController {
    @RequestMapping(value = {"","/", "/index"})
    public String index() {
        ServiceLocator serviceLocator = new ServiceLocator();
        try {
            com.example.SampleServiceStub stub = serviceLocator.getSampleServiceStub();
            com.example.SampleServiceStub.Process process = new com.example.SampleServiceStub.Process();

            stub.process(process);
        } catch (AxisFault e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        return "/index";
    }
}
