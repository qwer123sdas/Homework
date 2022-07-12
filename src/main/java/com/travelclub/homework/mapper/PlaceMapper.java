package com.travelclub.homework.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.travelclub.homework.vo.ReviewRequestVO;

@Mapper
public interface PlaceMapper {
	// 장소 글이 있는지 확인
	boolean checkPlaceId(ReviewRequestVO requestVO);
}
