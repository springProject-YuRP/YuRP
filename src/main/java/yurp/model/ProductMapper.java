package yurp.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

	@Select(
			"<script>"
			+ "select p.*, b.b_name "
			+ "from product as p join brand as b on p.b_code = b.b_code "
			+ "<where> "
			+ "<trim prefix=' ' suffixOverrides = 'and | or'>"
			+ "<if test='season != null'> "
			+ "season=#{season} and"
			+ "</if>"
			+ "<if test='bCode != null'> "
			+ "p.b_code=#{bCode} and"
			+ "</if>"
			+ "<if test='pName != null and pName != \"\"'> "
			+ "p_name like concat('%',#{pName},'%') and"
			+ "</if>"
			+ "<if test='pCode != null and pCode != \"\"'> "
			+ "p_code like concat('%',#{pCode},'%') "
			+ "</if>"

			+ "</trim>"

			+ "</where>"
			+ "</script>")
	List<ProductDTO> list(ProductDTO dto);
	
//	@Select("select p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, li_price, i.cnt, i.i_no  "
//			+ "from product p "
//			+ "join inventory i "
//			+ "where i.p_code = p.p_code and i.s_code  = 'admin' and p.b_code  = '117901'")
	@Select("<script>"
			+ "select "
			+"p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, li_price, i.cnt, i.i_no  "
			+ "from product p "
			+ "join inventory i "
			+ "<where>"
			+ " i.p_code = p.p_code and i.s_code  = 'admin' and p.b_code = #{bCode} "
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			+ 	"<if test='pNumChk != null and pNumChk != \"\"'> "
			+ 	"and p.p_num like concat('%',#{pNumChk},'%') "
			+ 	"</if>"
			+ "	</trim>"
			+ "</where> "
			+ "</script> "
			 )
	List<ProductDTO> prodList(ProductDTO dto);
	
	@Select("select * from brand")
	List<BrandDTO> brandList();
	
	@Select("select season from product "
			+ "group by season "
			+ "order by season desc")
	List<String> seasonList();
	
	
	@Insert({
		" <script> "
		,"insert into product "
		, "(b_code, season, grade, p_name, p_num, color, p_size, p_code, li_price, discount, p_price) values "
		, "<foreach collection='arr' item='prod' separator=',' index='i'>"
		, "<if test='prod.bCode != null'>"
		, "(#{prod.bCode}, #{prod.season}, #{prod.grade}, "
		, "#{prod.pName}, #{prod.pNum}, #{prod.color}, #{prod.pSize}, #{prod.pCode}, "
		, "#{prod.liPrice}, #{prod.discount}, #{prod.pPrice})"
		, "</if>"
		, "</foreach>"
		, "</script> "})
	int insert(ArrayList<ProductDTO> arr);
	
	
	@Select({
		"<script>"
		, "<foreach collection='arr' item='prod' separator=';' index='i'>"
			, "select p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, i.cnt, i.i_no, li_price "
			, "from product p "
			, "join inventory i "
			, "where i.i_no = #{prod.iNo}"
		, "</foreach>"
		,"</script>"})
	ArrayList<ProductDTO> excelArr(ArrayList<ProductDTO> arr);

	@Delete({
		" <script> "
		,"delete from product "
		, "<where> "
		, "p_no in ("
		, "<foreach collection='arr' item='prod' separator=',' index='i'> "
		, "<if test='prod.pNo != null'> "
		, "#{prod.pNo} "
		, "</if> "
		, "</foreach> "
		, ")"
		, "</where> "
		, "</script> "
	})
	int delete(ArrayList<ProductDTO> arr);
	
	@Select({
		" <script> "
		,"select * from product "
		, "<where> "
		, "p_no in ("
		, "<foreach collection='arr' item='prod' separator=',' index='i'> "
		, "<if test='prod.pNo != null'> "
		, "#{prod.pNo} "
		, "</if> "
		, "</foreach> "
		, ")"
		, "</where> "
		, "</script> "
	})
	List<ProductDTO> modList(ArrayList<ProductDTO> arr);
	

	@Update({
		" <script> "
		, "<foreach collection='arr' item='prod' separator=' ' index='i'> "
		,"update product set "
		//, "<if test='prod.pNo != null'> "
		, "b_code=#{prod.bCode}, season=#{prod.season}, grade=#{prod.grade}, p_name=#{prod.pName}, p_num=#{prod.pNum}, color=#{prod.color}, p_size=#{prod.pSize}, p_code=#{prod.pCode}, li_price=#{prod.liPrice}, discount=#{prod.discount}, p_price=#{prod.pPrice} "
		//, "</if> "
		//, "<where> "
		, "where "
		, "p_no = #{prod.pNo}; "
		//, "</where> "
		, "</foreach> "
		, "</script> "
	})
	int modReg(ArrayList<ProductDTO> arr);
	

}
