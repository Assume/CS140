package assignment06;

import java.util.List;

public interface DegreeAudit {

	default boolean hasWritingRequirement() {
		return false;
	}

	default boolean hasWritingSatisfied(List<CourseOffering> list) {
		throw new UnsupportedOperationException();
	}

}
