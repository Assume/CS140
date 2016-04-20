package assignment06;

import java.util.List;

public class CSAudit implements DegreeAudit {

	@Override
	public boolean hasWritingRequirement() {
		return true;
	}

	@Override
	public boolean hasWritingSatisfied(List<CourseOffering> list) {
		int total_c = 0;
		int total_j = 0;
		boolean cs_301 = false;
		for (CourseOffering x : list) {
			if (x.getName().equals("CS301"))
				cs_301 = true;
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
		}
		return cs_301 && (total_c >= 1 || total_j >= 1);
	}

}
