package cn.sisyphe.demo.core.base.service;

import cn.sisyphe.demo.core.base.Pagination;
import cn.sisyphe.demo.core.base.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ：Jerry
 * @date ：Created in 2019/5/8 17:14
 * @description：${description}
 */
public class BaseServiceImpl<M extends BaseMapper<E>, E> implements BaseService<E> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected M mapper;

    @Override
    public void save(E entity) {
        mapper.insertSelective(entity);
    }

    @Override
    public void save(List<E> entities) {
        mapper.insertList(entities);
    }

    @Override
    public void update(E entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void remove(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public E get(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<E> list() {
        return mapper.selectAll();
    }

    @Override
    public List<E> listByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public List<E> listByEntity(E entity) {
        return mapper.select(entity);
    }

    @Override
    public List<E> listByExample(Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public PageInfo<E> listByPage(Pagination pagination) {
        return PageHelper
                .offsetPage(pagination.getOffset(), pagination.getLimit())
                .doSelectPageInfo(() -> mapper.selectAll());
    }

    @Override
    public PageInfo<E> listByEntityAndPage(E entity, Pagination pagination) {
        return PageHelper
                .offsetPage(pagination.getOffset(), pagination.getLimit())
                .doSelectPageInfo(() -> mapper.select(entity));
    }

    @Override
    public PageInfo<E> listByExampleAndPage(Example example, Pagination pagination) {
        return PageHelper
                .offsetPage(pagination.getOffset(), pagination.getLimit())
                .doSelectPageInfo(() -> mapper.selectByExample(example));
    }

    @Override
    public int count() {
        return mapper.selectCount(null);
    }
}
