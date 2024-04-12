package yurp.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StoreOrderMapper {
	
	@Select("select * from rt")
	List<StoreOrderDTO> list();
	
	@Select("select * from rt where out_store != '본사'")
	List<StoreOrderDTO> rtlist();
	
	@Select("select r.r_stat,r.req_cnt,r.p_code,r.b_code,p.* "
			+ "from rtdetail r "
			+ "join product p on r.p_code = p.p_code "
			+ "where r.r_stat = #{rStat}")
	List<StoreOrderDTO> detail(String rStat);
	
	
	@Select("select * from store")
	List<StoreDTO> slist();
	

	@Select("select * from brand")
	List<BrandDTO> blist();
	
	@Select("select max(r_stat) from rt where request_date = CURDATE()")
	String maxStat();
	
	@Insert("insert into rt (r_stat,stat_cnt,stat_price,out_store,in_store,request_date,s_code) "
			+ "values (#{rStat},#{statCnt},#{statPrice},'본사','강남점',sysdate(),'yurp001')")
	int insert(StoreOrderDTO dto);
	
	
	@Insert({"<script>"
			+ "<foreach collection='rtArr' item='rt' separator=';' index='i'>"
				+ "insert into rtdetail(s_code,b_code,p_code,r_stat,req_cnt) "
				+ "values ("
				+"(select s_code from store  where s_name = #{sName}), #{rt.bCode},"
				+ "(select p_code from product where p_num = #{rt.pNum} and color = #{rt.color} and p_size = #{rt.pSize}),"
				+ "(select max(r_stat) from rt where request_date = CURDATE()),#{rt.reqCnt})"
			+ "</foreach>"
			+"</script>"})
	int detailInsert(ArrayList<StoreOrderDTO> rtArr,String rStat, String sName);
	
}


