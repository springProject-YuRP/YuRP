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
	
	@Select("<script>"
			+ "select * from orders "
			+ "<where>"
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			+ "		<if test='start != null and start != \"\"' > "
			+ "			reg_date >= #{start} and"
			+ "		</if> "
			+ "		<if test='end != null and end != \"\"' > "
			+ "			 #{end} >= reg_date and"
			+ "		</if> "
			+ "		<if test='start != null and start != \"\" and end != null and end != \"\"' > "
			+ "			reg_date BETWEEN #{start} and #{end}"
			+ "		</if> "
			+ "	</trim>"
			+ "</where> "
			+ "</script> ")
	List<OrdersDTO> list();
	
	@Select("select p.p_num ,p.color ,p.p_size,o_stat,p.p_name,o.b_code, o.req_cnt from ordetail o "
			+ "join product p "
			+ "where o_stat = #{oStat} GROUP BY p.p_num")
	List<OrdersDTO> detail(String oStat);

	@Insert("insert into orders "
			+ "(o_stat,tot_price,tot_cnt,excel,reg_date,b_code) values "
			+ "(#{oStat},#{totPrice},#{totCnt},'엑셀경로',sysdate(),#{bCode})")
	int oinsert(OrdersDTO dto);
	
	@Insert({"<script>"
			+ "<foreach collection='ordersArr' item='order' separator=';' index='i'>"
				+ "insert into ordetail(req_cnt,b_code,p_code,o_stat) "
				+ "values (#{order.reqCnt},#{order.bCode},"
				+"(select p_code from product "
				+"where p_num = #{order.pNum} and color = #{order.color} and p_size = #{order.pSize}),"
				+ "(select max(o_stat) from orders where reg_date = CURDATE()))"
			+ "</foreach>"
			+"</script>"})
	int detailInsert(ArrayList<OrdersDTO> ordersArr);
	
	@Select("select max(o_stat) from orders where reg_date = CURDATE()")
	String maxStat();
	
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




