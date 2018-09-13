package com.xulizhi.demo.mapper;

import com.xulizhi.demo.domain.PaymentCategory;
import com.xulizhi.demo.domain.PaymentCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lenovo
 */
public interface PaymentCategoryMapper {
    int countByExample(PaymentCategoryExample example);

    int deleteByExample(PaymentCategoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(PaymentCategory record);

    int insertSelective(PaymentCategory record);

    List<PaymentCategory> selectByExample(PaymentCategoryExample example);

    PaymentCategory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PaymentCategory record, @Param("example") PaymentCategoryExample example);

    int updateByExample(@Param("record") PaymentCategory record, @Param("example") PaymentCategoryExample example);

    int updateByPrimaryKeySelective(PaymentCategory record);

    int updateByPrimaryKey(PaymentCategory record);
}