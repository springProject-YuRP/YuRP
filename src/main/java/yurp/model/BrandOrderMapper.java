package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
	
}
