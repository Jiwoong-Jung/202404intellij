package com.example.springedu.repository;

import com.example.springedu.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//메서드만 만들어 주면 쿼리는 스프링이 만들어 줍니다.
public interface EmpRepository2 extends JpaRepository<Emp, Integer>{
	//규칙에 맞게 정보를 추출하면 됩니다.
	public List<Emp> findByEname(String name); //Ename으로 추출

	public List<Emp> findByEnameIgnoreCase(String name);
	public List<Emp> findByJob(String job);

	//Job 또는 Deptno
	public List<Emp> findByJobOrDeptno(String job, int dno);
	public List<Emp> findByJobAndDeptno(String job, int dno);
	public List<Emp> findDistinctByJob(String job);
	public List<Emp> findByDeptno(int dno);
	public List<Emp> findBySalGreaterThan(int inputsal);
	public List<Emp> findBySalGreaterThanEqual(int inputsal);
	public List<Emp> findBySalLessThan(int inputsal);
	public List<Emp> findBySalLessThanEqual(int inputsal);
	public List<Emp> findBySalBetween(int minsal, int maxsal);
	public List<Emp> findByCommNull();
	public List<Emp> findByCommNotNull();
	public List<Emp> findByHiredateAfter(java.sql.Date d);
	public List<Emp> findByHiredateBefore(java.sql.Date d);
	public List<Emp> findByEnameStartsWith(String partname);

	//like연산
	public List<Emp> findByEnameContains(String partname);
	public List<Emp> findByDeptnoOrderBySalDesc(int dno);

	//같은 부서 중 급여 내림차순 정렬 후 상위 3위만 검색
	public List<Emp> findTop3ByDeptnoOrderBySalDesc(int dno);
}
