package com.travelclub.homework.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttachedPhotoMapper {
	// 리뷰 작성 - 사진 추가
	void insertReviewAttechedPhoto(@Param("attachedPhoto")String attachedPhoto, @Param("reviewId")String reviewId);
		
	// 리뷰 수정 - 사진 있는지 확인
	int selectOriginReviewAttachedPhotoCount(String reviewId);
		
	// 리뷰 수정/삭제 - 해당 reviewId의 기존 사진 모두 삭제
	void deleteAttachedPhotoByReviewId(String reviewId);
}
