package com.travelclub.homework.vo;

import java.util.List;

import lombok.Data;

@Data
public class ReviewVO {
	private String reviewId;
	
	private String content;
	private String type;
	private String action;
	private List<String> attachedPhotoIds;
	
	private String userId; 
	private String placeId;
	
	private String message;
}
