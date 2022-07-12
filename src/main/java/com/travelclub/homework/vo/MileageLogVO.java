package com.travelclub.homework.vo;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class MileageLogVO {
	private String mileageId;
	
	private int point;

	private String userId;
	private String reviewId;

	private char type;
	private String comment;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime inserted;
	
	
	public MileageLogVO() {
		
	}
	public MileageLogVO(int point, String comment, char type, String userId, String reviewId) {
		this.mileageId = UUID.randomUUID().toString();
		this.point = point;
		this.comment = comment;
		this.type = type;
		this.userId = userId;
		this.reviewId = reviewId;
	}
}
