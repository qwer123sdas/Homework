package com.travelclub.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelclub.homework.mapper.ReviewMapper;
import com.travelclub.homework.validator.ReviewValidator;
import com.travelclub.homework.vo.ReviewRequestVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModReviewService {
	private final ReviewValidator validator;
	private final AttachedPhotoService attachedPhotoApp;
	private final ReviewMapper reviewMapper;
	

	@Transactional
	public void modReview(ReviewRequestVO request) {
		// validator검사
		validator.validate(request);
		// content는 당연히 있으니까 패스
		
		// 사진여부
		attachedPhotoApp.isSatisfiedModPhoto(request);
			
		// content 및 action 저장
		reviewMapper.updateReview(request);
	}

}
