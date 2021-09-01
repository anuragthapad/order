package com.rvy.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvy.entity.DiscountMaster;
import com.rvy.repository.DiscountMasterRepository;

@Service
@Transactional
public class DiscountMasterServiceImpl implements DiscountMasterService {
	@Autowired
	private DiscountMasterRepository discountMasterRepository;
	@Override
	public Double findDiscount(Double orderAmount) {

		List<DiscountMaster> discountList =
				discountMasterRepository.findAll();
		Collections.sort(discountList, (dm1, dm2) ->
		dm1.getEligibilityCriteria()
		.compareTo(dm2.getEligibilityCriteria())
				);
		String discountCode = null;
		for (DiscountMaster discount : discountList) {
			if (Double.parseDouble(
					discount.getEligibilityCriteria()) <= orderAmount) {
				discountCode = discount.getDiscountCode();
			} else {
				break;
			}

		}
		return Double.parseDouble(
				discountCode.substring(
						discountCode.length() - 2, discountCode.length()
						));
		//return null;
	}
}
