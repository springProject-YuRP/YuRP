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
			+ "select * from product "
			+ "<where> "
			+ "<if test='pCode != null and pCode != \"\"'> "
			+ "p_code like concat('%',#{pCode},'%') "
			+ "</if>"
			+ "</where>"
			+ "</script>")
	List<ProductDTO> list(ProductDTO dto);
	
	@Select("select p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, li_price, i.cnt, i.i_no  "
			+ "from product p "
			+ "join inventory i "
			+ "where i.p_code = p.p_code and i.s_code  = 'admin'")
	List<ProductDTO> prodList(ProductDTO dto);
	
	@Select("select * from brand")
	List<BrandDTO> brandList();
	
	
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
	

//	@Update({
//		" <script> "
//		, "<foreach collection='arr' item='prod' separator=',' index='i'> "
//		,"update product set "
//		//, "<if test='prod.pNo != null'> "
//		, "b_code=#{prod.bCode}, season=#{prod.season}, grade=#{prod.grade}, p_name=#{prod.pName}, p_num=#{prod.pNum}, color=#{prod.color}, p_size=#{prod.pSize}, p_code=#{prod.pCode}, li_price=#{prod.liPrice}, discount=#{prod.discount}, p_price=#{prod.pPrice} "
//		//, "</if> "
//		//, "<where> "
//		, "where "
//		, "p_no = #{prod.pNo}"
//		//, "</where> "
//		, "</foreach> "
//		, "</script> "
//	})
//	int modReg(ArrayList<ProductDTO> arr);
	

}
