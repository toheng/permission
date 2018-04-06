package com.hengo.service;

import com.hengo.dao.SysDeptMapper;
import com.hengo.exception.ParamException;
import com.hengo.model.SysDept;
import com.hengo.param.DeptParam;
import com.hengo.util.BeanValidator;
import com.hengo.util.LevelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Hengo.
 * 2018/4/6 20:42
 */
@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    public void save(DeptParam param) {
        BeanValidator.check(param);
        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept dept = SysDept.builder().name(param.getName()).parentId(param.getParentId())
                .seq(param.getSeq()).remark(param.getRemark()).build();

        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));
    }

    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        // TODO
        return true;
    }

    private String getLevel(Integer deptId) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }
}
