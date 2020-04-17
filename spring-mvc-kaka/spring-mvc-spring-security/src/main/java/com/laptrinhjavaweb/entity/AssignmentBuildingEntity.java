package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="assignmentbuilding")
public class AssignmentBuildingEntity extends BaseEntity {
	
	@Column(name="staffid")
	private String staffId;
	
	@Column(name="buildingid")
	private String buildingId;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
	
}
