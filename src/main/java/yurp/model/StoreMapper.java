package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface StoreMapper {

	@Select(
			"<script>"
			+ "select * from store "
			+ "<where> "
			+ "<if test='sName != null and sName != \"\"'> "
			+ "s_name like concat('%',#{sName},'%') "
			+ "</if>"
			+ "</where>"
			+ "</script>")
	List<StoreDTO> list(StoreDTO dto);
	
	@Insert("insert into store(s_code, s_pw, s_name, grade, addr, tel, email, manager, auth)values\r\n"
			+ "(#{sCode},#{sPw},#{sName},#{grade},#{addr},#{tel},#{email},#{manager},#{auth})")
	int insert(StoreDTO dto);
	
	@Delete("delete from store where no = #{no}")
	int delete(int no);
}
