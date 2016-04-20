package assignment06;

import java.util.List;

public class HarpurAudit implements DegreeAudit {
	@Override
	public boolean hasWritingRequirement() {
		return true;
	}

	@Override
	public boolean hasWritingSatisfied(List<CourseOffering> list) {
		int total_c = 0;
		int total_w = 0;
		for (CourseOffering x : list)
			for (String y : x.getAnnotations())
				switch (y.toLowerCase()) {
				case "c":
					total_c++;
					continue;
				case "w":
					total_w++;
				default:
					continue;
				}
		return (total_c >= 2 && total_w >= 3) || (total_c >= 3 && total_w >= 1) || total_c >= 4;
	}

}
