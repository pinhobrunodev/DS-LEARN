package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.entities.enums.DeliverStatus;


// OBJ que  professor vai enviar para retorno de uma tarefa
public class DeliverRevisionDTO {

	private DeliverStatus status;
	private String feedback;
	private Integer correctCount;
	
	public DeliverRevisionDTO() {
		
	}

	public DeliverRevisionDTO(DeliverStatus status, String feedback, Integer correctCount) {
		super();
		this.status = status;
		this.feedback = feedback;
		this.correctCount = correctCount;
	}
	
	
	public DeliverRevisionDTO(Deliver entity) {
		status = entity.getStatus();
		feedback = entity.getFeedback();
		correctCount = entity.getCorrectCount();
	}

	public DeliverStatus getStatus() {
		return status;
	}

	public void setStatus(DeliverStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}
	
	
	
}
