/* (C)2025 */
package com.core.acme.utils;

public class Constants {
    public static final String UTILITY_CLASS_ERROR_MESSAGE = "Utility class";

    private Constants() {
        throw new IllegalStateException(UTILITY_CLASS_ERROR_MESSAGE);
    }

    public static class IdPrefix {
        private IdPrefix() {
            throw new IllegalStateException(UTILITY_CLASS_ERROR_MESSAGE);
        }

        public static final String QUESTION_ID_PREFIX = "QUES";
        public static final String EXAM_ID_PREFIX = "EXM";
        public static final String STUDENT_PREFIX = "STU";
        public static final String TEST_ID_PREFIX = "TEST";
    }
}
