package yurp.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface BrandOrderMapper {
	
	@Select("select * from orders")
	List<BrandOrderDTO> list();
	
	@Select("select * from orders")
	List<BrandOrderDTO> detail();
	
	@Select("select * from brand")
	List<BrandDTO> blist();
	
	@Select("select * from brand where b_name = #{bName}")
	BrandDTO bdetail(String bName);
	
	@Insert("insert into brand (b_name,b_code,addr,tel,email) values "
			+ "(#{bName},#{bCode},#{addr},#{tel},#{email})")
	int insert(BrandDTO dto);
	
	@Update("update brand set b_code = #{bCode}, b_name = #{bName}, "
			+ "addr = #{addr}, tel = #{tel}, "
			+ "email = #{email} where b_no = #{bNo}")
	int modify(BrandDTO dto);
	
	@Delete("delete from brand where b_no = #{bNo}")
	int delete(BrandDTO dto);
}




