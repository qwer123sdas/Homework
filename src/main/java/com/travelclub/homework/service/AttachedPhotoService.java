package com.travelclub.homework.service;

import org.springframework.stereotype.Service;

import com.travelclub.homework.mapper.AttachedPhotoMapper;
import com.travelclub.homework.vo.ReviewRequestVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttachedPhotoService {
	private final MileageCalculatorService calculator;
	private final AttachedPhotoMapper attachedPhotoMapper;
	
	// 사진 유효성 + 포인트
	//ADD
	public boolean isSatisFiedAddPhoto(ReviewRequestVO request) {
		if(request.getAttachedPhotoIds().isEmpty()) {
			return false;
		}
		// 리뷰 첫 작성일 때,
		if(request.getAction().equals("ADD")) {
			
			//사진이 있음
			calculator.addPhotoPoint(request);
			return true;
		}
		return false;
	}
	
	//MOD
	public boolean isSatisfiedModPhoto(ReviewRequestVO request) {
		
		// 기존에 사진이 없을 때,
		if(attachedPhotoMapper.selectOriginReviewAttachedPhotoCount(request.getReviewId()) == 0) {
			// 그런데 수정된 리뷰에는 사진이 있으므로
			if(!request.getAttachedPhotoIds().isEmpty() || request.getAttachedPhotoIds().size() != 0) {
				// 새로운 사진들 추가
				insertAttachedPhoto(request);
				// 1점 추가
				calculator.addPhotoPoint(request);
				return true;
			}
			// 0포인트
			return false; 
		}
		
		// 기존에 사진이 있을 때, 
		// 수정 리뷰에 사진이 비어있는지 확인 : []이거나 null일 때
		if(request.getAttachedPhotoIds().isEmpty() || request.getAttachedPhotoIds().size() == 0) {
			// 사진이 비어있다면, 사진을 삭제하여 갯수가 0이므로
			// 기존 사진 삭제
			deleteAttachedPhotoByReviewId(request.getReviewId());
			// -1점
			calculator.deletePhotoPoint(request);
			return false;
		}else {
			// 삭제해도 1장 이상 있으므로 없는 것만 삭제
			// 기존 사진 삭제
			deleteAttachedPhotoByReviewId(request.getReviewId());
			// 새로운 사진들 추가
			insertAttachedPhoto(request);
			// 0포인트
		}
		
		return false;
		
	}
	
	// MOD & DELETE - 리뷰 그림 수정 & 삭제시, 기존 사진 전체삭제
	public void deleteAttachedPhotoByReviewId(String reviewId) {
		attachedPhotoMapper.deleteAttachedPhotoByReviewId(reviewId);
	}
	
	// 사진 db저장 메소드
	public void insertAttachedPhoto(ReviewRequestVO request) {
		for(int i = 0; i < request.getAttachedPhotoIds().size(); i++) {
			attachedPhotoMapper.insertReviewAttechedPhoto(request.getAttachedPhotoIds().get(i), request.getReviewId());
		}
	}
}
