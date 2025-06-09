package com.simple.app;

import org.apache.axis2.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.rmi.RemoteException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeWebAppApplicationTests {

	@Test
	public void contextLoads() {
		ServiceLocator serviceLocator = new ServiceLocator();
		try {
			com.example.SampleServiceStub stub = serviceLocator.getSampleServiceStub();
			com.example.SampleServiceStub.Process process = new com.example.SampleServiceStub.Process();
		} catch (AxisFault e) {
			throw new RuntimeException(e);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
