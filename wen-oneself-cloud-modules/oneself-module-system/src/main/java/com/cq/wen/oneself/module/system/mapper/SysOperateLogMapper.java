package com.cq.wen.oneself.module.system.mapper;

import com.cq.wen.oneself.module.system.entity.SysOperateLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 操作日志记录(SysOperateLog)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-19 23:51:43
 */
@Mapper
public interface SysOperateLogMapper extends BaseMapper<SysOperateLog> {

}

