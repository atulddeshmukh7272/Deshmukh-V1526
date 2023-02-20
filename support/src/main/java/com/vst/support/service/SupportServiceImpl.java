package com.vst.support.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.support.converter.SupportConverter;
import com.vst.support.dto.SupportDto;
import com.vst.support.exception.IdNotAcceptableException;
import com.vst.support.exception.SupportException;
import com.vst.support.exception.SupportNotFoundException;
import com.vst.support.model.Support;
import com.vst.support.repository.SupportRepository;

@Service
public class SupportServiceImpl implements SupportServiceInterface {
	@Autowired
	SupportRepository supportRepository;
	@Autowired
	SupportConverter supportConverter;
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	@Transactional
	public SupportDto add(SupportDto supportDto) {
		supportDto.setSupportId(sequenceGeneratorService.idGenerator());
		supportDto.setActive(true);
		Support support = supportConverter.dtoToEntity(supportDto);
		supportRepository.save(support);
		return supportConverter.entityToDto(support);
	}

//for get support using supportId
	@Override
	public Support show(String supportId) {
		if (!supportId.isBlank()) {
			Support support = supportRepository.findBySupportIdAndIsActiveTrue(supportId);
			if (support != null) {
				return support;
			} else {
				throw new SupportException("Given Id Is Not Available");
			}
		} else {
			throw new IdNotAcceptableException("Please Enter Correct ID");
		}

	}

	@Override
	@Transactional
	public List<Support> showAll() {
		List<Support> list = supportRepository.findAllByAndIsActiveTrue();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new SupportNotFoundException("Data Is Not Available");
		}
	}

// for updating the support
	@Override
	@Transactional
	public void edit(String supportId, SupportDto supportDto) {
		
//		System.out.println(supportId);
		if (!supportId.isBlank()) {
			Support support = supportConverter.dtoToEntity(supportDto);
			Support obj = supportRepository.findBySupportIdAndIsActiveTrue(supportId);
			if (obj != null) {
				if (support.getSupportCustomerId() != null)
					if (!support.getSupportCustomerId().isBlank())
						obj.setSupportStationId(support.getSupportCustomerId());
				if (support.getSupportHostId() != null)
					if (!support.getSupportHostId().isBlank())
						obj.setSupportHostId(support.getSupportHostId());
				if (support.getSupportStationId() != null)
					if (!support.getSupportStationId().isBlank())
						obj.setSupportStationId(support.getSupportStationId());

				if (support.getSupportVendorId() != null)
					if (!support.getSupportVendorId().isBlank())
						obj.setSupportVendorId(support.getSupportVendorId());

				if (support.getSupportSubject() != null)
					if (!support.getSupportSubject().isBlank())
						obj.setSupportSubject(support.getSupportSubject());

				if (support.getSupportDescription() != null)
					if (!support.getSupportDescription().isBlank())
						obj.setSupportDescription(support.getSupportDescription());

				if (support.getSupportStatus() != null)
					if (!support.getSupportStatus().isBlank())
						obj.setSupportStatus(support.getSupportStatus());

				if (support.getSupportCreatedAt() != null)
					if (!support.getSupportCreatedAt().isBlank())
						obj.setSupportCreatedAt(support.getSupportCreatedAt());

				if (support.getSupportUpdatedAt() != null)
					if (!support.getSupportUpdatedAt().isBlank())
						obj.setSupportUpdatedAt(support.getSupportUpdatedAt());

				if (support.getSupportResolvedAt() != null)
					if (!support.getSupportResolvedAt().isBlank())
						obj.setSupportResolvedAt(support.getSupportResolvedAt());

				if (support.getSupportAssignedTo() != null)
					if (!support.getSupportAssignedTo().isBlank())
						obj.setSupportAssignedTo(support.getSupportAssignedTo());

				if (support.getSupportPriority() != null)
					if (!support.getSupportPriority().isBlank())
						obj.setSupportPriority(support.getSupportPriority());

				if (support.getSupportCategory() != null)
					if (!support.getSupportCategory().isBlank())
						obj.setSupportCategory(support.getSupportCategory());

				if (support.getCreatedDate() != null)
					if (!support.getCreatedDate().isBlank())
						obj.setCreatedDate(support.getCreatedDate());

				if (support.getModifiedDate() != null)
					if (!support.getModifiedDate().isBlank())
						obj.setModifiedDate(support.getModifiedDate());

				if (support.getCreatedBy() != null)
					if (!support.getCreatedBy().isBlank())
						obj.setCreatedBy(support.getCreatedBy());
				if (support.getModifiedBy() != null)
					if (!support.getModifiedBy().isBlank())
						obj.setModifiedBy(support.getModifiedBy());

				supportRepository.save(obj);

			} else {
				throw new SupportNotFoundException("Given Id Is Not Present");
			}
		}else {
			throw new IdNotAcceptableException("Please Enter Correct Id");
		}
	}

// for soft delete support using supportId
	@Override
	@Transactional
	public void remove(String supportId) {
		if (!supportId.trim().isEmpty()) {
			Support support = supportRepository.findBySupportIdAndIsActiveTrue(supportId);// soft delet
			if (support != null) {
				support.setActive(false);
				supportRepository.save(support);

			} else {
				throw new SupportNotFoundException("Support Is Not Found");
			}
		} else {
			throw new IdNotAcceptableException("Given Support Id Is Not Found");
		}

	}
}
