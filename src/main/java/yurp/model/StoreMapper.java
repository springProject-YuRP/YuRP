package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;





@Mapper
public interface StoreMapper {

	@Select(
			"<script>"
			+ "select * from store "
			+ "<where> "
			+ "<trim prefix=' ' suffixOverrides = 'and | or'>"
			+ "<if test='sName != null and sName != \"\"'> "
			+ "s_name like concat('%',#{sName},'%') or "
			+ "</if>"
			+ "<if test='addr != null and addr != \"\"'> "
			+ "addr like concat('%',#{addr},'%') or "
			+ "</if>"
			+ "</trim>"			
			+ "</where>"
			+ "</script>")
	List<StoreDTO> list(StoreDTO dto);
	
	@Select("select * from store where s_no = #{sNo}")
	StoreDTO detail(int sNo);
	
	@Insert("insert into store(s_code, s_pw, s_name, grade, addr, tel, email, manager, auth)values\r\n"
			+ "(#{sCode},#{sPw},#{sName},#{grade},#{addr},#{tel},#{email},#{manager},#{auth})")
	int insert(StoreDTO dto);
	
	@Delete("delete from store where s_no = #{sNo}")
	int delete(int sNo);
	
	@Update("update store set "
			+ "s_pw=#{sPw}, s_name=#{sName}, grade=#{grade}, addr=#{addr}, tel=#{tel}, email=#{email}, manager=#{manager}, auth=#{auth} "
			+ "where s_no = #{sNo}")
	int modify(StoreDTO dto);
	
	
}
