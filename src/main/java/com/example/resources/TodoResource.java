package com.example.resources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.example.schemas.Todo;
import com.example.util.DatabaseConnection;

@Path("/todo")
public class TodoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodos() {
        Status status = Status.OK;
        JSONObject response = new JSONObject();

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM todos;")) {

            List<Todo> entries = new ArrayList<>();

            while (resultSet.next()) {
                Todo todo = new Todo(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("description"), resultSet.getBoolean("is_done"));
                entries.add(todo);
            }

            response.put("data", entries);
        } catch (SQLException e) {
            status = Status.INTERNAL_SERVER_ERROR;
            response.put("error", "An error occurred while fetching todos.");
            e.printStackTrace();
        }

        return Response.status(status).entity(response.toString()).build();
    }
}
