package com.vst.support.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "support")
public class Support {

	@Id
	private String supportId;

	private String supportCustomerId;
	private String supportHostId;
	private String supportStationId;
	private String supportVendorId;
	private String supportSubject;
	private String supportDescription;
	private String supportStatus;
	private String supportCreatedAt;
	private String supportUpdatedAt;
	private String supportResolvedAt;
	private String supportAssignedTo;
	private String supportPriority;
	private String supportCategory;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	boolean isActive = true;

}
