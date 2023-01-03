package com.ideas2it.collegemanagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ideas2it.collegemanagement.dto.CollegeDTO;
import com.ideas2it.collegemanagement.service.CollegeService;
import com.ideas2it.collegemanagement.util.DateUtil;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("college")
@RestController
public class CollegeController {

	private final CollegeService collegeService;

	@Autowired
	public CollegeController(CollegeService collegeService) {
		this.collegeService = collegeService;
	}

	@PostMapping("/")
	public CollegeDTO addCollege(@RequestBody CollegeDTO collegeDTO)throws CollegeManagementException{
		return collegeService.saveCollege(collegeDTO);
	}

	@GetMapping("/")
	public List<CollegeDTO> viewCollege() throws CollegeManagementException {
		return collegeService.getColleges();
	}

	@GetMapping("/{id}")
	public CollegeDTO viewCollege(@PathVariable("id") int id) throws CollegeManagementException {
		return collegeService.getCollege(id);
	}

	@DeleteMapping("/{id}")
	public CollegeDTO deleteCollege(@PathVariable int id) throws CollegeManagementException{
		return collegeService.deleteCollege(id);
	}

	@PutMapping("/{id}")
	public CollegeDTO updateCollege(@RequestBody CollegeDTO collegeDTO, @PathVariable("id") int id)
			throws CollegeManagementException {
		return collegeService.updateCollege(collegeDTO, id);
	}

	@GetMapping("/getDate/{startDate}/{endDate}")
	public List<CollegeDTO> findCollegeBetweenDate(@PathVariable("startDate") String startDate,
												   @PathVariable("endDate") String endDate) {
		try {
			return collegeService.findCollegeByDate(DateUtil.parseDate(startDate), DateUtil.parseDate(endDate));
		} catch (CollegeManagementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getCollegeByIds/{id}")
	public List<CollegeDTO> getCollege(@PathVariable("id") String id) {
		List<Integer> ids = new ArrayList<>();
		for (String a : Arrays.asList(id.split(","))) {
			ids.add(Integer.parseInt(a));
		}
		return collegeService.getCollegesByMultipleId(ids);
	}

}
