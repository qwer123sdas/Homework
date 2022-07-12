package com.travelclub.homework.controller;

import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelclub.homework.service.AddReviewService;
import com.travelclub.homework.service.DeleteReviewService;
import com.travelclub.homework.service.ModReviewService;
import com.travelclub.homework.vo.ReviewRequestVO;

import lombok.RequiredArgsConstructor;

import static com.travelclub.homework.infrastructure.Constants.ADD;
import static com.travelclub.homework.infrastructure.Constants.MOD;
import static com.travelclub.homework.infrastructure.Constants.DELETE;

@RestController
@RequiredArgsConstructor 
public class ReviewController {
	private final AddReviewService addService;
	private final ModReviewService modService;
	private final DeleteReviewService deleteService;
	
	// 리뷰 쓰기
	@PostMapping(path="events", produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> insertReview(@RequestBody ReviewRequestVO request) {  // Valid 
		try {
			if(request.getAction().equals(ADD)) {
				addService.insertReview(request);
				return ResponseEntity.ok("add review!");
			}else if(request.getAction().equals(MOD) ) {
				modService.modReview(request);
				return ResponseEntity.ok("modified review!");
			}else if(request.getAction().equals(DELETE)){
				deleteService.deleteReview(request);
				return ResponseEntity.ok("delete review!");
			}
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	
	@PostMapping("test")
	@ResponseBody
	public String test(@RequestBody Map<String, String> map) {
		System.out.println(map);
		return "test ok";
	}
}
