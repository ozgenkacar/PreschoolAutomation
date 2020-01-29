package com.cybertektraining.api;

import com.cybertektraining.pojos.Student;
import com.cybertektraining.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StudentAPI {

    public static int deleteStudent(int id){
baseURI = ConfigurationReader.getProperty("uri");
        Response response =when().delete("student/delete/{id}",id);
        return response.getStatusCode();
    }

    public static Response addStudent(Student student){
        baseURI = ConfigurationReader.getProperty("uri");
       Response response = given().
                        contentType(ContentType.JSON).
                        body(student).
                        when().
                        post("student/create");

    return  response;

    }
    public static Response addStudent(String json){
        baseURI = ConfigurationReader.getProperty("uri");
        Response response = given().
                contentType(ContentType.JSON).
                body(json).
                when().
                post("student/create");

        return  response;

}









}
