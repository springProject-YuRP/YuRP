package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface AsMapper {

	@Select("SELECT ascenter.*, a.s_name as sName from ascenter "
			+ "INNER JOIN store AS a ON a.s_code = ascenter.s_code")
	List<AsDTO> list(AsDTO dto);
	
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
	
	
	//------검색
	//전체 매장명
	@Select("SELECT s_name FROM store")
	List<AsDTO> sNames();
	
	
	@Select({
		" <script> "
		," SELECT ascenter.*, a.s_name as sName from ascenter "
		, "INNER JOIN store AS a ON a.s_code = ascenter.s_code"
		, " <where> "
		, " 	<choose> "
		, " 		<when test='start != null'> "
		, " 			AND reg_date = #{start} "
		, " 		</when> "
		, " 		<when test='end != null'> "
		, " 			AND reg_date = #{end} "
		, " 		</when> "
		, " 		<when test='sName != null'> "
		, " 			AND a.s_name = #{sName} "
		, " 		</when> "
		, " 		<when test='sName != null'> "
		, " 			AND a.s_name = #{sName} "
		, " 		</when> "
		, " 		<when test='asRes != null'> "
		, " 			AND as_res = #{asRes} "
		, " 		</when> "
		, " 		<when test='asProg != null'> "
		, " 			AND as_prog = #{asProg} "
		, " 		</when> "
		, " 		<when test='asTel != null'> "
		, " 			AND as_tel like #{asTel} "
		, " 		</when> "
		, " 		<when test='asNum != null'> "
		, " 			AND as_num like #{asNum} "
		, " 		</when> "
		, " 	</choose> "
		, " </where> "
		, " </script> "})
	List<AsDTO> listPname(AsDTO dto);
}
