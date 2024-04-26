package com.green.university.utils;

public class Define {

	public final static String PRINCIPAL = "principal";

	public final static String CREATE_FAIL = "생성에 실패하였습니다.";

	public final static String UPDATE_FAIL = "수정에 실패하였습니다.";

	public final static String NOT_FOUND_ID = "아이디를 찾을 수 없습니다.";

	public final static String WRONG_PASSWORD = "비밀번호가 틀렸습니다.";

	// Integer로 했더니 ==로 비교하려면 .intValue()를 붙여줘야해서 int로 변경함
	public final static int CURRENT_YEAR = 2023;

	public final static int CURRENT_SEMESTER = 1;

	// 이미지 처리 관련
	// 1KB = 1024byte
	// 1MB = 1024*1024 = 1,048,476 byte
	public final static String UPLOAD_DIRECTORY = "C:\\spring_upload\\universityManagement\\upload";

	public final static int MAX_FILE_SIZE = 1024 * 1024 * 20;

	/**
	 * 로그인 해야 접속 가능한 페이지 목록
	 * 
	 * @author 김지현
	 */
	public final static String[] PATHS = { "/update", "/password", "/info/**", "/guide", "/notice/**"};
	public final static String[] PROFESSOR_PATHS = { "/professor/**" };
	public final static String[] STUDENT_PATHS = {"/grade/**"};
	public final static String[] STAFF_PATHS = { "/user/**" };

	// 수강 가능한 최대 학점
	public final static int MAX_GRADES = 18;

}
