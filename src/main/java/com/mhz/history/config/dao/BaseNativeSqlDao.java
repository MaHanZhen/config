package com.mhz.history.config.dao;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: JPA使用原生SQL基类
 * @Auth: yuyang
 * @Date: 2017/1/18 19:30
 * @Version: 1.0
 **/
@Service
public class BaseNativeSqlDao {

    @PersistenceUnit
    private EntityManagerFactory emf;

    /**
     * 查询多个属性
     * 返回List<Object[]>数组形式的List，数组中内容按照查询字段先后
     *
     * @param sql 原生SQL语句
     * @return
     */
    public List<Object[]> queryNativeSql(String sql, Map<String, Object> param) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        setQueryParam(query, param);
        List<Object[]> list = query.getResultList();
        close(em);
        return list;
    }


    /**
     * 查询多个属性
     * 返回List<map<String,Object>数组形式的List，其中MAP的KEY全为大写
     *
     * @param sql 原生SQL语句
     * @param param 占位符参数
     * @return
     */
    public List<Map<String,Object>> queryMapNativeSql(String sql, Map<String, Object> param) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        setQueryParam(query, param);
        query.unwrap(SQLQuery.class).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List result = query.getResultList();
        close(em);
        return result;
    }


    /**
     * 查询多个属性
     * 返回List<clazz>对象形式的List，Object为Class格式对象
     *
     * @param sql   原生SQL语句
     * @param param 占位符参数
     * @return
     */
    public List queryNativeSql(Class clazz, String sql, Map<String, Object> param) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql, clazz);
        setQueryParam(query, param);

        List list = query.getResultList();
        close(em);
        return list;
    }

    /**
     * 统计原生SQL行数
     * 返回改SQL行数
     *
     * @param sql 原生SQL语句
     * @return
     */
    public Long countNativeSql(String sql, Map<String, Object> param) {
        sql = "select count(*) cnt from (" + sql + ") row_";

        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        setQueryParam(query, param);

        BigInteger count = (BigInteger) query.getSingleResult();
        close(em);

        return count.longValue();
    }

    /**
     * 查询多个属性 要查询其他分页可以参考这个
     * 返回分页信息
     *
     * @param clazz 要转换对象的class
     * @param sql   原生SQL语句
     * @param param 占位符参数
     * @param pageRequest 分页请求参数
     * @return
     */
    public Page queryNativeSql(Class clazz, String sql, Map<String, Object> param, Pageable pageRequest) {

        Long count = countNativeSql(sql, param);
        if (count == 0L) {
            PageImpl page = new PageImpl(new ArrayList(), pageRequest, count);
            return page;
        }
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql, clazz);
        query.setFirstResult(pageRequest.getPageNumber());
        query.setMaxResults(pageRequest.getPageSize());

        setQueryParam(query, param);
        List list = query.getResultList();
        PageImpl page = new PageImpl(list, pageRequest, count);
        close(em);
        return page;
    }

    private void setQueryParam(Query query, Map param) {
        if (param != null) {
            param.forEach((k, v) -> query.setParameter(k.toString(), v));
        }
    }

    private void close(EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }

}
