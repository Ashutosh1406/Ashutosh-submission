package Model;

import java.time.LocalDateTime;

public class Task {
	private int id;
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
				+ ", dueDate=" + dueDate + ", completed=" + completed + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", completedAt=" + completedAt + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}
	
	private String title;
	private String description;
	private String priority;
	private String dueDate;
	
	private boolean completed;
	

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime completedAt;

}
