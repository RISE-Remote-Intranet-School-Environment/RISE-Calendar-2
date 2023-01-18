package com.ecam.calendar;

import com.ecam.calendar.model.mapLectureUserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class mapLectureUserTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void mapLectureUserTestGet() throws Exception {
        mockMvc.perform(get("/mapLectureUsers")).andExpect(status().isOk());
    }

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Test
    public void mapLectureUserTestPost() throws Exception {
        String url = "/mapLectureUsers";
        mapLectureUserModel mapLectureUser = new mapLectureUserModel() ;
        mapLectureUser.setFklecture(33L);
        mapLectureUser.setFkuser(36L);
        mapLectureUser.setIdMapLectureUser(4L);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(mapLectureUser);

        mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void mapLectureUserIdGet() throws Exception {
        mockMvc.perform(get("/getLecturesByUserId/{userid}", "1")).andExpect(status().isOk());
    }

    @Test
    public void mapLectureUserTestDelete() throws Exception {
        mockMvc.perform(delete("/mapLectureUsers/{mapLectureUserId}","1")).andExpect(status().isOk());
    }
}