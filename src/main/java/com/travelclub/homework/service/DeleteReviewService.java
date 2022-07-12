package com.travelclub.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelclub.homework.mapper.ReviewMapper;
import com.travelclub.homework.vo.ReviewRequestVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor 
public class DeleteReviewService {
	private final AttachedPhotoService attachedPhotoService;
	private final MileageCalculatorService calcurator;
	private final ReviewMapper reviewMapper;
	@Transactional
	public void deleteReview(ReviewRequestVO request) {
		// 사진 삭제
		attachedPhotoService.deleteAttachedPhotoByReviewId(request.getReviewId());
		// review DELETE로 업데이트
		reviewMapper.deleteReview(request);
		//포인트 전부 -1
		calcurator.deleteReviewPoint(request);
	}


}
