package demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldSayHelloToPerson() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello?name=Peter", String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is("Hello, Peter!"));
    }

    @Test
    public void shouldSayHelloToStranger() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is("Hello, Stranger!"));
    }
}
