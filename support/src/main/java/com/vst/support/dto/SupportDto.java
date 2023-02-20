package com.vst.support.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportDto {
	
	@Transient
	public static final String SEQUENCE_NAME = "support"; //for generating the id
	
	@Id
	private String supportId;
	@NotNull
	@NotBlank
	private String supportCustomerId;
	@NotNull
	@NotBlank
	private String supportHostId;
	@NotNull
	@NotBlank
	private String supportStationId;
	@NotNull
	@NotBlank
	private String supportVendorId;
	@NotNull
	@NotBlank
	private String supportSubject;
	@NotNull
	@NotBlank
	private String supportDescription;
	@NotNull
	@NotBlank
	private String supportStatus;
	@NotNull
	@NotBlank
	private String supportCreatedAt;
	@NotNull
	@NotBlank
	private String supportUpdatedAt;
	@NotNull
	@NotBlank
	private String supportResolvedAt;
	@NotNull
	@NotBlank
	private String supportAssignedTo;
	@NotNull
	@NotBlank
	private String supportPriority;
	@NotNull
	@NotBlank
	private String supportCategory;
	@NotNull
	@NotBlank
	private String createdDate;
	@NotNull
	@NotBlank
	private String modifiedDate;
	@NotNull
	@NotBlank
	private String createdBy;
	@NotNull
	@NotBlank
	private String modifiedBy;
	boolean isActive=true;

}
