package com.travelclub.homework.vo;

import java.util.List;

import lombok.Data;

@Data
public class MileageResponseVO {
	private int sum;
	private List<MileageLogVO> logs;
	
	public MileageResponseVO(int sum, List<MileageLogVO> logs) {
		this.sum = sum;
		this.logs = logs;
	}
}
