package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AsMapper {

	@Select("SELECT ascenter.*, a.s_name from ascenter "
			+ "INNER JOIN store AS a ON a.s_code = ascenter.s_code;")
	List<AsDTO> list();
	
	@Select("SELECT ascenter.*, a.s_name, b.p_name "
			+ "FROM ascenter "
			+ "INNER JOIN store AS a ON a.s_code = ascenter.s_code "
			+ "INNER JOIN product AS b ON b.p_code = ascenter.p_code "
			+ "WHERE ascenter.a_no = #{aNo}")
	AsDTO detail(int aNo);
	
	@Update("update ascenter set "
			+ "res_con = #{resCon}, as_price = #{asPrice}, as_res = #{asRes}, as_prog = #{asProg} "
			+ "where a_no = #{aNo}")
	int modify(AsDTO dto);
	
	
	//------매장
	@Insert("insert into ascenter (as_num, s_code, as_name, as_tel, p_code, as_note, pur_date) values "
			+ "(#{asNum},#{sCode},#{asName},#{asTel},#{pCode},#{asNote},#{purDate})")
	int storeInsert(AsDTO dto);
	
	@Update("update ascenter set "
			+ "as_name = #{asName}, as_tel = #{asTel}, p_code = #{pCode}, as_note = #{asNote}, pur_date = #{purDate} "
			+ "where a_no = #{aNo}")
	int storeModify(AsDTO dto);
	
	@Delete("delete from ascenter where a_no = #{aNo}")
	int delete(AsDTO dto);
	
}
