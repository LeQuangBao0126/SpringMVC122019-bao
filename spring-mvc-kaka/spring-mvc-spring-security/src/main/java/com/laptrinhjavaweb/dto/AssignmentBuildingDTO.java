package com.laptrinhjavaweb.dto;


public class AssignmentBuildingDTO extends AbstractDTO<AssignmentBuildingDTO> {
	private Long staffId;
	private Long buildingId;
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	
}
