package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface inandoutMapper {

	@Select("<script>"
			+ "select "
			+ "io_no,  "
			+ "reg_date,  "
			+ "io_stat,  "
			+ "type1,  "
			+ "type2,  "
			+ "start,  "
			+ "arrival,  "
			+ "tot_cnt,  "
			+ "tot_price,  "
			+ "r_stat "
			+ "from inandout  "
			+ "<where>"
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			
			+ "		<if test='ioStat != null and ioStat != \"\"' > "
			+ "			io_stat like concat('%',#{ioStat},'%') and"
			+ "		</if> "
			+ "		<if test='type1 != null and type1 != \"\"' > "
			+ "			type1 like concat('%',#{type1},'%') and"
			+ "		</if> "
			
			+ "		<if test='rStat != null and rStat != \"\"' > "
			+ "			r_stat = #{rStat} and"
			+ "		</if> "
			
			+ "		<if test='sday != null and sday != \"\"' > "
			+ "			reg_date >= #{sday} and"
			+ "		</if> "
			
			+ "		<if test='eday != null and eday != \"\"' > "
			+ "			 #{eday} >= reg_date and"
			+ "		</if> "
			
			+ "		<if test='sday != null and sday != \"\" and eday != null and eday != \"\"' > "
			+ "			reg_date BETWEEN #{sday} and #{eday}"
			+ "		</if> "
			+ "	</trim>"
			+ "</where> "
			+ "</script> "
			 )
	List<inandoutDTO> list(inandoutDTO dto);
	
	@Select("<script> "
			+ "select "
			+ "sum(tot_cnt) as tot_cnt, "
			+ "sum(tot_price) as tot_price "
			+ "from inandout "
			+ "<where>"
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			
			+ "		<if test='ioStat != null and ioStat != \"\"' > "
			+ "			io_stat like concat('%',#{ioStat},'%') and"
			+ "		</if> "
			+ "		<if test='type1 != null and type1 != \"\"' > "
			+ "			type1 like concat('%',#{type1},'%') and"
			+ "		</if> "
			
			+ "		<if test='rStat != null and rStat != \"\"' > "
			+ "			r_stat = #{rStat} and"
			+ "		</if> "
			
			+ "		<if test='sday != null and sday != \"\"' > "
			+ "			reg_date >= #{sday} and"
			+ "		</if> "
			
			+ "		<if test='eday != null and eday != \"\"' > "
			+ "			 #{eday} >= reg_date and"
			+ "		</if> "
			
			+ "		<if test='sday != null and sday != \"\" and eday != null and eday != \"\"' > "
			+ "			reg_date BETWEEN #{sday} and #{eday}"
			+ "		</if> "
			+ "	</trim>"
			+ "</where> "
			+ "</script> "
			 )
	List<inandoutDTO> tot(inandoutDTO dto);
	

	
}
