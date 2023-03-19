package in.gogul.service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import in.gogul.dao.PerformanceDao;

@Service
public class PerformanceService {

	static SecureRandom random = new SecureRandom();
	PerformanceDao dao = new PerformanceDao();

	public boolean randomCodeGenerator(int param) throws Exception {

		int dbCount = dao.getDao();
		getRandom(param);

		int temp = dao.getDao();

		int totalCount = dbCount + param;
		if ((temp == totalCount)) {

		} else {
			int diff = totalCount - temp;

			randomCodeGenerator(diff);

		}
		return true;

	}

	private void getRandom(int param) throws Exception {
		List<String> randomList = new LinkedList<>();

		for (int ii = 0; ii < param; ii++) {
			String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(7);

			List<String> letters = Arrays.asList(randomAlphanumeric.split(""));
			Collections.shuffle(letters);
			String collect = letters.stream().map(String::valueOf).collect(Collectors.joining());
			StringBuilder sb = new StringBuilder();
			if (ii % 2 == 0) {

				sb.append(collect).reverse();
			} else {
				sb.append(collect);
			}

			randomList.add("('" + sb.toString() + "')");
		}

		dao.perfDao(randomList);
	}



}
