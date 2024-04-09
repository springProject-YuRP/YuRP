package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AsMapper {

	@Select("select * from ascenter")
	List<AsDTO> list();
	
	@Select("select * from ascenter where a_no = #{aNo}")
	AsDTO detail(int aNo);
	
	@Update("update ascenter set "
			+ "res_con = #{resCon}, as_price = #{asPrice}, as_res = #{asRes}, as_prog = #{asProg} "
			+ "where a_no = #{aNo}")
	int modify(AsDTO dto);
	
	
	//------매장
	@Insert("insert into ascenter (as_num, b_code, as_name, as_tel, p_code, as_note, pur_date) values "
			+ "(#{asNum},#{bCode},#{asName},#{asTel},#{pCode},#{asNote},#{purDate})")
	int storeInsert(AsDTO dto);
	
	@Update("update ascenter set "
			+ "as_name = #{asName}, as_tel = #{asTel}, p_code = #{pCode}, as_note = #{asNote}, pur_date = #{purDate} "
			+ "where a_no = #{aNo}")
	int storeModify(AsDTO dto);
	
	@Delete("delete from ascenter where a_no = #{aNo}")
	int delete(AsDTO dto);
	
}
