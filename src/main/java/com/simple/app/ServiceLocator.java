package com.simple.app;

import org.apache.axis2.AxisFault;

public class ServiceLocator {
    public com.example.SampleServiceStub getSampleServiceStub() throws AxisFault {

        com.example.SampleServiceStub stub = new com.example.SampleServiceStub("http://localhost:8080");

        return stub;
    }
}
