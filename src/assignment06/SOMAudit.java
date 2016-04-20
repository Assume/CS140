package assignment06;

import java.util.List;

public class SOMAudit implements DegreeAudit {

	@Override
	public boolean hasWritingRequirement() {
		return true;
	}

	@Override
	public boolean hasWritingSatisfied(List<CourseOffering> list) {
		int total_c = 0;
		int total_j = 0;
		for (CourseOffering x : list)

			for (String y : x.getAnnotations())
				switch (y.toLowerCase()) {
				case "c":
					total_c++;
					continue;
				case "j":
					total_j++;
				default:
					continue;
				}
		return total_c + total_j >= 2;
	}

}
