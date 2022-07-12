package com.travelclub.homework.vo;

import java.util.List;

import lombok.Data;

@Data
public class ReviewRequestVO {
	private String reviewId;
	
	private String content;
	private String type;
	private String action;
	private List<String> attachedPhotoIds;
	
	private String userId; // 유저 아이디
	
	private String placeId; // 장소 아이디
	
	// point table
	private String pointId;
	private int point;
	private String comment;
}
