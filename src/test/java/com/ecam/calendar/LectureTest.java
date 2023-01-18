package com.ecam.calendar;

import com.ecam.calendar.model.Lecture;
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
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LectureTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void LectureTestGet() throws Exception {
        mockMvc.perform(get("/lectures")).andExpect(status().isOk());
    }

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Test
    public void LectureTestPost() throws Exception {
        LocalTime start = LocalTime.now();
        LocalTime end = LocalTime.now().plusHours(2);
        LocalDate week = LocalDate.now();
        String url = "/lectures";
        Lecture lecture = new Lecture() ;
        lecture.setLectureId(33);
        lecture.setCode("1234");
        lecture.setRoom("4321");
        lecture.setStartTime(Time.valueOf(start));
        lecture.setEndTime(Time.valueOf(end));
        lecture.setSessionNumber(10);
        lecture.setTeachers("ABC");
        lecture.setWeekDay(Date.valueOf(week));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(lecture);

        mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void LectureIdGet() throws Exception {
        mockMvc.perform(get("/lecture/{lectureId}", "1")).andExpect(status().isOk());
    }

    @Test
    public void LectureTestDelete() throws Exception {
        mockMvc.perform(delete("/lectures/{lectureId}","1")).andExpect(status().isOk());
    }
}