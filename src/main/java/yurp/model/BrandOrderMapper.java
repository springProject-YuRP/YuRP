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
	List<OrdersDTO> list();
	

	@Insert("insert into orders "
			+ "(o_stat,tot_price,tot_cnt,excel,reg_date,b_code) values "
			+ "(#{oStat},#{totPrice},#{totCnt},'엑셀경로',sysdate(),#{bCode})")
	int oinsert(OrdersDTO dto);
	
//	@Insert({"<script>"
//			+ "<foreach collection='ordersArr' item='order' separator=';' index='i'>"
//				+ "insert into ordetail(req_cnt,b_code,p_code,o_stat) "
//				+ "values (#{order.reqCnt},#{order.bCode},"
//				+"(select p_code from product "
//				+"where p_num = #{order.pNum} and color = #{order.color} and p_size = #{order.pSize}),'20240412-0001')"
//			+ "</foreach>"
//			+"</script>"})
	@Insert({"<script>"
			+ "<foreach collection='ordersArr' item='order' separator=';' index='i'>"
				+ "insert into ordetail(req_cnt,b_code,p_code,o_stat) "
				+ "values (#{order.reqCnt},#{order.bCode},"
				+"#{order.pCode},'20240412-0002')"
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




