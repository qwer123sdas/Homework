package com.travelclub.homework.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.travelclub.homework.vo.ReviewRequestVO;

@Mapper
public interface UserMapper {
	// 유저 존재하는지 확인
	boolean checkUserId(ReviewRequestVO requestVO);
}
