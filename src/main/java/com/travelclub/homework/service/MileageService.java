package com.travelclub.homework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelclub.homework.mapper.MileageMapper;
import com.travelclub.homework.vo.MileageLogVO;
import com.travelclub.homework.vo.MileageResponseVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MileageService {
	private final MileageMapper mapper;
	private final MileageCalculatorService calculator;
	
	// 회원 마일리지 확인
	public MileageResponseVO selectMileageByUserId(String userId, int page) {
		// 총 마일리지 계산
		int sum = calculator.calculateSumPoint(userId);
		// 마일리지 이력사항 가져오기
		List<MileageLogVO> logs = mapper.findAll(userId, page);
		
		return new MileageResponseVO(sum, logs);
	}

}
