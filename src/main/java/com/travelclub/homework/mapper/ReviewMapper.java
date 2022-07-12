package com.travelclub.homework.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.travelclub.homework.vo.ReviewRequestVO;

@Mapper
public interface ReviewMapper {
	// 첫번 째 댓글인지 확인
	boolean selectFirstReview(String placeId);
	// 리뷰 중복 체크하기
	boolean checkDuplication(ReviewRequestVO requestVO);
	
	// 리뷰 작성
	void insertReview(ReviewRequestVO reqeustVO);
	
	// 리뷰 수정 - action MOD로 변경
	void updateReview(ReviewRequestVO requestVO);
	
	// 리뷰 삭제 - review DELETE 바꾸기
	void deleteReview(ReviewRequestVO reviewVO);
}
