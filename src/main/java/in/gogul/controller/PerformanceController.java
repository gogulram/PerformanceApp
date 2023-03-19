package in.gogul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.gogul.service.PerformanceService;

@RestController
public class PerformanceController {

	@Autowired
	PerformanceService performanceService;

	@PostMapping("/random")
	public Long randomNumber(@RequestParam("parameter") Integer param) throws Exception {
		long before = System.currentTimeMillis();

		performanceService.randomCodeGenerator(param);
		long after = System.currentTimeMillis();

		return after - before;

	}

}
