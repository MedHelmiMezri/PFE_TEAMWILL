package com.bezkoder.springjwt.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "gantt_tasks")
public class Ganttasks {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "text", nullable = false)
  private String text;

  @Column(name = "start_date", nullable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime start_date;

  @Column(name = "duration", nullable = false)
  private Integer duration;

  @Column(name = "progress", nullable = false)
  private Float progress;

  @Column(name = "parent", nullable = false)
  private Integer parent;

  
  public Ganttasks() {}
  
  // getters and setters
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public LocalDateTime getStart_date() {
	return start_date;
}

public void setStart_date(String string) {
	this.start_date = start_date;
}

public Integer getDuration() {
	return duration;
}

public void setDuration(Integer duration) {
	this.duration = duration;
}

public Float getProgress() {
	return progress;
}

public void setProgress(Float progress) {
	this.progress = progress;
}

public Integer getParent() {
	return parent;
}

public void setParent(Integer parent) {
	this.parent = parent;
}
}
