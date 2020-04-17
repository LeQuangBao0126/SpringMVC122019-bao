package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params,BuildingSearchBuilder builder) {
		
		StringBuilder sql = new StringBuilder("select * from building b"); 
		if(builder.getStaffId() != null && builder.getStaffId() != -1) {
			sql.append(" inner join assignmentbuilding ab on b.id = ab.buildingid ");
		}
		sql.append(" where 1=1 ");
		sql = createSQLfindAllcommon(sql,params);
		sql = createSQLspecial(sql,builder);
		System.out.println(sql.toString());
		Query query =  em.createNativeQuery(sql.toString(), BuildingEntity.class);
	
		return query.getResultList();
	}	
	private  StringBuilder createSQLfindAllcommon(StringBuilder sql, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] values = new Object[params.size()];
			int index = 0;
			for (Map.Entry<String, Object> item : params.entrySet()) {
				keys[index] = item.getKey();
				values[index] = item.getValue();
				index++;
			}
			for (int i = 0; i < keys.length; i++) {
				if (values[i] instanceof String) {
					if (StringUtils.isNotBlank(values[i].toString())) {
						sql.append(" and b." + keys[i] + " like '%" + values[i] + "%'");
					}
				} else {
					if (values[i] != null) {
						sql.append(" and b." + keys[i] + " = " + values[i] + "");
					}
				}
			}
		}
		return sql;
	}
	private StringBuilder createSQLspecial(StringBuilder sql, BuildingSearchBuilder builder) {
		if(StringUtils.isNotBlank(builder.getRentAreaFrom()) || StringUtils.isNotBlank(builder.getRentAreaTo())) {
			sql.append(" AND EXISTS (select * from rentarea ra where (b.id = ra.buildingid ");
			if(StringUtils.isNotBlank(builder.getRentAreaFrom())) {
				sql.append(" AND ra.value >= "+builder.getRentAreaFrom()+"");
			}
			if(StringUtils.isNotBlank(builder.getRentAreaTo())) {
				sql.append(" AND ra.value <= "+builder.getRentAreaFrom()+"");
			}
			sql.append("))");
		}
		if(builder.getTypes().length >0) {
			sql.append(" and (");
			for(String type : builder.getTypes()) {
				if(type.equals(builder.getTypes()[0])) {
				sql.append(" b.type like '%"+type+"%'");
				}else {
					sql.append(" OR ");
					sql.append(" b.type like '%"+type+"%'");
				}				
			}
			sql.append(")");
		}	
		if(StringUtils.isNotBlank(builder.getRentCostFrom()) ) {
			sql.append(" AND b.rentcost >= "+builder.getRentCostFrom()+"");
		}
		if(StringUtils.isNotBlank(builder.getRentCostTo()) ) {
			sql.append(" AND b.rentcost <= "+builder.getRentCostTo()+"");
		}
		if(builder.getStaffId() != null && builder.getStaffId() != -1) {
			sql.append(" AND ab.staffid = "+builder.getStaffId()+"");
		}
		return sql;
	}


}
