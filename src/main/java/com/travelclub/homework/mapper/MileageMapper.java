package com.travelclub.homework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.travelclub.homework.vo.MileageLogVO;

@Mapper
public interface MileageMapper {
	// 각 유저의 마일리지 총합계산
	int selectSumMileageByUserId(String userId);
	
	// 리뷰 포인트 적립 & 수정 & 삭제
	void insertReviewPoint(MileageLogVO mileage);
	
	// 회원로그 기록 가져오기(List)
	List<MileageLogVO> findAll(@Param("userId")String userId, @Param("page")int page);
}
