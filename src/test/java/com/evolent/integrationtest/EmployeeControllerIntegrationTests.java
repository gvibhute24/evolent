/**
 * 
 */
package com.evolent.integrationtest;
 

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.evolent.EvolentApplication;
import com.evolent.employee.payload.EmployeeRequest;
import com.evolent.employee.payload.EmployeeResponse;
/**
 * @author Gangadhar
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EvolentApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {

  @LocalServerPort
  private int port;
  
  @Autowired
  private TestRestTemplate restTemplate;
  
   
  
  @Test
  public void testaddEmployee() 
  {
    EmployeeRequest employeeRequest = new EmployeeRequest();
    employeeRequest.setEmail("ghb@gmail.com");
    employeeRequest.setFirstName("ghbnm");
    employeeRequest.setLastName("ghbnm");
    employeeRequest.setPhoneNumber("56893214");
    ResponseEntity<EmployeeResponse> responseEntity = this.restTemplate
        .postForEntity("http://localhost:" + port + "/api/employee/createmployee", employeeRequest, EmployeeResponse.class);
    assertEquals(responseEntity.getBody().getSuccess(),(true));
     
  }
  
  @Test
  public void testAllEmployees() 
  {
    List<EmployeeResponse> lsEmployee=this.restTemplate
    .getForObject("http://localhost:" + port + "/api/employee/allemployee", ArrayList.class);
    assertEquals(lsEmployee.size(),4);
     
  }
}
