package Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.google.protobuf.Timestamp;

import Model.Task; // Import the Task class
 public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setPriority(rs.getNString("priority"));
        task.setDueDate(rs.getNString("dueDate"));
                 

        // Handle other timestamps similarly
        java.sql.Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
        if (createdAtTimestamp != null) {
            task.setCreatedAt(createdAtTimestamp.toLocalDateTime());
        } else {
            task.setCreatedAt(null);
        }

        java.sql.Timestamp updatedAtTimestamp = rs.getTimestamp("updated_at");
        if (updatedAtTimestamp != null) {
            task.setUpdatedAt(updatedAtTimestamp.toLocalDateTime());
        } else {
            task.setUpdatedAt(null);
        }
        task.setCompleted(rs.getBoolean("completed"));
        java.sql.Timestamp completedAtTimestamp = rs.getTimestamp("completed_at");
        if (completedAtTimestamp != null) {
            task.setCompletedAt(completedAtTimestamp.toLocalDateTime());
        } else {
            task.setCompletedAt(null);
        }

        return task;
    }
}